import io.github.hurynovich.log.jul.LogConfig;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;
import static java.util.logging.Level.*;

public class HelloJul {

    //create single logger per class
    private static Logger log = Logger.getLogger(HelloJul.class.getCanonicalName());
    
    public static void sayHello(){
        log.log(SEVERE, ":)");
        log.setLevel(Level.ALL);

        for(Handler h : Logger.getGlobal().getHandlers()){
            log.log(SEVERE, "Handler " + h.toString());
            h.setLevel(SEVERE);
        }

        String msg = "Hello, this is log message #%d.";
        final AtomicInteger i = new AtomicInteger(0);
        log.log(SEVERE,  ()-> String.format(msg, i.incrementAndGet()));
        log.log(WARNING, ()-> String.format(msg, i.incrementAndGet()));
        log.log(INFO, ()-> String.format(msg, i.incrementAndGet()));
        log.log(CONFIG, ()-> String.format(msg, i.incrementAndGet()));
        log.log(FINE, ()-> String.format(msg, i.incrementAndGet()));
        log.log(FINER, ()-> String.format(msg, i.incrementAndGet()));
        log.log(FINEST, ()-> String.format(msg, i.incrementAndGet()));
    }

    public static void main(String[] args) {
        LogConfig.reloadLogConfig();
        sayHello();
    }
}
