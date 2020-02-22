package io.github.hurynovich.log.jul;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public final class SysoutConfig {
    public SysoutConfig(){
        Logger root = Logger.getLogger("");
        root.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
        Logger.getGlobal().config("Handler to output logs to System.out was added to root logger.");
    }

    public static boolean setSystemPropertyIfEmpty(){
            return Util.setLoggingConfigPropertyIfEmpty(SysoutConfig.class);
    }
}
