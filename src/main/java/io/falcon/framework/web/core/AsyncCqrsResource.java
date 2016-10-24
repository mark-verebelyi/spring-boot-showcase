package io.falcon.framework.web.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.query.api.Query;
import io.falcon.framework.query.api.QueryResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public abstract class AsyncCqrsResource {

    private final RestOperations restOperations;

    protected AsyncCqrsResource(final RestOperations restOperations) {
        checkArgument(restOperations != null, "restOperations can not be null");
        this.restOperations = restOperations;
    }

    protected final  <Q extends Query<QR>, QR extends QueryResult> Callable<ResponseEntity<QR>> queryGet(Q query) {
        return () -> {
            final QR result = restOperations.dispatch(query);
            return new ResponseEntity<>(result, HttpStatus.OK);
        };
    }

    protected final Callable<ResponseEntity<Void>> commandPut(Command command) {
        return () -> {
            restOperations.dispatch(command);
            return new ResponseEntity<>(HttpStatus.OK);
        };
    }

}
