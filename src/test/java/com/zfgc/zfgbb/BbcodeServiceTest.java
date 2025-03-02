package com.zfgc.zfgbb;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import com.zfgc.zfgbb.model.forum.AttributeDataType;
import com.zfgc.zfgbb.model.forum.BBCodeAttribute;
import com.zfgc.zfgbb.model.forum.BBCodeAttributeMode;
import com.zfgc.zfgbb.model.forum.BBCodeConfig;
import com.zfgc.zfgbb.services.forum.BBCodeService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BbcodeServiceTest {
	static BBCodeService service = new BBCodeService();
	static BBCodeConfig bbCodeQuote = null;
	static BBCodeConfig bbCodeCode = null;
	static BBCodeConfig bbCodeB = null;
	static BBCodeConfig bbCodeI = null;
	static BBCodeConfig bbCodeU = null;
	static BBCodeConfig bbCodeUrl = null;
	static BBCodeConfig bbCodeImg = null;
	
	private static void initU(){
		bbCodeU = new BBCodeConfig();
		bbCodeU.setAllAttributeNamesAsString("");
		
		BBCodeAttributeMode mode0 = new BBCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-u'>");
		mode0.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeU.setAttributeConfig(new HashMap<>());
		bbCodeU.getAttributeConfig().put("",mode0);
		bbCodeU.setCode("u");
		bbCodeU.setProcessContentFlag(true);
		bbCodeU.setEndTag("</span>");
		
		bbCodeU.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("u", bbCodeU);
		service.bbCodeCounts.put("u", 0);
	}
	
	private static void initI(){
		bbCodeI = new BBCodeConfig();
		bbCodeI.setAllAttributeNamesAsString("");
		
		BBCodeAttributeMode mode0 = new BBCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-i'>");
		mode0.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeI.setAttributeConfig(new HashMap<>());
		bbCodeI.getAttributeConfig().put("",mode0);
		bbCodeI.setCode("i");
		bbCodeI.setProcessContentFlag(true);
		bbCodeI.setEndTag("</span>");
		
		bbCodeI.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("i", bbCodeI);
		service.bbCodeCounts.put("i", 0);
	}
	
	private static void initB(){
		bbCodeB = new BBCodeConfig();
		bbCodeB.setAllAttributeNamesAsString("");
		
		BBCodeAttributeMode mode0 = new BBCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-b'>");
		mode0.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeB.setAttributeConfig(new HashMap<>());
		bbCodeB.getAttributeConfig().put("",mode0);
		bbCodeB.setCode("b");
		bbCodeB.setProcessContentFlag(true);
		bbCodeB.setEndTag("</span>");
		
		bbCodeB.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("b", bbCodeB);
		service.bbCodeCounts.put("b", 0);
	}
	
	private static void initCode(){
		bbCodeCode = new BBCodeConfig();
		bbCodeCode.setAllAttributeNamesAsString("");
		
		BBCodeAttributeMode mode0 = new BBCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>");
		mode0.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeCode.setAttributeConfig(new HashMap<>());
		bbCodeCode.getAttributeConfig().put("",mode0);
		bbCodeCode.setCode("code");
		bbCodeCode.setProcessContentFlag(false);
		bbCodeCode.setEndTag("</span>");
		
		bbCodeCode.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("code", bbCodeCode);
		service.bbCodeCounts.put("code", 0);
	}
	
	private static void initQuote(){
		bbCodeQuote = new BBCodeConfig();
		bbCodeQuote.setAllAttributeNamesAsString("author=,link=,time=,=");
		
		BBCodeAttributeMode mode0 = new BBCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-quote-header'><a href='{{1}}'>Authored by {{0}} at {{2}}</a></span><span class='bbcode-quote-block'>");
		mode0.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode0Att = new ArrayList<>();
		BBCodeAttribute author = new BBCodeAttribute();
		author.setAttributeIndex("{{0}}");
		author.setDataType(AttributeDataType.TEXT);
		author.setName("author=");
		
		BBCodeAttribute link = new BBCodeAttribute();
		link.setAttributeIndex("{{1}}");
		link.setDataType(AttributeDataType.TEXT);
		link.setName("link=");
		
		BBCodeAttribute time = mock(BBCodeAttribute.class);
		when(time.getAttributeIndex()).thenReturn("{{2}}");
		when(time.getAttributeDataType()).thenReturn(AttributeDataType.TIMESTAMP.ordinal());
		when(time.getName()).thenReturn("time=");
		when(time.createDate(any(String.class))).thenReturn("05/12/2017 01:28:23");
		when(time.transformValue(any(String.class))).thenCallRealMethod();
		Field dataType = ReflectionUtils.findField(BBCodeAttribute.class, "dataType");
		dataType.setAccessible(true);
		ReflectionUtils.setField(dataType, time, AttributeDataType.TIMESTAMP );
		
		mode0Att.add(author);
		mode0Att.add(link);
		mode0Att.add(time);
		
		mode0.setAttributes(mode0Att);
		bbCodeQuote.setAttributeConfig(new HashMap<>());
		bbCodeQuote.getAttributeConfig().put("author=link=time=",mode0);
		bbCodeQuote.setCode("quote");
		bbCodeQuote.setProcessContentFlag(true);
		bbCodeQuote.setEndTag("</span>");
		
		BBCodeAttributeMode mode1 = new BBCodeAttributeMode();
		mode1.setOpenTag("<span class='bbcode-quote-header'>Authored by {{0}}</span><span class='bbcode-quote-block'>");
		mode1.setCloseTag("</span>");
		
		List<BBCodeAttribute> mode1Att = new ArrayList<>();
		BBCodeAttribute author1 = new BBCodeAttribute();
		author1.setAttributeIndex("{{0}}");
		author1.setDataType(AttributeDataType.TEXT);
		author1.setName("author=");
		mode1Att.add(author1);
		
		mode1.setAttributes(mode1Att);
		bbCodeQuote.getAttributeConfig().put("author=",mode1);
		
		BBCodeAttributeMode modeNameless = new BBCodeAttributeMode();
		modeNameless.setOpenTag("<span class='bbcode-quote-header'>Authored by {{0}}</span><span class='bbcode-quote-block'>");
		modeNameless.setCloseTag("</span>");
		
		List<BBCodeAttribute> modeNamelessAtt = new ArrayList<>();
		BBCodeAttribute nameless = new BBCodeAttribute();
		nameless.setAttributeIndex("{{0}}");
		nameless.setDataType(AttributeDataType.TEXT);
		nameless.setName("=");
		modeNamelessAtt.add(nameless);
		
		modeNameless.setAttributes(modeNamelessAtt);
		bbCodeQuote.getAttributeConfig().put("=", modeNameless);
		
		BBCodeAttributeMode empty = new BBCodeAttributeMode();
		empty.setOpenTag("<span class='bbcode-quote-header'>Quote</span><span class='bbcode-quote-block'>");
		empty.setCloseTag("</span>");
		bbCodeQuote.getAttributeConfig().put("", empty);
		
		service.validBbCodes.put("quote", bbCodeQuote);
		service.bbCodeCounts.put("quote", 0);
	}
	
	private static void initUrl(){
		bbCodeUrl = new BBCodeConfig();
		bbCodeUrl.setAllAttributeNamesAsString("=");
		bbCodeUrl.setCode("url");
		bbCodeUrl.setProcessContentFlag(true);
		bbCodeUrl.setEndTag("</a>");
		
		BBCodeAttributeMode modeNameless = new BBCodeAttributeMode();
		modeNameless.setOpenTag("<a href='{{0}}'>");
		modeNameless.setCloseTag("</a>");
		BBCodeAttribute nameless = new BBCodeAttribute();
		nameless.setAttributeIndex("{{0}}");
		nameless.setDataType(AttributeDataType.TEXT);
		nameless.setName("=");
		modeNameless.setAttributes(Arrays.asList(nameless));
		
		bbCodeUrl.getAttributeConfig().put("=", modeNameless);
		
		
		BBCodeAttributeMode empty = new BBCodeAttributeMode();
		empty.setOpenTag("<a href='{{c}}'>");
		empty.setCloseTag("</span>");
		empty.setContentIsAttributeFlag(true);
		bbCodeUrl.getAttributeConfig().put("", empty);
		
		service.validBbCodes.put("url", bbCodeUrl);
		service.bbCodeCounts.put("url", 0);
	}
	
	private static void initImg(){
		bbCodeImg = new BBCodeConfig();
		bbCodeImg.setAllAttributeNamesAsString("");
		bbCodeImg.setCode("img");
		bbCodeImg.setProcessContentFlag(false);
		bbCodeImg.setEndTag("</span>");
		
		BBCodeAttributeMode none = new BBCodeAttributeMode();
		none.setOpenTag("<span class='bbcode-img'><img src='{{c}}'/>");
		none.setCloseTag("</span>");
		none.setContentIsAttributeFlag(true);
		none.setOutputContentFlag(false);
		bbCodeImg.getAttributeConfig().put("", none);
		
		service.validBbCodes.put("img", bbCodeImg);
		service.bbCodeCounts.put("img", 0);
	}
	
	@BeforeAll
	public static void initialize(){
		initQuote();
		initCode();
		initB();
		initI();
		initU();
		initUrl();
		initImg();
	}
	
	@Test
	public void parseTextMode1Code(){
		try {
			String result = service.parseText("[quote author=test]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by test</span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextMode0Code(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void processAttributesAllValidMode0(){
		String attributes = "author=MG-Zero link=thread/99 time=1494552503000";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>"));
	}
	
	@Test
	public void processAttributesAllValidMode1(){
		String attributes = "author=MG-Zero";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>"));
	}
	
	@Test
	public void processAttributesOneInvalid(){
		String attributes = "autor=test link=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void processAttributeskippedOne(){
		String attributes = "autor=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void processAttributesOutOfOrder(){
		String attributes = "link=test author=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void processAttributesNamelessExtra(){
		String attributes = "=x link=test author=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray(),new MutableInt());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void parseTextQuoteEmbeddedMode0(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000][quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote][/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'><span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span></span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void parseTextCode(){
		try {
			String result = service.parseText("[code]test[/code]");
			
			assertTrue(result.equals("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextCodeEmbedded(){
		try {
			String result = service.parseText("[code]test[code]test[quote][/code]");
			

			assertTrue(result.equals("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test[code]test[quote]</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextQuoteNoParam(){
		try {
			String result = service.parseText("[quote]test[/quote]");
			

			assertTrue(result.equals("<span class='bbcode-quote-header'>Quote</span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextQuoteTwo(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote][quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span><span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosing(){
		try {
			String result = service.parseText("This is my [/quote] house");
			
			assertTrue(result.equals("This is my [/quote] house"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayOpening(){
		try {
			String result = service.parseText("This is my [code] house");
			
			assertTrue(result.equals("This is my <span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'> house</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosingEmbedded(){
		try {
			String result = service.parseText("[quote author=MG-Zero]This is [/code] my house[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>This is [/code]</span> my house[/quote]"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayMismatched(){
		try {
			String result = service.parseText("[b][i]This is my house[/b][/i]");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-i'>This is my house[/b]</span>[/i]</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosingOutside(){
		try {
			String result = service.parseText("[quote author=MG-Zero]This is my house[/quote][/code]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>This is my house</span>[/code]"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextMattyBoyTestBadInput(){
		try {
			String result = service.parseText("[b][code]test[/code][/b][b]hey[b]yo[b]wassup[b][i][u]bitch!!![/i][/u][/b][/b][/b][/b]  [i][u]yeah man[/i][/u] ");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span></span><span class='bbcode-b'>hey<span class='bbcode-b'>yo<span class='bbcode-b'>wassup<span class='bbcode-b'><span class='bbcode-i'><span class='bbcode-u'>bitch!!![/i]</span>[/u]</span></span></span></span></span>  <span class='bbcode-i'><span class='bbcode-u'>yeah man[/i]</span>[/u]</span> "));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void parseTextMattyBoyTestGoodInput(){
		try {
			String result = service.parseText("[b][code]test[/code][/b][b]hey[b]yo[b]wassup[b][i][u]bitch!!![/u][/i][/b][/b][/b][/b]  [i][u]yeah man[/u][/i] o");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span></span><span class='bbcode-b'>hey<span class='bbcode-b'>yo<span class='bbcode-b'>wassup<span class='bbcode-b'><span class='bbcode-i'><span class='bbcode-u'>bitch!!!</span></span></span></span></span></span>  <span class='bbcode-i'><span class='bbcode-u'>yeah man</span></span> o"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void parseTextNamelessAttribute(){
		try {
			String result = service.parseText("[quote=MGZero]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MGZero</span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextUrlContent(){
		try {
			String result = service.parseText("[url]http://zfgc.com[/url]");
			
			assertTrue(result.equals("<a href='http://zfgc.com'>http://zfgc.com</a>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextUrlContentEmbedded(){
		try {
			String result = service.parseText("[url][b]http://zfgc.com[/b][/url]");
			
			assertTrue(result.equals("<a href='http://zfgc.com'><span class='bbcode-b'>http://zfgc.com</span></a>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextUrlImgEmbedded(){
		try {
			String result = service.parseText("[url=https://somelink.com][img]https://someimg.jpg[/img][/url]");
			
			assertTrue(result.equals("<a href='https://somelink.com'><span class='bbcode-img'><img src='https://someimg.jpg'/></span></a>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextUrlContentEmbeddedStray(){
		try {
			String result = service.parseText("[url][/b]http://zfgc.com[/url]");
			
			assertTrue(result.equals("<a href='[/b]http://zfgc.com'>[/b]http://zfgc.com</a>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextImg(){
		try {
			String result = service.parseText("[img]http://zfgc.com[/img]");
			
			assertTrue(result.equals("<span class='bbcode-img'><img src='http://zfgc.com'/></span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextImgStrayEmbedded(){
		try {
			String result = service.parseText("[img][/b]http://zfgc.com[/img]");
			
			assertTrue(result.equals("<span class='bbcode-img'><img src='[/b]http://zfgc.com'/></span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}