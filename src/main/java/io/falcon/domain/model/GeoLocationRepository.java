package io.falcon.domain.model;

import io.falcon.framework.domain.api.DomainRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Repository
public interface GeoLocationRepository extends DomainRepository<GeoLocation> {
}
