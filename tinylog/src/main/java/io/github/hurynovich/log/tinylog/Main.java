package io.github.hurynovich.log.tinylog;

import static org.tinylog.Logger.*;

public class Main {
    public static void main(String[] args) {
        debug("Hi from debug.");
        info("Hi this is info.");
        warn("Here is a warning.");
        error(new Exception("Some problem."), "Oops, we have a problem.");
        error(new Exception("Just exception."));
        error("Just message.");

        info("Simple placeholder: '{}'.", ":)");
        info("Lambdas as parameter: '{} rolls {}'.", () -> System.getProperty("user.name"), Math::random );
    }
}
