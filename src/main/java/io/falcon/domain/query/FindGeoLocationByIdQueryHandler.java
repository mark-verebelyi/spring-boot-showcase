package io.falcon.domain.query;

import io.falcon.application.query.FindGeoLocationByIdQuery;
import io.falcon.application.query.FindGeoLocationByIdQueryResult;
import io.falcon.domain.model.GeoLocation;
import io.falcon.domain.model.GeoLocationRepository;
import io.falcon.framework.query.core.ApplicationQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class FindGeoLocationByIdQueryHandler extends ApplicationQueryHandler<FindGeoLocationByIdQuery, FindGeoLocationByIdQueryResult> {

    private GeoLocationRepository geoLocationRepository;

    @Autowired
    public FindGeoLocationByIdQueryHandler(GeoLocationRepository geoLocationRepository) {
        checkArgument(geoLocationRepository != null, "geoLocationRepository can not be null");
        this.geoLocationRepository = geoLocationRepository;
    }

    @Override
    public FindGeoLocationByIdQueryResult handle(FindGeoLocationByIdQuery query) {
        final GeoLocation geoLocation = geoLocationRepository.findOne(query.getId());
        return new FindGeoLocationByIdQueryResult(geoLocation);
    }
}
