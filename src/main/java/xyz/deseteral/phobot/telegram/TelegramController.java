package xyz.deseteral.phobot.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.deseteral.phobot.telegram.model.OutgoingMessage;
import xyz.deseteral.phobot.telegram.model.Update;

@Controller
@RequestMapping("/adapter/telegram")
public class TelegramController {
    private TelegramClient client;

    @Autowired
    public TelegramController(TelegramClient client) {
        this.client = client;
    }

    @PostMapping
    ResponseEntity postUpdate(@RequestBody Update update) {
        final String text = update.getMessage().getText().equals("ping")
                ? "pong"
                : "what?";

        OutgoingMessage outgoingMessage = new OutgoingMessage(
                update.getMessage().getChat().getId(),
                text
        );

        client.sendMessage(outgoingMessage);

        return ResponseEntity.status(200).build();
    }
}
