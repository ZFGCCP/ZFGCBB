package com.zfgc.zfgbb.testsupport;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

import com.zfgc.zfgbb.dbo.*;
import com.zfgc.zfgbb.mappers.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.MountableFile;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
@MapperScan("com.zfgc.zfgbb.testsupport.mappers")
@TestPropertySource(properties = {
		"zfgbb.install.token=" + ZfgbbIntegrationTest.INSTALL_TOKEN,
		"zfgbb.registration.enabled=true",
		"spring.mail.host="
})
public abstract class ZfgbbIntegrationTest {

	public static final String INSTALL_TOKEN = "test-install-token";
	public static final String ADMIN_USER = "test_admin";
	public static final String ADMIN_DISPLAY_NAME = "Test Admin";
	public static final String ADMIN_PASSWORD = "adminpass123";

	private static final String PG_DB = "zfgc_dev";
	private static final String PG_USER = "zfgbb_user";
	private static final String PG_PASSWORD = "123456";

	@Autowired
	protected MockMvc mockMvc;

	protected final ObjectMapper json = new ObjectMapper();

	@SuppressWarnings("resource")
	protected static PostgreSQLContainer devPostgres() {
		return new PostgreSQLContainer("postgres:16")
				.withDatabaseName(PG_DB)
				.withUsername("postgres")
				.withPassword("postgres")
				.withEnv("PGDATA", "/tmp/postgres-data")
				.withEnv("SPRING_DATASOURCE_USERNAME", PG_USER)
				.withEnv("SPRING_DATASOURCE_PASSWORD", PG_PASSWORD)
				.withCopyFileToContainer(
						MountableFile.forHostPath(
								resolveFromProjectRoot("scripts/postgresql-init-application-role.sh"), 0755),
						"/docker-entrypoint-initdb.d/10-application-role.sh");
	}

	protected static void datasource(DynamicPropertyRegistry r, PostgreSQLContainer pg) {
		r.add("spring.datasource.url", pg::getJdbcUrl);
		r.add("spring.datasource.username", () -> PG_USER);
		r.add("spring.datasource.password", () -> PG_PASSWORD);
		r.add("spring.flyway.url", pg::getJdbcUrl);
		r.add("spring.flyway.user", () -> PG_USER);
		r.add("spring.flyway.password", () -> PG_PASSWORD);
	}

	protected boolean isInstalled() {
		SystemConfigDbo installed = systemConfigDboMapper.selectByPrimaryKey("installed");
		return installed != null && "true".equals(installed.getConfigValue());
	}

	protected void installSampleData() throws Exception {
		if (isInstalled()) {
			return;
		}
		String body = """
				{
				  "adminUserName": "%s",
				  "adminDisplayName": "%s",
				  "adminEmail": "%s@fake-email.fake.tld.thing",
				  "adminPassword": "%s",
				  "siteName": "ZFGC Test"
				}
				""".formatted(ADMIN_USER, ADMIN_DISPLAY_NAME, ADMIN_USER, ADMIN_PASSWORD);
		mockMvc.perform(post("/system/install")
				.header("X-Install-Token", INSTALL_TOKEN)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isOk());
	}

	protected JsonNode register(String userName, String password) throws Exception {
		String body = """
				{
				  "userName": "%s",
				  "displayName": "%s",
				  "email": "%s@fake-email.fake.tld.thing",
				  "password": "%s"
				}
				""".formatted(userName, userName, userName, password);
		MvcResult result = mockMvc.perform(post("/users/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isCreated())
				.andReturn();
		return json.readTree(result.getResponse().getContentAsString());
	}

	protected JsonNode login(String userName, String password) throws Exception {
		String body = """
				{"username": "%s", "password": "%s", "useTokens": true, "stayLoggedIn": false}
				""".formatted(userName, password);
		MvcResult result = mockMvc.perform(post("/users/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isOk())
				.andReturn();
		return json.readTree(result.getResponse().getContentAsString());
	}

	@Autowired
	private SystemConfigDboMapper systemConfigDboMapper;

	@Autowired
	private UserDboMapper baseUserDboMapper;

	private UserDbo userNamed(String userName) {
		UserDboExample named = new UserDboExample();
		named.createCriteria().andUserNameEqualTo(userName);
		List<UserDbo> matches = baseUserDboMapper.selectByExample(named);
		assertTrue(matches.size() <= 1, "user_name must identify at most one account: " + userName);
		return matches.isEmpty() ? null : matches.get(0);
	}

	protected Integer findUserIdByName(String userName) {
		UserDbo user = userNamed(userName);
		return user == null ? null : user.getUserId();
	}

	protected static Path resolveFromProjectRoot(String relativePath) {
		Path current = new File("").getAbsoluteFile().toPath();
		while (current != null) {
			Path candidate = current.resolve(relativePath);
			if (Files.exists(candidate)) {
				return candidate;
			}
			current = current.getParent();
		}
		throw new IllegalStateException(relativePath + " not found walking up from " + new File("").getAbsolutePath());
	}
}
