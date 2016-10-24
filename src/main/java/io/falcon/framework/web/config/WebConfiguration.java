package io.falcon.framework.web.config;

import io.falcon.framework.command.api.CommandBus;
import io.falcon.framework.query.api.QueryBus;
import io.falcon.framework.web.core.DefaultRestOperations;
import io.falcon.framework.web.core.RestOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Configuration
public class WebConfiguration {

    @Autowired
    private CommandBus commandBus;

    @Autowired
    private QueryBus queryBus;

    @Bean
    public RestOperations restOperations() {
        return new DefaultRestOperations(commandBus, queryBus);
    }


}
