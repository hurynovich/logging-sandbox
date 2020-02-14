package io.github.hurynovich.log.jul;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.*;

public final class LogConfig {
    /**
     * Mapper which always choices value from new config for any key.
     */
    private final static Function<String, BiFunction<String, String, String>> REPLACE_All_MAPPER = (key) -> {
        return (oldVal, newVal) -> newVal;
    };

    public static void reloadLogConfig(){
        InputStream res = LogConfig.class.getResourceAsStream("/logging.properties");
        if (res == null){
            System.err.println("'logging.properties' file was not found in classpath.");
            return;
        }

        try (InputStream conf = res){
            //reload config
            LogManager.getLogManager().updateConfiguration(conf, REPLACE_All_MAPPER );

            //add handler to print in System.out
            Handler sysoutHandler = new StreamHandler(System.out, new SimpleFormatter());
            sysoutHandler.setLevel(Level.ALL);
            Logger root = Logger.getLogger("");
            root.addHandler(sysoutHandler);
        } catch (Exception e) {
            System.err.print("Failed to reload Logger config. " + e.getMessage());
        }
    }
}
