package io.github.hurynovich.log.jul;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static java.lang.String.format;
import static java.util.logging.Level.*;

public class Main {
    //create single logger per class
    private static Logger log = Logger.getLogger(Main.class.getCanonicalName());


    public static void main(String[] args){
        var ex = new Exception("Some exception example.");
        log.log(INFO, "This message is made with initial log config.", ex);
        LogConfig.reloadConfig();
        log.log(INFO,"This message is made after log config was reloaded.", ex);

        log.info("----------------------------------------------");

        String msg = "Hello, this is log message #%d.";
        final AtomicInteger i = new AtomicInteger(0);
        log.log(SEVERE,  format(msg, i.incrementAndGet()));
        log.log(WARNING, format(msg, i.incrementAndGet()));
        log.log(INFO,    format(msg, i.incrementAndGet()));
        log.log(CONFIG,  format(msg, i.incrementAndGet()));
        log.log(FINE,    format(msg, i.incrementAndGet()));
        log.log(FINER,   format(msg, i.incrementAndGet()));
        log.log(FINEST,  format(msg, i.incrementAndGet()));
    }
}
