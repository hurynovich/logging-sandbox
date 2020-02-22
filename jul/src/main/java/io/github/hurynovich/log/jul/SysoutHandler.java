package io.github.hurynovich.log.jul;

import java.util.logging.*;

/**
 *
 */
public final class SysoutHandler extends StreamHandler {

    /** Creates new {@code SysoutHandler}. */
    public SysoutHandler() {
        super();
        setOutputStream(System.out);
    }

    /** {@inheritDoc} */
    @Override
    public void publish(LogRecord record) {
        super.publish(record);
        flush();
    }

    /** {@inheritDoc} */
    @Override
    public void close() {
        flush();
    }

}
