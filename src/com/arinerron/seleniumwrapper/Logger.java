package com.arinerron.seleniumwrapper;

public class Logger {
    // define multiple levels of severity
    public static final String
        LEVEL_DEBUG = "/",
        LEVEL_INFO = "+",
        LEVEL_WARNING = "!",
        LEVEL_ERROR = "-",
        LEVEL_FATAL = "X";

    public static void log(String level, Object message) {
        System.out.println("[" + level + "] " + message);
    }

    /* these functions make it easier to log data, but are not necessary */

    public static void debug(Object message) {
        Logger.log(Logger.LEVEL_DEBUG, message);
    }

    public static void info(Object message) {
        Logger.log(Logger.LEVEL_INFO, message);
    }

    public static void warn(Object message) {
        Logger.log(Logger.LEVEL_WARNING, message);
    }

    public static void error(Object message) {
        Logger.log(Logger.LEVEL_ERROR, message);
    }

    public static void fatal(Object message) {
        Logger.log(Logger.LEVEL_FATAL, message);
    }
}
