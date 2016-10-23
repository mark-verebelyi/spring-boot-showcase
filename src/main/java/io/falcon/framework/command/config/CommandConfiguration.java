package io.falcon.framework.command.config;

import io.falcon.framework.command.api.CommandHandler;
import io.falcon.framework.command.core.CommandHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Configuration
@ComponentScan(basePackages = "io.falcon.domain.**.command", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CommandHandler.class)})
public class CommandConfiguration {

    @Autowired(required = false)
    private List<CommandHandler<?>> commandHandlers;

    @Bean(value = {"commandHandlerRegistry", "commandHandlerProvider"})
    public CommandHandlerRepository commandHandlerRepository() {
        final List<CommandHandler<?>> handlers = Optional.ofNullable(this.commandHandlers).orElse(Collections.emptyList());
        final CommandHandlerRepository repository = new CommandHandlerRepository();
        handlers.forEach(repository::register);
        return repository;
    }



}
