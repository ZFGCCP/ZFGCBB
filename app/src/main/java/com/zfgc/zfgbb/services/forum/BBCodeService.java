package com.zfgc.zfgbb.services.forum;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.dataprovider.forum.BBCodeDataProvider;
import com.zfgc.zfgbb.model.forum.BBCodeAttribute;
import com.zfgc.zfgbb.model.forum.BBCodeAttributeMode;
import com.zfgc.zfgbb.model.forum.BBCodeConfig;
import com.zfgc.zfgbb.util.ZfgcStringUtils;

import jakarta.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class BBCodeService {

	public Map<String, BBCodeConfig> validBbCodes = new HashMap<>();
	public Map<String, Integer> bbCodeCounts = new HashMap<>();
	private Boolean outputContent = true;
	private Logger LOGGER = LogManager.getLogger(BBCodeService.class);

	@Autowired
	BBCodeDataProvider bbCodeDataProvider;

	@Autowired
	BBCodeOutputSanitizer outputSanitizer;

	@Autowired
	QuotedMessageLookup quotedMessageLookup;

	private static final Pattern QUOTE_MSG_ID = Pattern.compile(
			"\\[quote\\b[^\\]]*\\bmsg=(\\d+)", Pattern.CASE_INSENSITIVE);
	private static final DateTimeFormatter QUOTE_DATE_FORMATTER =
			DateTimeFormatter.ofPattern("h:mm:ss a");
	private static final DateTimeFormatter QUOTE_DATE_FORMATTER_FULL =
			DateTimeFormatter.ofPattern("MMMM d, yyyy, h:mm:ss a");

	private final ThreadLocal<Map<Integer, QuotedMessageLookup.Resolved>> resolvedQuotes = new ThreadLocal<>();

	public String parseText(String input) {
		if (input == null) {
			return "";
		}

		resolvedQuotes.set(resolveQuotedMessages(input));
		try {
			return parseTextInternal(input);
		} finally {
			resolvedQuotes.remove();
		}
	}

	private Map<Integer, QuotedMessageLookup.Resolved> resolveQuotedMessages(String input) {
		Set<Integer> ids = new HashSet<>();
		Matcher m = QUOTE_MSG_ID.matcher(input);
		while (m.find()) {
			try {
				ids.add(Integer.parseInt(m.group(1)));
			} catch (NumberFormatException ignore) {}
		}
		if (ids.isEmpty() || quotedMessageLookup == null) {
			return Map.of();
		}
		return quotedMessageLookup.resolve(ids);
	}

	private String parseTextInternal(String input) {
		char[] inputChar = null;

		try {
			inputChar = ZfgcStringUtils.getUnderlyingStringArray(input.replace("\n", "<br/>"));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		final int length = inputChar.length;
		final MutableInt NEG = new MutableInt(-1);
		StringBuilder output = new StringBuilder();
		StringBuilder currentBuffer = new StringBuilder();
		StringBuilder sideBuffer = new StringBuilder();
		String currentState = null;
		String currentCode = null;
		int lastKnownFreshPosition = 0;
		int i = 0;
		int openBracePos = -1;
		int closeBracePos = -1;
		int attributeBeginPos = -1;
		Stack<String> states = new Stack<>();
		Stack<String> codes = new Stack<>();
		Stack<String> closeTags = new Stack<>();
		MutableInt contentAttPos = new MutableInt(-1);

		for (i = 0; i < length; i++) {
			boolean isClosingBrace = false;
			// did we find a bbcode? maybe..
			if (inputChar[i] == '[') {
				String bbCodetest = "";
				i++;

				// '[' as the final char (e.g. ':-[' emoticon at end of post) — flush
				// remainder as literal text and stop instead of reading past the buffer.
				if (i >= length) {
					currentBuffer.append(inputChar, lastKnownFreshPosition, length - lastKnownFreshPosition);
					break;
				}

				// hold the phone, this might be a closing brace
				if (inputChar[i] == '/') {
					isClosingBrace = true;
					closeBracePos = i - 1;
					i++;
				} else {
					openBracePos = i - 1;
				}

				// get the alphabetical characters immediately following the brace
				// edge case: we hit the end of the string
				do {
					if (i > length) {
						currentBuffer.append(inputChar, lastKnownFreshPosition, --i);
						break;
					}

					bbCodetest += inputChar[i];
					i++;
				} while ((Character.toLowerCase(inputChar[i]) >= 'a' && Character.toLowerCase(inputChar[i]) <= 'z')
						&& (inputChar[i] != ' ' && inputChar[i] != '='));

				bbCodetest = bbCodetest.toUpperCase();
				// check if this matches a valid bbcode. If so, find the next ]
				// edge cases: we hit the end of the string, or we hit another [
				// or we're already in a close brace
				if (bbCodeCounts.keySet().contains(bbCodetest)) {
					attributeBeginPos = i;
					boolean foundBbCode = true;
					while (inputChar[i] != ']') {
						if (i > length || inputChar[i] == '[') {
							currentBuffer.append(inputChar, lastKnownFreshPosition, (--i) - lastKnownFreshPosition);
							foundBbCode = false;
							break;
						}
						i++;
					}

					if (foundBbCode) {
						if (isClosingBrace) {
							if (currentCode == null)
								continue;

							if (states.size() == 0 || (!currentCode.equals(bbCodetest)
									&& validBbCodes.get(currentCode).getProcessContentFlag())) {// we've got a stray
																								// closing tag
								output.append(inputChar, lastKnownFreshPosition, i - lastKnownFreshPosition + 1);
								lastKnownFreshPosition = i + 1;

								// revert to the previous state if one exists

								if (states.size() > 0) {
									output.append(closeTags.isEmpty()
											? validBbCodes.get(bbCodetest).getEndTag()
											: closeTags.pop());
									bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) - 1);
									states.pop();
									codes.pop();
									if (states.size() == 0) {
										currentState = "";
										currentCode = "";
									} else {
										currentState = states.peek();
										currentCode = codes.peek();
									}
								}
							} else if (currentCode.equals(bbCodetest)) {// this is a matched closing tag
								// revert to previous state

								if (validBbCodes.get(currentCode).getProcessContentFlag()
										|| (currentCode + "0").equals(states.peek())) {

									if (contentAttPos.compareTo(NEG) > 0) {
										sideBuffer.append(inputChar, lastKnownFreshPosition,
												closeBracePos - lastKnownFreshPosition);
										output.replace(contentAttPos.intValue(), contentAttPos.intValue() + 5,
												sideBuffer.toString());
										contentAttPos.setValue(-1);
										sideBuffer.delete(0, sideBuffer.length());
									}

									if (outputContent) {
										output.append(inputChar, lastKnownFreshPosition,
												closeBracePos - lastKnownFreshPosition);
									}
									output.append(closeTags.isEmpty()
											? validBbCodes.get(bbCodetest).getEndTag()
											: closeTags.pop());
									lastKnownFreshPosition = i + 1;
									outputContent = true;
								}

								bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) - 1);
								states.pop();
								codes.pop();
								if (states.size() == 0) {
									currentState = "";
									currentCode = "";
								} else {
									currentState = states.peek();
									currentCode = codes.peek();
								}
							}
						} else if (Boolean.TRUE.equals(validBbCodes.get(bbCodetest).getSelfClosingFlag())) {
							if (lastKnownFreshPosition != openBracePos) {
								output.append(inputChar, lastKnownFreshPosition,
										openBracePos - lastKnownFreshPosition);
							}
							output.append(validBbCodes.get(bbCodetest).getEndTag());
							lastKnownFreshPosition = i + 1;
						} else {
							// just doing this lazy for now...
							if (currentCode == null || currentCode.equals("")
									|| validBbCodes.get(currentCode).getProcessContentFlag()) {
								char[] attributes = new char[i - attributeBeginPos];
								for (int j = 0; j < i - attributeBeginPos; j++) {
									attributes[j] = inputChar[attributeBeginPos + j];
								}

								String[] matchedCloseTag = new String[] { null };
								String parsedTag = processAttributes(validBbCodes.get(bbCodetest), attributes,
										contentAttPos, matchedCloseTag);

								// state change
								// record whatever we found up to this point
								// replace the bbcode with its html opening
								if (states.size() == 0 || validBbCodes.get(currentCode).getProcessContentFlag()) {
									if (lastKnownFreshPosition != openBracePos) {
										output.append(inputChar, lastKnownFreshPosition,
												openBracePos - lastKnownFreshPosition);
									}
									output.append(parsedTag);

									contentAttPos.setValue(output.indexOf("{{c}}"));
									// if(states.size() == 0 ||
									// !validBbCodes.get(currentCode).getProcessContentFlag()){
									currentCode = bbCodetest;
									// }
									lastKnownFreshPosition = i + 1;
								}

								currentState = bbCodetest + bbCodeCounts.get(bbCodetest);
								states.push(currentState);
								codes.push(bbCodetest);
								closeTags.push(matchedCloseTag[0] != null
										? matchedCloseTag[0]
										: validBbCodes.get(bbCodetest).getEndTag());
								bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) + 1);
							}
						}
					}
				} else { // it wasn't actually a bbcode..output what we found up to this point
							// int start = isClosingBrace ? closeBracePos : openBracePos;
					output.append(inputChar, lastKnownFreshPosition, i - lastKnownFreshPosition);
					lastKnownFreshPosition = i;
				}
			}
		}

		// if we reach the end, but we're not in a bbcode state
		// append the remaining junk
		output.append(inputChar, lastKnownFreshPosition, length - lastKnownFreshPosition);

		// if we have any unfinished states, close them out
		while (!codes.isEmpty()) {
			String code = codes.pop();
			output.append(closeTags.isEmpty()
					? validBbCodes.get(code).getEndTag()
					: closeTags.pop());
			states.pop();
		}

		resetCounts();

		return outputSanitizer.sanitize(output.toString());
	}

	public String processAttributes(BBCodeConfig bbCode, char[] attributes, MutableInt contentAttPos) {
		return processAttributes(bbCode, attributes, contentAttPos, null);
	}

	public String processAttributes(BBCodeConfig bbCode, char[] attributes, MutableInt contentAttPos,
			String[] matchedCloseTagOut) {
		String[] allAttributeNames = bbCode.getAllAttributeNamesAsString().split(",");
		Map<String, String> attributeValues = new TreeMap<>();
		String atts = new String(attributes);

		TreeMap<Integer, String> namesByPos = new TreeMap<>();
		for (String attName : allAttributeNames) {
			if (attName.isEmpty()) {
				continue;
			}
			if (attName.equals("=")) {
				if (atts.startsWith("=")) {
					namesByPos.put(0, attName);
				}
				continue;
			}
			int pos = atts.indexOf(attName);
			while (pos != -1) {
				if (pos == 0 || Character.isWhitespace(atts.charAt(pos - 1))) {
					namesByPos.put(pos, attName);
					break;
				}
				pos = atts.indexOf(attName, pos + 1);
			}
		}

		Integer[] positions = namesByPos.keySet().toArray(new Integer[0]);
		for (int i = 0; i < positions.length; i++) {
			int start = positions[i];
			String name = namesByPos.get(start);
			int valueStart = start + name.length();
			int valueEnd = (i + 1 < positions.length) ? positions[i + 1] : atts.length();
			String value = atts.substring(valueStart, valueEnd).trim();
			attributeValues.put(name, value);
		}

		StringBuilder attFormat = new StringBuilder();
		for (String attName : allAttributeNames) {
			if (attributeValues.containsKey(attName)) {
				attFormat.append(attName);
			}
		}

		if (!bbCode.getAttributeConfig().containsKey(attFormat.toString())) {
			return atts;
		}

		BBCodeAttributeMode attMode = bbCode.getAttributeConfig().get(attFormat.toString());
		if (matchedCloseTagOut != null && matchedCloseTagOut.length > 0) {
			matchedCloseTagOut[0] = attMode.getCloseTag();
		}
		StringBuilder result = new StringBuilder();
		result.append(attMode.getOpenTag());
		String output = result.toString();

		long namelessCount = attMode.getAttributes().stream()
				.filter(a -> "=".equals(a.getName())).count();
		String[] namelessParts = null;
		int namelessIdx = 0;

		for (int i = 0; i < attMode.getAttributes().size(); i++) {
			BBCodeAttribute attribute = attMode.getAttributes().get(i);
			String attName = attribute.getName();
			String rawValue;
			if ("=".equals(attName) && namelessCount > 1) {
				if (namelessParts == null) {
					String full = attributeValues.get("=");
					namelessParts = full == null ? new String[0] : full.split(",", -1);
				}
				rawValue = namelessIdx < namelessParts.length ? namelessParts[namelessIdx] : "";
				namelessIdx++;
			} else {
				rawValue = attributeValues.get(attName);
			}
			String value = attribute.transformValue(rawValue);
			output = output.replace(attribute.getAttributeIndex(), value);
		}

		if (output.contains("{{msg.")) {
			output = resolveQuoteMsgPlaceholders(output, attributeValues.get("msg="));
		}

		if (attMode.getContentIsAttributeFlag()) {
			contentAttPos.setValue(output.indexOf("{{c}}"));

			if (!attMode.getOutputContentFlag()) {
				outputContent = false;
			}
		}

		return output.toString();
	}

	private String resolveQuoteMsgPlaceholders(String output, String msgIdString) {
		QuotedMessageLookup.Resolved resolved = null;
		Map<Integer, QuotedMessageLookup.Resolved> map = resolvedQuotes.get();
		if (map != null && msgIdString != null) {
			try {
				resolved = map.get(Integer.parseInt(msgIdString.trim()));
			} catch (NumberFormatException ignore) {}
		}

		String author = resolved != null && resolved.authorDisplayName() != null
				? escapeHtml(resolved.authorDisplayName())
				: "(unknown)";
		String date = resolved != null && resolved.createdTs() != null
				? formatQuoteDate(resolved.createdTs())
				: "";

		return output.replace("{{msg.author}}", author)
				.replace("{{msg.date}}", date);
	}

	private static String formatQuoteDate(OffsetDateTime ts) {
		LocalDate today = LocalDate.now();
		LocalDate that = ts.toLocalDate();
		if (that.equals(today)) {
			return "Today at " + QUOTE_DATE_FORMATTER.format(ts).toLowerCase();
		}
		if (that.equals(today.minusDays(1))) {
			return "Yesterday at " + QUOTE_DATE_FORMATTER.format(ts).toLowerCase();
		}
		return QUOTE_DATE_FORMATTER_FULL.format(ts);
	}

	private static String escapeHtml(String value) {
		StringBuilder out = new StringBuilder(value.length());
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			switch (c) {
			case '<': out.append("&lt;"); break;
			case '>': out.append("&gt;"); break;
			case '"': out.append("&quot;"); break;
			case '\'': out.append("&#39;"); break;
			case '&': out.append("&amp;"); break;
			default: out.append(c);
			}
		}
		return out.toString();
	}

	private void resetCounts() {
		for (String x : bbCodeCounts.keySet()) {
			bbCodeCounts.put(x, 0);
		}
	}

	@PostConstruct
	public void loadBbCodeConfig() {
		LOGGER.info("Loading Bbcode config...");

		validBbCodes = bbCodeDataProvider.getBbCodeConfig();

		for (String code : validBbCodes.keySet()) {
			bbCodeCounts.put(code, 0);
		}

		LOGGER.info("Finished loading Bbcode config.");
	}

}