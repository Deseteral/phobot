package xyz.deseteral.phobot.invocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;

import java.util.List;

@Component
public class MainInvocationProcessor {
    private final List<InvocationProcessor> invocationProcessors;

    @Autowired
    public MainInvocationProcessor(List<InvocationProcessor> invocationProcessors) {
        this.invocationProcessors = invocationProcessors;
    }

    public Response process(Invocation invocation) {
        return invocationProcessors
                .stream()
                .filter(processor -> processor.doesInvocationQualify(invocation))
                .findFirst()
                .map(processor -> processor.process(invocation))
                .orElseGet(MainInvocationProcessor::getDefaultResponse);
    }

    private static Response getDefaultResponse() {
        return new Response("I don't know anything about that.");
    }
}
