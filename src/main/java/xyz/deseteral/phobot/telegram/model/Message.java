package xyz.deseteral.phobot.telegram.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String text;
    private Chat chat;

    @JsonCreator
    public Message(
            @JsonProperty("text") String text,
            @JsonProperty("chat") Chat chat) {
        this.text = text;
        this.chat = chat;
    }

    public String getText() {
        return text;
    }

    public Chat getChat() {
        return chat;
    }
}
