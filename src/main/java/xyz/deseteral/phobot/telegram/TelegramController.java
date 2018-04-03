package xyz.deseteral.phobot.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.deseteral.phobot.invocation.MainInvocationProcessor;
import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;
import xyz.deseteral.phobot.telegram.model.OutgoingMessage;
import xyz.deseteral.phobot.telegram.model.Update;

@Controller
@RequestMapping("/adapter/telegram")
public class TelegramController {
    private final TelegramClient client;
    private final MainInvocationProcessor mainInvocationProcessor;

    @Autowired
    public TelegramController(TelegramClient client, MainInvocationProcessor mainInvocationProcessor) {
        this.client = client;
        this.mainInvocationProcessor = mainInvocationProcessor;
    }

    @PostMapping
    ResponseEntity postUpdate(@RequestBody Update update) {
        final String invocationText = update.getMessage().getText();
        final Invocation invocation = new Invocation(invocationText);
        final long chatId = update.getMessage().getChat().getId();

        Response response = mainInvocationProcessor.process(invocation);

        OutgoingMessage outgoingMessage = new OutgoingMessage(
                chatId,
                response.getText()
        );

        client.sendMessage(outgoingMessage);

        return ResponseEntity.status(200).build();
    }
}
