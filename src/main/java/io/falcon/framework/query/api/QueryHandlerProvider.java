package io.falcon.framework.query.api;

import java.util.Optional;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface QueryHandlerProvider {

    <Q extends Query<QR>, QR extends QueryResult> Optional<QueryHandler<Q, QR>> provide(Q query);

}
