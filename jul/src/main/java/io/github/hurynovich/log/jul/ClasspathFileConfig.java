package io.github.hurynovich.log.jul;

import java.io.InputStream;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.*;

import static java.lang.String.format;

public final class ClasspathFileConfig {
    public ClasspathFileConfig(){
        reloadConfig();
    }


    public static final String DEFAULT_CONFIG_PROD = "/logging.properties";
    public static final String DEFAULT_CONFIG_TEST = "/logging-test.properties";

    /**
     * Reloads logging config from '/logging-test.properties' file if it is present otherwise
     * reloads config from '/logging.properties'.
     */
    private static void reloadConfig(){
        var loader = LogConfigReloader.class;
        if(isResourcePresent(loader, DEFAULT_CONFIG_TEST)){
            reloadConfig(loader, DEFAULT_CONFIG_TEST);
        } else {
            reloadConfig(loader, DEFAULT_CONFIG_PROD);
        }
    }

    /**
     * Reloads logging config from file placed in classpath.
     *
     * @param loader - used to load file content from classpath.
     * @param configPath - path to configuration file within classpath.
     */
    private static void reloadConfig(Class<?> loader, String configPath){
        InputStream res = loader.getResourceAsStream(configPath);
        if (res == null){
            System.err.println(format("'%s' file was not found in classpath.%n", configPath));
            return;
        }

        try (InputStream conf = res){
            //reload config
           LogManager.getLogManager().readConfiguration(conf);
        } catch (Exception e) {
            System.err.print(format("Failed to reload logging config from '%s' file. ", configPath));
            return;
        }
    }

    private static boolean isResourcePresent(Class<?> loader, String resourcePath){
        try(var res = loader.getResourceAsStream(resourcePath)){
            return res != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean setSystemPropertyIfEmpty(){
       return Util.setLoggingConfigPropertyIfEmpty(ClasspathFileConfig.class);
    }
}
