package tntbot.commands;

import tntbot.core.exceptions.EventCommandException;
import tntbot.core.notification.Notification;

public abstract class EventCommand<T> {
    public abstract T execute();
}
