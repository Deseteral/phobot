package xyz.deseteral.phobot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutgoingMessage {
    private int chatId;
    private String text;

    @JsonCreator
    public OutgoingMessage(
            @JsonProperty("chat_id") int chatId,
            @JsonProperty("text") String text
    ) {
        this.chatId = chatId;
        this.text = text;
    }

    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }
}
