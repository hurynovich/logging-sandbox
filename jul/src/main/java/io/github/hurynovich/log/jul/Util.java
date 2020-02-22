package io.github.hurynovich.log.jul;

final class Util {
    private static final String CONFIG_FILE_PROPERTY = "java.util.logging.config.file";
    private static final String CONFIG_CLASS_PROPERTY = "java.util.logging.config.class";

    public static boolean setLoggingConfigPropertyIfEmpty(Class<?> clazz){
        if(System.getProperty(CONFIG_FILE_PROPERTY) != null) return false;
        if(System.getProperty(CONFIG_CLASS_PROPERTY) != null) return false;

        System.setProperty(CONFIG_CLASS_PROPERTY, clazz.getCanonicalName());
        return true;
    }

}
