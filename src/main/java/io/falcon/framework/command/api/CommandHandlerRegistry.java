package io.falcon.framework.command.api;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface CommandHandlerRegistry {

    void register(CommandHandler<?> commandHandler);

}
