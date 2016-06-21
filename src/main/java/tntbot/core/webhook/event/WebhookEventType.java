package tntbot.core.webhook.event;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WebhookEventType {
    ROOM_ARCHIVED("room_archived"),
    ROOM_CREATED("room_created"),
    ROOM_DELETED("room_deleted"),
    ROOM_ENTER("room_enter"),
    ROOM_EXIT("room_exit"),
    ROOM_FILE_UPLOAD("room_file_upload"),
    ROOM_MESSAGE("room_message"),
    ROOM_NOTIFICATION("room_notification"),
    ROOM_TOPIC_CHANGE("room_topic_change"),
    ROOM_UNARCHIVED("room_unarchived");

    private String value;

    WebhookEventType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
