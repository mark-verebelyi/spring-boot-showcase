package io.falcon.framework.command.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.command.api.CommandHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public abstract class ApplicationCommandHandler<C extends Command> implements CommandHandler<C> {

    private final Class<C> commandType;
    private final CommandHandlerOperations commandHandlerOperations;

    protected ApplicationCommandHandler(CommandHandlerOperations commandHandlerOperations) {
        checkArgument(commandHandlerOperations != null, "commandHandlerOperations can not be null");
        ParameterizedType type = ParameterizedType.class.cast(this.getClass().getGenericSuperclass());
        Type[] typeArguments = type.getActualTypeArguments();
        @SuppressWarnings("unchecked")
        Class<C> result = (Class<C>) typeArguments[0];
        commandType = result;
        this.commandHandlerOperations = commandHandlerOperations;
    }

    @Override
    public final Class<C> commandType() {
        return commandType;
    }

}
