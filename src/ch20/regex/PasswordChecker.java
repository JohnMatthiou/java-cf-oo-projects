package ch20.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Give a password having at least 8 characters including at least one lowercase letter, at least one uppercase letter, at least one number and at least one of the following spacial characters [#?!@$%^&*-]");
            String password = scanner.nextLine();

            Pattern pattern = Pattern.compile("(?=.*?[a-z])(?=.*?[A-Z])(?=.*[0-9])(?=.*?[#?!@$%^&*-])^.{8,}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                System.out.println("Password setup success!");
                break;
            } else {
                System.out.println("Error.Invalid password, try again.");
            }
        }
    }
}
