package tntbot.commands;

import tntbot.core.notification.Notification;

public abstract class EventCommandResultProvider<T> {
    protected T result;

    public abstract Notification getNotification();

    public T getResult() {
        return result;
    }
}
