package io.github.hurynovich.log.tinylog;

import static org.tinylog.Logger.*;

public class Main {

    public static void main(String[] args) {
        debug("Hi from debug.");
        info("Hi this is info.");
        error("Oops", new Exception("!"));

    }
}
