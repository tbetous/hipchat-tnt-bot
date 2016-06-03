package tntbot.resources;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import tntbot.TntBotApplication;
import tntbot.TntBotConfiguration;
import tntbot.resources.HelloWorldResource;

public class TestRandomIntegrationTest {

	@ClassRule
	public static final DropwizardAppRule<TntBotConfiguration> RULE = new DropwizardAppRule<TntBotConfiguration>(
			TntBotApplication.class, ResourceHelpers.resourceFilePath("todo.yml"));

	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(new HelloWorldResource())
			.build();

	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8180;
	}

	@Test
	public void shouldGeneric() {
		String newTaskJson = "{\"event\": \"room_message\", \"item\": {\"message\": {\"date\": \"2016-06-03T11:55:54.455549+00:00\", \"from\": {\"id\": 3165815, \"links\": {\"self\": \"https://api.hipchat.com/v2/user/3165815\"}, \"mention_name\": \"ThomasBetous\", \"name\": \"Thomas Betous\", \"version\": \"LKRXR09S\"}, \"id\": \"4aea921b-bd54-4c37-8917-d2e96ecceceb\", \"mentions\": [], \"message\": \"/test\", \"type\": \"message\"}, \"room\": {\"id\": 2784916, \"is_archived\": false, \"links\": {\"members\": \"https://api.hipchat.com/v2/room/2784916/member\", \"participants\": \"https://api.hipchat.com/v2/room/2784916/participant\", \"self\": \"https://api.hipchat.com/v2/room/2784916\", \"webhooks\": \"https://api.hipchat.com/v2/room/2784916/webhook\"}, \"name\": \"tnt-bot\", \"privacy\": \"private\", \"version\": \"3V859TA4\"}}, \"oauth_client_id\": \"e4d25ff5-f031-4e7e-a299-4ec278ba4e60\", \"webhook_id\": 5035914}";
		Header jsonContentHeader = new Header("Content-Type", "application/json");
		RestAssured.given().header(jsonContentHeader).request().body(newTaskJson).post("/test");
	}

	@Test
	public void shouldRandomPickMention() {
		String newTaskJson = 	"{\"event\": \"room_message\", \"item\": {\"message\": {\"date\": \"2016-06-03T11:57:10.225285+00:00\", \"from\": {\"id\": 3165815, \"links\": {\"self\": \"https://api.hipchat.com/v2/user/3165815\"}, \"mention_name\": \"ThomasBetous\", \"name\": \"Thomas Betous\", \"version\": \"LKRXR09S\"}, \"id\": \"b8450ffd-582c-4794-b319-470dc6bc7379\", \"mentions\": [{\"id\": 3485772, \"links\": {\"self\": \"https://api.hipchat.com/v2/user/3485772\"}, \"mention_name\": \"HadrienMensPellen\", \"name\": \"Hadrien Mens-Pellen\", \"version\": \"NJBP9V84\"}, {\"id\": 3513718, \"links\": {\"self\": \"https://api.hipchat.com/v2/user/3513718\"}, \"mention_name\": \"ThomasCarpaye\", \"name\": \"Thomas Carpaye\", \"version\": \"ZQLN0JYV\"}], \"message\": \"/test blah @HadrienMensPellen @ThomasCarpaye \", \"type\": \"message\"}, \"room\": {\"id\": 2784916, \"is_archived\": false, \"links\": {\"members\": \"https://api.hipchat.com/v2/room/2784916/member\", \"participants\": \"https://api.hipchat.com/v2/room/2784916/participant\", \"self\": \"https://api.hipchat.com/v2/room/2784916\", \"webhooks\": \"https://api.hipchat.com/v2/room/2784916/webhook\"}, \"name\": \"tnt-bot\", \"privacy\": \"private\", \"version\": \"3V859TA4\"}}, \"oauth_client_id\": \"e4d25ff5-f031-4e7e-a299-4ec278ba4e60\", \"webhook_id\": 5035914}";
		Header jsonContentHeader = new Header("Content-Type", "application/json");
		RestAssured.given().header(jsonContentHeader).request().body(newTaskJson).post("/test");
	}
	

}
