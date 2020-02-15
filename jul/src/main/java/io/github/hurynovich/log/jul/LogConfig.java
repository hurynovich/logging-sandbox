package io.github.hurynovich.log.jul;

import java.io.InputStream;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.*;

import static java.lang.String.format;

public final class LogConfig {
    /**
     * Reloads logging config from 'logging.properties' file.
     */
    public static void reloadConfig(){
        reloadConfig(LogConfig.class.getClassLoader(), "/logging.properties");
    }

    /**
     * Reloads logging config from file placed in classpath.
     *
     * @param loader - used to load file content from classpath.
     * @param configPath - path to configuration file within classpath.
     */
    public static void reloadConfig(ClassLoader loader, String configPath){
        InputStream res = loader.getResourceAsStream(configPath);
        if (res == null){
            Logger.getGlobal().severe(format("'%s' file was not found in classpath.%n", configPath));
            return;
        }

        try (InputStream conf = res){
            //reload config
            LogManager.getLogManager().updateConfiguration(conf, LogConfig::getReplaceAllMapper);

            //add handler to print in System.out if nothing defined
            Logger root = Logger.getLogger("");
            if(root.getHandlers().length == 0){
                Handler sysoutHandler = new StreamHandler(System.out, new SimpleFormatter());
                root.addHandler(sysoutHandler);
            }
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, format("Failed to reload logging config from '%s' file.", configPath), e);
        }
    }

    /**
     * This method is used as mapper in {@link LogManager#updateConfiguration(Function)}.
     * And it overrides all old values by new values.
     */
    private static BiFunction<String, String, String> getReplaceAllMapper(String key) {
        return (oldVal, newVal) -> newVal;
    };
}
