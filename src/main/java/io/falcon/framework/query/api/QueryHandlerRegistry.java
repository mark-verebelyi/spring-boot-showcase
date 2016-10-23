package io.falcon.framework.query.api;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface QueryHandlerRegistry {

    void register(QueryHandler<?, ?> queryHandler);

}
