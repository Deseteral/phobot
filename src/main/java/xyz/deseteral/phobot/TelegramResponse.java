package xyz.deseteral.phobot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TelegramResponse {
    private boolean ok;
    private String description;

    @JsonCreator
    public TelegramResponse(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("description") String description
    ) {
        this.ok = ok;
        this.description = description;
    }

    public boolean isOk() {
        return ok;
    }

    public String getDescription() {
        return description;
    }
}
