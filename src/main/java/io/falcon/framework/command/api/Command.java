package io.falcon.framework.command.api;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public abstract class Command {

    private String id = UUID.randomUUID().toString();
    private LocalDateTime timestamp = LocalDateTime.now();

    public final String id() {
        return id;
    }

    public final LocalDateTime timestamp() {
        return timestamp;
    }


}
