package logger;

import java.time.LocalDateTime;

public class Logger {
    private static final Logger SINGLETON = new Logger();

    private Logger() {

    }

    public static Logger getInstance() {
        return SINGLETON;
    }

    public void logMessage(String message) {
        System.err.println(message + " " + LocalDateTime.now().withNano(0));
    }
}
