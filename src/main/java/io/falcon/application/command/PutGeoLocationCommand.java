package io.falcon.application.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.falcon.framework.command.api.Command;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class PutGeoLocationCommand extends Command {

    private final String key;
    private final String label;

    @JsonCreator
    public PutGeoLocationCommand(@JsonProperty("key") final String key, @JsonProperty("label") final String label) {
        this.key = key;
        this.label = label;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }
}
