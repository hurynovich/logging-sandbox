package io.github.hurynovich.log.jul;

import java.net.URISyntaxException;
import java.util.logging.Logger;

public class RunExample1 {
    private static final boolean IS_CUSTOM_CONFIG_SET = ClasspathFileConfig.setSystemPropertyIfEmpty();

    private static final Logger log = Logger.getLogger(RunExample1.class.getCanonicalName());

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(IS_CUSTOM_CONFIG_SET);
        log.info("Hello");
    }
}
