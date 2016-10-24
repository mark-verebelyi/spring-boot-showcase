package io.falcon.framework.web.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.command.api.CommandBus;
import io.falcon.framework.query.api.Query;
import io.falcon.framework.query.api.QueryBus;
import io.falcon.framework.query.api.QueryResult;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class DefaultRestOperations implements RestOperations {

    private CommandBus commandBus;
    private QueryBus queryBus;

    public DefaultRestOperations(final CommandBus commandBus, final QueryBus queryBus) {
        checkArgument(commandBus != null, "commandBus can not be null");
        checkArgument(queryBus != null, "queryBus can not be null");
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @Override
    public void dispatch(final Command command) {
        commandBus.dispatch(command);
    }

    @Override
    public <Q extends Query<QR>, QR extends QueryResult> QR dispatch(final Q query) {
        return queryBus.dispatch(query);
    }
}
