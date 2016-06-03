package tntbot.core;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomPrivacy {
    PUBLIC("public"),
    PRIVATE("private");

    private String value;

    RoomPrivacy(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
