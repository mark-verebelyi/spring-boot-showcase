package io.falcon.framework.cqrs.config;

import io.falcon.framework.cqrs.api.CommandHandler;
import io.falcon.framework.cqrs.api.QueryHandler;
import io.falcon.framework.cqrs.core.CommandHandlerRepository;
import io.falcon.framework.cqrs.core.QueryHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Configuration
public class CqrsConfiguration {

    @Autowired(required = false)
    private List<CommandHandler<?>> commandHandlers;

    @Autowired(required = false)
    private List<QueryHandler<?, ?>> queryHandlers;

    @Bean(value = {"commandHandlerRegistry", "commandHandlerProvider"})
    public CommandHandlerRepository commandHandlerRepository() {
        final List<CommandHandler<?>> handlers = Optional.ofNullable(this.commandHandlers).orElse(Collections.emptyList());
        final CommandHandlerRepository repository = new CommandHandlerRepository();
        handlers.forEach(repository::register);
        return repository;
    }

    @Bean(value = {"queryHandlerRegistry", "queryHandlerProvider"})
    public QueryHandlerRepository queryHandlerRepository() {
        final List<QueryHandler<?, ?>> handlers = Optional.ofNullable(this.queryHandlers).orElse(Collections.emptyList());
        final QueryHandlerRepository repository = new QueryHandlerRepository();
        handlers.forEach(repository::register);
        return repository;
    }

}
