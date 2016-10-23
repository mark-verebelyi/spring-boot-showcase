package io.falcon.application.query;

import io.falcon.framework.query.api.Query;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByIdQuery extends Query<FindGeoLocationByIdQueryResult> {

    private String id;

    public FindGeoLocationByIdQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
