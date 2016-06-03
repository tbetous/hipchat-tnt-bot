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

public class HelloWorldResourceIntegrationTest {

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
	public void shouldReturnHello() {
		String newTaskJson = "{\"name\" : \"REST task 1\", \"description\" : \"This is a description\"}";

		Header jsonContentHeader = new Header("Content-Type", "application/json");
		RestAssured.given().header(jsonContentHeader).request().body(newTaskJson).post("/hello");
	}

}
