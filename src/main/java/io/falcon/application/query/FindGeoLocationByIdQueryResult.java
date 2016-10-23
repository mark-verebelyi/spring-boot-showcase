package io.falcon.application.query;

import io.falcon.domain.model.GeoLocation;
import io.falcon.framework.query.api.QueryResult;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByIdQueryResult implements QueryResult {

    private GeoLocation geoLocation;

    public FindGeoLocationByIdQueryResult(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }
}
