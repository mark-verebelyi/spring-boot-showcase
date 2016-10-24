package io.falcon.framework.command.core;

import io.falcon.framework.command.api.Command;
import io.falcon.framework.command.api.CommandHandler;
import io.falcon.framework.domain.api.Aggregate;
import io.falcon.framework.domain.api.DomainRepository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by mark.verebelyi@gmail.com on 2016. 10. 23.
 */
public abstract class ApplicationCommandHandler<C extends Command> implements CommandHandler<C> {

    private final Class<C> commandType;
    private final CommandHandlerOperations commandHandlerOperations;

    protected ApplicationCommandHandler(CommandHandlerOperations commandHandlerOperations) {
        checkArgument(commandHandlerOperations != null, "commandHandlerOperations can not be null");
        ParameterizedType type = ParameterizedType.class.cast(this.getClass().getGenericSuperclass());
        Type[] typeArguments = type.getActualTypeArguments();
        @SuppressWarnings("unchecked")
        Class<C> result = (Class<C>) typeArguments[0];
        commandType = result;
        this.commandHandlerOperations = commandHandlerOperations;
    }

    @Override
    public final Class<C> commandType() {
        return commandType;
    }

    protected final <A extends Aggregate> Optional<A> tryToFindAggregateByKey(final DomainRepository<A> repository, final String key) {
        checkArgument(repository != null, "repository can not be null");
        checkArgument(isNotBlank(key), "key can not be blank");
        final A aggregate = repository.findOne(key);
        return Optional.ofNullable(aggregate);
    }

    protected final <A extends Aggregate> A put(final DomainRepository<A> repository, final String key, Supplier<A> ifAbsent, Consumer<A> ifPresent) {
        checkArgument(ifAbsent != null, "ifAbsent can not be null");
        checkArgument(ifPresent != null, "ifPresent can not be null");
        final Optional<A> aggregate = tryToFindAggregateByKey(repository, key);
        if (aggregate.isPresent()) {
            ifPresent.accept(aggregate.get());
            return aggregate.get();
        } else {
            final A transientAggregate = ifAbsent.get();
            return repository.save(transientAggregate);
        }
    }

}
