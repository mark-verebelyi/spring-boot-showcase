package io.falcon.framework.web.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.query.api.Query;
import io.falcon.framework.query.api.QueryResult;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface RestOperations {

    void dispatch(final Command command);

    <Q extends Query<QR>, QR extends QueryResult> QR dispatch(Q query);

}
