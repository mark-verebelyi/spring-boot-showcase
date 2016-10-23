package io.falcon.framework.cqrs.api;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public interface QueryBus {

    <Q extends Query<QR>, QR extends QueryResult> QR dispatch(Q query);
}
