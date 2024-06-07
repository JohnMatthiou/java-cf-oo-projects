package stringutils;

public class Main {
    public static void main(String[] args) {
        String s1 = "abba";


        try {
            System.out.println("Reversed string: " + StringUtils.reverseString(s1));
            System.out.println("String to uppercase: " + StringUtils.turnToUpperCase(s1));
            System.out.println("String is palindrome: " + StringUtils.isPalindrome(s1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}
