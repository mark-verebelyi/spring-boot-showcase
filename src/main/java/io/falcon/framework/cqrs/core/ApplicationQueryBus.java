package io.falcon.framework.cqrs.core;

import io.falcon.framework.cqrs.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Service
public class ApplicationQueryBus implements QueryBus {

    private QueryHandlerProvider queryHandlerProvider;

    @Autowired
    public ApplicationQueryBus(QueryHandlerProvider queryHandlerProvider) {
        checkArgument(queryHandlerProvider != null, "queryHandlerProvider can not be null");
        this.queryHandlerProvider = queryHandlerProvider;
    }

    @Transactional
    @Override
    public <Q extends Query<QR>, QR extends QueryResult> QR dispatch(final Q query) {
        checkArgument(query != null, "query can not be null");
        final QueryHandler<Q, QR> queryHandler = getQueryHandler(query);
        return queryHandler.handle(query);
    }

    private <Q extends Query<QR>, QR extends QueryResult> QueryHandler<Q, QR> getQueryHandler(final Q query) {
        return queryHandlerProvider
                .provide(query)
                .orElseThrow((() -> new IllegalStateException(String.format("There is no QueryHandler registered for [%s]", query.getClass().getName()))));
    }

}
