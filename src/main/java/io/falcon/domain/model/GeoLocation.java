package io.falcon.domain.model;

import io.falcon.application.query.GeoLocationView;
import io.falcon.framework.domain.api.Aggregate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
@Entity
@Table(name = "GEO_LOCATION")
public class GeoLocation extends Aggregate {

    @Column(name = "LABEL", length = 200)
    private String label;

    @Deprecated
    protected GeoLocation() {
    }

    public GeoLocation(String key, String label) {
        super(key);
        checkArgument(isNotBlank(label), "label can not be blank");
        this.label = label;
    }

    public void changeLabel(final String label) {
        checkArgument(isNotBlank(label), "label can not be blank");
        if (Objects.equals(this.label, label)) {
            return;
        }
        this.label = label;
    }

    public GeoLocationView asGeoLocationView() {
        final GeoLocationView view = new GeoLocationView();
        view.setKey(key());
        view.setLabel(label);
        return view;
    }



}
