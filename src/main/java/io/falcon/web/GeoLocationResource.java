package io.falcon.web;

import io.falcon.application.command.PutGeoLocationCommand;
import io.falcon.application.query.FindGeoLocationByKeyQuery;
import io.falcon.application.query.FindGeoLocationByKeyQueryResult;
import io.falcon.framework.web.core.AsyncCqrsResource;
import io.falcon.framework.web.core.RestOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@RestController
@RequestMapping("/geo-location")
public class GeoLocationResource extends AsyncCqrsResource {

    @Autowired
    public GeoLocationResource(final RestOperations restOperations) {
        super(restOperations);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Callable<ResponseEntity<FindGeoLocationByKeyQueryResult>> findByKey(@PathVariable("key") String key) {
        return queryGet(new FindGeoLocationByKeyQuery(key));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Callable<ResponseEntity<Void>> put(@RequestBody PutGeoLocationCommand command) {
        return commandPut(command);
    }


}
