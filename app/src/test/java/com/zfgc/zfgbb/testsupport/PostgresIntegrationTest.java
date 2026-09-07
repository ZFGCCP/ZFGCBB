package com.zfgc.zfgbb.testsupport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.postgresql.PostgreSQLContainer;

import com.zfgc.zfgbb.testsupport.mappers.TestFixtureSetupMapper;

public abstract class PostgresIntegrationTest extends ZfgbbIntegrationTest {

	static final PostgreSQLContainer POSTGRES = devPostgres();
	private static final Path CONTENT_ROOT = Path.of(System.getProperty("java.io.tmpdir"),
			"zfgbb-postgres-integration-" + UUID.randomUUID());

	static {
		POSTGRES.start();
		Runtime.getRuntime().addShutdownHook(new Thread(POSTGRES::stop));
	}

	@DynamicPropertySource
	static void datasource(DynamicPropertyRegistry registry) {
		datasource(registry, POSTGRES);
		registry.add("zfgbb.content.path", CONTENT_ROOT::toString);
	}

	@Autowired
	protected TestFixtureSetupMapper testFixtureSetupMapper;

	protected final String suffix = UUID.randomUUID().toString().substring(0, 8);

	protected record TestUser(String userName, String token, int id) {}

	protected TestUser createUser(String userName) throws Exception {
		register(userName, "password123");
		String token = login(userName, "password123").get("accessToken").asString();
		return new TestUser(userName, token, userIdOf(userName));
	}

	@BeforeEach
	void ensureSampleDataInstalled() throws Exception {
		installSampleData();
		ensureOrdinaryIntegrationFixture();
	}

	private void ensureOrdinaryIntegrationFixture() {
		testFixtureSetupMapper.ensureDefaultCategory();
		testFixtureSetupMapper.ensureGeneralBoard();
		testFixtureSetupMapper.resetBoardPermissions();
		testFixtureSetupMapper.grantGeneralBoardPermissions();
		testFixtureSetupMapper.resetCategorySequence();
		testFixtureSetupMapper.resetBoardSequence();
	}

	protected int userIdOf(String userName) {
		Integer userId = findUserIdByName(userName);
		assertNotNull(userId);
		return userId;
	}
}
