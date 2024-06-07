package stringutils;

public class StringUtils {

    private StringUtils() {

    }

    public static String reverseString(String input) throws Exception{
        if (input == null || input.isEmpty()) {
            throw new Exception("Error. Empty String!");
        }

        String reversed = "";

        for (int i = input.length() - 1; i >=0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }


    public static String turnToUpperCase(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            throw new Exception("Error. Empty String!");
        }

        return input.toUpperCase();
    }


    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
