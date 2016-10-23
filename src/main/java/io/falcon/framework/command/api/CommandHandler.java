package io.falcon.framework.command.api;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface CommandHandler<C extends Command> {

    void handle(C command);

    Class<C> commandType();

}
