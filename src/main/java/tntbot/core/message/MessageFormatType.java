package tntbot.core.message;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Thomas Betous on 26/06/2016.
 */
public enum MessageFormatType {
    TEXT("text"),
    HTML("html");

    private String value;

    MessageFormatType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
