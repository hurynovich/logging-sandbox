package io.github.hurynovich.log.jul;

import java.net.URISyntaxException;
import java.util.logging.Logger;

public class RunExample2 {
    private static final boolean IS_CUSTOM_CONFIG_SET = SysoutConfig.setSystemPropertyIfEmpty();

    private static final Logger log = Logger.getGlobal();

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(IS_CUSTOM_CONFIG_SET);
        log.severe("Hello");
    }
}
