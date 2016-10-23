package io.falcon.framework.cqrs.core;

import io.falcon.framework.cqrs.api.Command;
import io.falcon.framework.cqrs.api.CommandHandler;
import io.falcon.framework.cqrs.api.CommandHandlerProvider;
import io.falcon.framework.cqrs.api.CommandHandlerRegistry;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class CommandHandlerRepository implements CommandHandlerProvider, CommandHandlerRegistry {

    private final ConcurrentMap<Class<?>, CommandHandler<?>> repository = new ConcurrentHashMap<>();

    @Override
    public void register(final CommandHandler<?> commandHandler) {
        checkArgument(commandHandler != null, "commandHandler can not be null");
        final Class<?> commandType = commandHandler.commandType();
        final CommandHandler<?> previous = repository.put(commandType, commandHandler);
        checkState(previous == null, "Can't register [%s]; a handler was already registered for [%s]", commandHandler.getClass().getName(), commandType.getName());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <C extends Command> Optional<CommandHandler<C>> provide(C command) {
        checkArgument(command != null, "command can not be null");
        final CommandHandler<C> commandHandler = (CommandHandler<C>) repository.get(command.getClass());
        return Optional.ofNullable(commandHandler);
    }
    
}
