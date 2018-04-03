package xyz.deseteral.phobot.invocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;
import xyz.deseteral.phobot.modules.PingModule;

@Component
public class MainInvocationProcessor {
    private final PingModule pingModule;

    @Autowired
    public MainInvocationProcessor(PingModule pingModule) {
        this.pingModule = pingModule;
    }

    public Response process(Invocation invocation) {
        if (pingModule.doesInvocationQualify(invocation)) {
            return pingModule.process(invocation);
        }

        return new Response(
                "I don't know anything about that."
        );
    }
}
