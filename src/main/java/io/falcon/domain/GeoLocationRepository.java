package io.falcon.domain;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Repository
public interface GeoLocationRepository extends PagingAndSortingRepository<GeoLocation, String>, QueryDslPredicateExecutor<GeoLocation> {
}
