package edu.csc1061.utils;

public class Logger {
    private Logger() {
        // private logger so that no one can create it.
    }

    private static Logger instance;

    public static Logger getLogger() {
        if (instance == null) {
            // logger not created so create it.
            instance = new Logger();
        }
        return instance;
    }

    private int lineCounter = 0;

    public void println(String string) {
        System.out.println("(" + lineCounter++ + ")" + string);
    }
}
