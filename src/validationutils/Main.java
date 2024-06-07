package validationutils;

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        int num = 6;

        try {
            System.out.printf("Is \"%s\" between 1-31 characters? : %b\n", s1, ValidationUtils.isWithinRange(1, 31, s1));
            System.out.printf("Is %d between 1-10? : %b", num, ValidationUtils.isWithinRange(1, 10, num));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
