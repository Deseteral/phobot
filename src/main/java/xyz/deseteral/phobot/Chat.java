package xyz.deseteral.phobot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {
    private int id;

    @JsonCreator
    public Chat(@JsonProperty("id") int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
