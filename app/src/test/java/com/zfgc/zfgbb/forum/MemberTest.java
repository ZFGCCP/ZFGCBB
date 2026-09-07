package com.zfgc.zfgbb.forum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.zfgc.zfgbb.testsupport.PostgresIntegrationTest;

import tools.jackson.databind.JsonNode;

class MemberTest extends PostgresIntegrationTest {

	private static final int GENERAL_BOARD_ID = 1;
	private static final int ZFGC_USER_PERMISSION_ID = 1;
	private static final int ZFGC_GUEST_PERMISSION_ID = 2;

	private void postThreadWithOpeningMessage(String token, String threadName, String body) throws Exception {
		String threadJson = """
				{"threadName": "%s", "messages": [{"currentMessage": {"unparsedText": "%s"}}]}
				""".formatted(threadName, body);
		mockMvc.perform(post("/thread")
				.param("boardId", String.valueOf(GENERAL_BOARD_ID))
				.header("Authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)
				.content(threadJson))
				.andExpect(status().isOk());
	}

	private JsonNode postHistoryOf(int authorUserId, Optional<String> viewerToken) throws Exception {
		MockHttpServletRequestBuilder request = get("/message/user/" + authorUserId);
		viewerToken.ifPresent(token -> request.header("Authorization", "Bearer " + token));
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		return json.readTree(result.getResponse().getContentAsString());
	}

	@Test
	void postHistoryExcludesMessagesFromBoardsTheViewerCannotSee() throws Exception {
		TestUser author = createUser("hidden_hist_" + suffix);
		TestUser outsider = createUser("hidden_out_" + suffix);
		String openingBody = "hidden history body " + suffix;
		postThreadWithOpeningMessage(author.token(), "Hidden history " + suffix, openingBody);

		testFixtureSetupMapper.resetBoardPermissions();

		assertEquals(0, postHistoryOf(author.id(), Optional.empty()).size(),
				"a guest must not see post history from a board with no guest grant");
		assertEquals(0, postHistoryOf(author.id(), Optional.of(outsider.token())).size(),
				"a member without a board grant must not see post history from that board");
		assertEquals(0, postHistoryOf(author.id(), Optional.of(author.token())).size(),
				"even the author's own history stays hidden when the board is invisible to them");

		testFixtureSetupMapper.grantBoardPermissionIfAbsent(GENERAL_BOARD_ID, ZFGC_USER_PERMISSION_ID);

		JsonNode memberView = postHistoryOf(author.id(), Optional.of(outsider.token()));
		assertEquals(1, memberView.size(), "a member holding the board grant must see the post history");
		assertTrue(memberView.get(0).get("currentMessage").get("messageText").asString().contains(openingBody),
				"the visible history entry must carry the rendered message body");
		assertEquals(0, postHistoryOf(author.id(), Optional.empty()).size(),
				"granting members access must not open the board to guests");

		testFixtureSetupMapper.grantBoardPermissionIfAbsent(GENERAL_BOARD_ID, ZFGC_GUEST_PERMISSION_ID);

		assertEquals(1, postHistoryOf(author.id(), Optional.empty()).size(),
				"a guest sees the post history once the board carries the guest grant");
	}
}
