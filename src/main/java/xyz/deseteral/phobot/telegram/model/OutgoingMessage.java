package xyz.deseteral.phobot.telegram.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutgoingMessage {

    @JsonProperty("chat_id")
    private long chatId;

    @JsonProperty("text")
    private String text;

    public OutgoingMessage(long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public long getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }
}
