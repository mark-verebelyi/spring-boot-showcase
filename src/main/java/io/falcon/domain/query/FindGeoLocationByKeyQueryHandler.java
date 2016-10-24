package io.falcon.domain.query;

import io.falcon.application.query.FindGeoLocationByKeyQuery;
import io.falcon.application.query.FindGeoLocationByKeyQueryResult;
import io.falcon.domain.model.GeoLocation;
import io.falcon.domain.model.GeoLocationRepository;
import io.falcon.framework.query.core.ApplicationQueryHandler;
import io.falcon.framework.query.core.QueryHandlerOperations;
import org.springframework.beans.factory.annotation.Autowired;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByKeyQueryHandler extends ApplicationQueryHandler<FindGeoLocationByKeyQuery, FindGeoLocationByKeyQueryResult> {

    private GeoLocationRepository geoLocationRepository;

    @Autowired
    public FindGeoLocationByKeyQueryHandler(QueryHandlerOperations queryHandlerOperations, GeoLocationRepository geoLocationRepository) {
        super(queryHandlerOperations);
        checkArgument(geoLocationRepository != null, "geoLocationRepository can not be null");
        this.geoLocationRepository = geoLocationRepository;
    }

    @Override
    public FindGeoLocationByKeyQueryResult handle(FindGeoLocationByKeyQuery query) {
        final GeoLocation geoLocation = geoLocationRepository.findOne(query.getKey());
        return new FindGeoLocationByKeyQueryResult(geoLocation.asGeoLocationView());
    }
}
