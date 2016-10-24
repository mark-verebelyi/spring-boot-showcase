package io.falcon.application.query;

import io.falcon.framework.query.api.QueryResult;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByKeyQueryResult implements QueryResult {

    private final GeoLocationView geoLocation;

    public FindGeoLocationByKeyQueryResult(GeoLocationView geoLocation) {
        this.geoLocation = geoLocation;
    }

    public GeoLocationView getGeoLocation() {
        return geoLocation;
    }
}
