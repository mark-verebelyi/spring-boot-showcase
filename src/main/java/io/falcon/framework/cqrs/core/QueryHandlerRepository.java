package io.falcon.framework.cqrs.core;

import io.falcon.framework.cqrs.api.*;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class QueryHandlerRepository implements QueryHandlerProvider, QueryHandlerRegistry {

    private final ConcurrentMap<Class<?>, QueryHandler<?, ?>> repository = new ConcurrentHashMap<>();

    @Override
    public void register(final QueryHandler<?, ?> queryHandler) {
        checkArgument(queryHandler != null, "queryHandler can not be null");
        final Class<?> queryType = queryHandler.queryType();
        QueryHandler<?, ?> previous = repository.put(queryType, queryHandler);
        checkState(previous == null, "Can't register [%s]; a handler was already registered for [%s]", queryHandler.getClass().getName(), queryType.getName());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Q extends Query<QR>, QR extends QueryResult> Optional<QueryHandler<Q, QR>> provide(final Q query) {
        checkArgument(query != null, "query can not be null");
        final QueryHandler<Q, QR> queryHandler = (QueryHandler<Q, QR>) repository.get(query.getClass());
        return Optional.ofNullable(queryHandler);
    }

}
