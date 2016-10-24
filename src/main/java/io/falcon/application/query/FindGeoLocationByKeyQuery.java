package io.falcon.application.query;

import io.falcon.framework.query.api.Query;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByKeyQuery extends Query<FindGeoLocationByKeyQueryResult> {

    private final String key;

    public FindGeoLocationByKeyQuery(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
