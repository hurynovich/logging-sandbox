import io.github.hurynovich.log.jul.HelloJul;
import org.junit.Test;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloJulTest {
    //create single logger per class
    private static Logger log = Logger.getLogger(HelloJul.class.getCanonicalName());
    private static Logger root = Logger.getLogger("");

    @Test
    public void sayHello() {
        log.log(Level.SEVERE, ":)");
        log.setLevel(Level.ALL);

        for (Handler h : Logger.getGlobal().getHandlers()) {
            log.log(Level.SEVERE, "Handler " + h.toString());
            h.setLevel(Level.SEVERE);
        }

        String msg = "Hello, this is log message.";
        log.log(Level.SEVERE, msg);
        log.log(Level.WARNING, msg);
        log.log(Level.INFO, msg, new NullPointerException());
        log.log(Level.CONFIG, msg);
        log.log(Level.FINE, msg);
        log.log(Level.FINER, msg);
        log.log(Level.FINEST, msg);
    }
}