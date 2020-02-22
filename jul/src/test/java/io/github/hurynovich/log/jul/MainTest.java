package io.github.hurynovich.log.jul;

import org.junit.Test;

import java.util.logging.Logger;

import static java.lang.String.format;
import static java.util.logging.Level.*;
import static java.util.logging.Level.FINEST;

public class MainTest{
    //create single logger per class
    private static Logger log = Logger.getLogger(Main.class.getCanonicalName());

    @Test
    public void testMain(){
        var ex = new Exception("Some exception example.");
        log.log(INFO, "This message is made with initial log config.", ex);
        LogConfigReloader.reloadConfig();
        log.log(INFO,"This message is made after log config was reloaded.", ex);

        log.info("----------------------------------------------");

        String msg = "Hello, this is log message #%d.";
        int i = 1;
        log.log(SEVERE,  format(msg, i++));
        log.log(WARNING, format(msg, i++));
        log.log(INFO,    format(msg, i++));
        log.log(CONFIG,  format(msg, i++));
        log.log(FINE,    format(msg, i++));
        log.log(FINER,   format(msg, i++));
        log.log(FINEST,  format(msg, i++));
    }
}
