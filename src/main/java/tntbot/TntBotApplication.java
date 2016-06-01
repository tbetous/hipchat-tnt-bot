package tntbot;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import tntbot.helloworld.HelloWorldResource;
import tntbot.helloworld.TestResource;

public class TntBotApplication extends Application<TntBotConfiguration>{

    public static void main(String[] args) throws Exception {
        new TntBotApplication().run(args);
    }

	@Override
	public void run(TntBotConfiguration configuration, Environment environment)
			throws Exception {
		environment.jersey().register(new HelloWorldResource());
		environment.jersey().register(new TestResource());
	}
 
}
