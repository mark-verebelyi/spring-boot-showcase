package io.falcon.framework.command.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.command.api.CommandBus;
import io.falcon.framework.command.api.CommandHandler;
import io.falcon.framework.command.api.CommandHandlerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Service
public class ApplicationCommandBus implements CommandBus {

    private CommandHandlerProvider commandHandlerProvider;

    @Autowired
    public ApplicationCommandBus(final CommandHandlerProvider commandHandlerProvider) {
        checkArgument(commandHandlerProvider != null, "commandHandlerProvider can not be null");
        this.commandHandlerProvider = commandHandlerProvider;
    }

    @Transactional
    @Override
    public void dispatch(final Command command) {
        checkArgument(command != null, "command can not be null");
        final CommandHandler<Command> commandHandler = getCommandHandler(command);
        commandHandler.handle(command);
    }

    private CommandHandler<Command> getCommandHandler(final Command command) {
        return commandHandlerProvider
                .provide(command)
                .orElseThrow(() -> new IllegalStateException(String.format("There is no CommandHandler registered for [%s]", command.getClass().getName())));
    }

}
