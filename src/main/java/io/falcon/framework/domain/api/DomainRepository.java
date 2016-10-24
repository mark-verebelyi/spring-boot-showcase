package io.falcon.framework.domain.api;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@NoRepositoryBean
public interface DomainRepository<A extends Aggregate> extends PagingAndSortingRepository<A, String>, QueryDslPredicateExecutor<A> {
}
