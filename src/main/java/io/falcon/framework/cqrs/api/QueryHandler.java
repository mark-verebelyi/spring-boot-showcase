package io.falcon.framework.cqrs.api;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface QueryHandler<Q extends Query<QR>, QR extends QueryResult> {

    QR handle(Q query);

    Class<Q> queryType();

}
