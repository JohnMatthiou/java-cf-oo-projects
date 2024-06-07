package logger;

public class Main {
    public static void main(String[] args) {

        try {
            throw new Exception("Unexpected error occurred");
        } catch (Exception e) {
            Logger errorLog = Logger.getInstance();
            errorLog.logMessage(e.getMessage());
        }
    }
}
