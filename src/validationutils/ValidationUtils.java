package validationutils;

public class ValidationUtils {

    public ValidationUtils() {

    }

    public static boolean isWithinRange(int low, int high, String input) {
        if (low > high) {
            throw new IllegalArgumentException("Error. Invalid range");
        }

        if (input.length() >= low && input.length() <= high) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWithinRange(int low, int high, int num) {
        if (low > high) {
            throw new IllegalArgumentException("Error. Invalid range");
        }

        if (num >= low && num <= high) {
            return true;
        } else {
            return false;
        }
    }
}
