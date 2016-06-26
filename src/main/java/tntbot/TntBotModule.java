package tntbot;

import com.google.inject.Binder;
import com.google.inject.Module;
import tntbot.services.RandomPickUserService;

public class TntBotModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(RandomPickUserService.class);
    }
}
