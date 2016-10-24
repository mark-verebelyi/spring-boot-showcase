package io.falcon.domain.command;

import io.falcon.application.command.PutGeoLocationCommand;
import io.falcon.domain.model.GeoLocation;
import io.falcon.domain.model.GeoLocationRepository;
import io.falcon.framework.command.core.ApplicationCommandHandler;
import io.falcon.framework.command.core.CommandHandlerOperations;
import org.springframework.beans.factory.annotation.Autowired;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public final class PutGeoLocationCommandHandler extends ApplicationCommandHandler<PutGeoLocationCommand> {

    private final GeoLocationRepository geoLocationRepository;

    @Autowired
    public PutGeoLocationCommandHandler(final CommandHandlerOperations commandHandlerOperations, GeoLocationRepository geoLocationRepository) {
        super(commandHandlerOperations);
        checkArgument(geoLocationRepository != null, "geoLocationRepository can not be null");
        this.geoLocationRepository = geoLocationRepository;
    }

    @Override
    public void handle(final PutGeoLocationCommand command) {
        put(geoLocationRepository,
            command.getKey(),
            () -> new GeoLocation(command.getKey(), command.getLabel()),
            geoLocation -> geoLocation.changeLabel(command.getLabel()));
    }

}
