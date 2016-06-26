package tntbot.commands.randomPickUser;

import tntbot.core.user.User;

import java.util.List;

/**
 * Created by Thomas Betous on 26/06/2016.
 */
public class RandomPickUserCommandResultProviderBuilder {
    protected List<User> result;

    public List<User> getResult() {
        return result;
    }

    public RandomPickUserCommandResultProviderBuilder withResult(List<User> result) {
        this.result = result;
        return this;
    }

    public RandomPickUserCommandResultProvider build() {
        return new RandomPickUserCommandResultProvider(this);
    }
}
