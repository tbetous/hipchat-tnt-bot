package tntbot;

import com.google.inject.Guice;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import tntbot.resources.HelloWorldResource;
import tntbot.resources.RandomPickUserResource;

public class TntBotApplication extends Application<TntBotConfiguration>{

	@Override
	public void initialize(Bootstrap<TntBotConfiguration> bootstrap) {
		GuiceBundle<TntBotConfiguration> guiceBundle = GuiceBundle.<TntBotConfiguration>newBuilder()
			.addModule(new TntBotModule())
			.enableAutoConfig(getClass().getPackage().getName())
			.setConfigClass(TntBotConfiguration.class)
			.build();

		bootstrap.addBundle(guiceBundle);
	}


	@Override
	public void run(TntBotConfiguration configuration, Environment environment)
			throws Exception {
	}


	public static void main(String[] args) throws Exception {
		new TntBotApplication().run(args);
	}
}
