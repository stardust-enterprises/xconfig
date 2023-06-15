package enterprises.stardust.xconfig.middleend;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A {@link Consumer} and a {@link Supplier} at the same time.
 *
 * @param <T> the type of the value
 *
 * @author xtrm
 * @since 0.0.1
 */
public interface Value<T> extends Consumer<T>, Supplier<T> {
    /**
     * Convenience method for {@link #set}.
     *
     * @param t the input argument
     */
    @Override
    default void accept(T t) {
        set(t);
    }

    void set(T t);
}
