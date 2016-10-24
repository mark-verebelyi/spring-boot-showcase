package io.falcon.framework.domain.api;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@MappedSuperclass
public abstract class Aggregate {

    @Id
    @Column(name = "KEY")
    private String key;

    @Deprecated
    protected Aggregate() {
    }

    protected Aggregate(final String key) {
        checkArgument(isNotBlank(key), "key can not be blank");
        this.key = key;
    }

    public final String key() {
        return key;
    }

}
