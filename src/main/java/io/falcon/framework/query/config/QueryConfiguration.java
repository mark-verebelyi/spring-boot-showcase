package io.falcon.framework.query.config;

import io.falcon.framework.query.api.QueryHandler;
import io.falcon.framework.query.core.DefaultQueryHandlerOperations;
import io.falcon.framework.query.core.QueryHandlerOperations;
import io.falcon.framework.query.core.QueryHandlerRepository;
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
@ComponentScan(basePackages = "io.falcon.domain.**.query", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = QueryHandler.class)})
public class QueryConfiguration {

    @Autowired(required = false)
    private List<QueryHandler<?, ?>> queryHandlers;

    @Bean(value = {"queryHandlerRegistry", "queryHandlerProvider"})
    public QueryHandlerRepository queryHandlerRepository() {
        final List<QueryHandler<?, ?>> handlers = Optional.ofNullable(this.queryHandlers).orElse(Collections.emptyList());
        final QueryHandlerRepository repository = new QueryHandlerRepository();
        handlers.forEach(repository::register);
        return repository;
    }

    @Bean
    public QueryHandlerOperations queryHandlerOperations() {
        return new DefaultQueryHandlerOperations();
    }

}
