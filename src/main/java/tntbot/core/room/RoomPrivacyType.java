package tntbot.core.room;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomPrivacyType {
    PUBLIC("public"),
    PRIVATE("private");

    private String value;

    RoomPrivacyType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
