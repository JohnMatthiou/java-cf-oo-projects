package bankapp;

import bankapp.model.OverdraftAccount;
import bankapp.model.JointAccount;

public class Main {

    public static void main(String[] args) {
        OverdraftAccount alice = new OverdraftAccount(1, "GR123", "Alice", "W.", "12345", 100.0);
        JointAccount aliceBob = new JointAccount(2, "GR468", "Alice", "W.", "12345", "Bob", "Seger", "21124", 250.0);

        try {
            alice.deposit(1000);
            alice.withdraw(500, "12345");

            System.out.println(alice.getAccountBalance());

            alice.withdraw(700, "12345");

            System.out.println(alice.getAccountBalance());

            System.out.println("Alice Account State");
            System.out.println(alice.accountToString());


            aliceBob.deposit(100);
            aliceBob.withdraw(200, "12345");

            System.out.println(aliceBob.getAccountBalance());

            aliceBob.withdraw(50, "21124");

            System.out.println("Alice-Bob Account State");
            System.out.println(aliceBob.accountToString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
