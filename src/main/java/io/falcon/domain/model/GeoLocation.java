package io.falcon.domain.model;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Entity
@Table(name = "GEO_LOCATION")
public class GeoLocation {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "LABEL", length = 200)
    private String label;

    @PersistenceConstructor
    public GeoLocation(String id, String label) {
        checkArgument(isNotBlank(id), "id can not be blank");
        checkArgument(isNotBlank(label), "label can not be blank");
        this.id = id;
        this.label = label;
    }

}
