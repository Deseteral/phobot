package xyz.deseteral.phobot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Update {
    private Message message;

    @JsonCreator
    public Update(@JsonProperty("message") Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
