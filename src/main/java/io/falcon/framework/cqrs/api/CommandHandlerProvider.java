package io.falcon.framework.cqrs.api;

import java.util.Optional;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface CommandHandlerProvider {

    <C extends Command> Optional<CommandHandler<C>> provide(C command);

}
