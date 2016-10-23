package io.falcon.framework.query.core;

import io.falcon.framework.query.api.Query;
import io.falcon.framework.query.api.QueryHandler;
import io.falcon.framework.query.api.QueryResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public abstract class ApplicationQueryHandler<Q extends Query<QR>, QR extends QueryResult> implements QueryHandler<Q, QR> {

    private final Class<Q> queryType;
    private final QueryHandlerOperations queryHandlerOperations;

    protected ApplicationQueryHandler(QueryHandlerOperations queryHandlerOperations) {
        checkArgument(queryHandlerOperations != null, "queryHandlerOperations can not be null");
        ParameterizedType type = ParameterizedType.class.cast(this.getClass().getGenericSuperclass());
        Type[] typeArguments = type.getActualTypeArguments();
        @SuppressWarnings("unchecked")
        Class<Q> result = (Class<Q>) typeArguments[0];
        queryType = result;
        this.queryHandlerOperations = queryHandlerOperations;
    }

    @Override
    public final Class<Q> queryType() {
        return queryType;
    }
}
