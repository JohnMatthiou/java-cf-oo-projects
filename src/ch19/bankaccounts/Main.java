package ch19.bankaccounts;

import ch19.bankaccounts.dao.BankAccountDAOImpl;
import ch19.bankaccounts.dao.IBankAccountDAO;
import ch19.bankaccounts.dto.*;
import ch19.bankaccounts.model.BankAccount;
import ch19.bankaccounts.model.User;
import ch19.bankaccounts.service.BankAccountServiceImpl;
import ch19.bankaccounts.service.IBankAccountService;
import ch19.bankaccounts.service.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private final static IBankAccountDAO dao = new BankAccountDAOImpl();
    private final static IBankAccountService service = new BankAccountServiceImpl(dao);

    public static void main(String[] args) {
        String choice = "";

        while (true) {
            printMenu();
            System.out.println("Παρακαλώ εισάγετε επιλογή");
            choice = getChoice();

            if (choice.matches("[qQ]")) {
                System.out.println("GoodBye. Thanks for using our app");
                break;
            }

            if (!choice.matches("[1-8]")) {
                System.out.println("Error in choice");
                continue;
            }

            processWithChoice(choice);
        }
    }

    public static void processWithChoice(String choice) {
        BankAccount account;
        long id;
        String iban;
        String ssn;
        double amount;

        switch (choice) {
            case "1":
                account = getBankAccount();
                insertAccount(account);
                break;
            case "2":
                System.out.println("Παρακαλώ δώστε το id του λογσριασμού προς ενημέρωση");
                id = scanner.nextLong();
                System.out.println("Παρακαλώ εισάγετε τα στοιχεία του νέου λογαριασμού");
                account = getBankAccount();
                updateAccount(id, account);
                break;
            case "3":
                System.out.println("Παρακαλώ δώστε το iban του λογαριασμού προς διαγραφή");
                iban = scanner.nextLine().trim();
                deleteAccount(iban);
                break;
            case "4":
                System.out.println("Παρακαλώ δώστε το iban του λογαριασμού προς αναζήτηση");
                iban = scanner.nextLine().trim();
                BankAccountReadOnlyDTO dto = getAccountByIban(iban);
                if (dto == null) {
                    System.out.println("Ο λογαριασμός δεν βρέθηκε");
                } else {
                    System.out.println(dto);
                }
                break;
            case "5":
                List<BankAccountReadOnlyDTO> accounts = getAccounts();
                printAccounts(accounts);
                break;
            case "6":
                System.out.println("Παρακαλώ δώστε το iban του λογαριασμού για κατάθεση");
                iban = scanner.nextLine().trim();
                System.out.println("Παρακαλώ δώστε το ποσό της κατάθεσης");
                amount = scanner.nextDouble();
                scanner.nextLine();
                depositToAccount(iban, amount);
                break;
            case "7":
                System.out.println("Παρακαλώ δώστε το iban του λογαριασμού για ανάληψη");
                iban = scanner.nextLine().trim();
                System.out.println("Παρακαλώ δώστε το ποσό προς ανάληψη");
                amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Παρακαλώ εισάγετε τον αριθμό κοινωνικής ασφάλισης");
                ssn = scanner.nextLine().trim();
                withdrawFromAccount(iban, amount, ssn);
                break;
            case "8":
                System.out.println("Παρακαλώ δώστε το iban του λογαριασμού για προβολή υπολοίπου");
                iban = scanner.nextLine().trim();
                getAccountBalance(iban);
                break;
            default:
                System.out.println("Generic error.");

        }
    }

    public static void insertAccount(BankAccount account) {
        try {
            BankAccountInsertDTO insertDTO = mapToAccountInsertDto(account);
            BankAccount ba = service.insertBankAccount(insertDTO);
            System.out.println("Επιτυχής εισαγωγή: " + ba);
        } catch (IbanAlreadyExistsException | AccountIdAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateAccount(long id, BankAccount account) {
        try {
            BankAccountUpdateDTO updateDTO = mapToAccountUpdateDto(account);
            BankAccount ba = service.updateBankAccount(id, updateDTO);
            System.out.println("Επιτυχής ενημέρωση: " + ba);
        } catch (IbanAlreadyExistsException | AccountIdAlreadyExistsException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAccount(String iban) {
        try {
            service.deleteBankAccountByIban(iban);
            System.out.println("Ο λογαριασμός διαγράφηκε επιτυχώς");
        } catch (AccountNotFoundException | BalanceNotZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public static BankAccountReadOnlyDTO getAccountByIban(String iban) {
        BankAccount ba = null;
        try {
            ba = service.getBankAccountByIban(iban);
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (ba == null) return null;
        return mapToAccountReadOnlyDto(ba);
    }

    public static List<BankAccountReadOnlyDTO> getAccounts() {
        List<BankAccount> accounts = service.getAllBankAccounts();
        return mapToAccountsReadOnlyDto(accounts);
    }

    private static void printAccounts(List<BankAccountReadOnlyDTO> accounts) {
        accounts.forEach(System.out::println);
    }

    private static void depositToAccount(String iban, double amount) {
        double newBalance;
        try {
            newBalance = service.depositToBankAccount(iban, amount);
            System.out.println("Επιτυχής κατάθεση. Νέο υπόλοιπο λογαριασμού: " + newBalance + "€");
        } catch (AccountNotFoundException | NegativeAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void withdrawFromAccount(String iban, double amount, String ssn) {
        double newBalance;
        try {
            newBalance = service.withdrawFromBankAccount(iban, amount, ssn);
            System.out.println("Επιτυχής ανάληψη. Νέο υπόλοιπο λογαριασμού: " + newBalance + "€");
        } catch (AccountNotFoundException | NegativeAmountException | SsnNotValidException |
                 InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getAccountBalance(String iban) {
        double balance;
        try {
            balance = service.getBankAccountBalance(iban);
            System.out.println("Υπόλοιπο λογαριασμού: " + balance + "€");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



    public static BankAccount getBankAccount() {
        BankAccount account = new BankAccount();
        double balance;

        System.out.println("Παρακαλώ εισάγετε τον κωδικό του λογαριασμού");
        account.setId(scanner.nextLong());

        scanner.nextLine();

        System.out.println("Παρακαλώ εισάγετε το iban");
        account.setIban(scanner.nextLine());

        User holder = new User();
        System.out.println("Παρακαλώ εισάγετε τον κωδικό κατόχου");
        holder.setId(scanner.nextLong());

        scanner.nextLine();

        System.out.println("Παρακαλώ εισάγετε το όνομα");
        holder.setFirstname(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε το επώνυμο");
        holder.setLastname(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε τον αριθμό κοινωνικής ασφάλισης");
        holder.setSsn(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε το υπόλοιπο");
        balance = scanner.nextDouble();
        while (balance < 0) {
            System.out.println("Παρακαλώ εισάγετε θετικό αριθμό");
            balance = scanner.nextDouble();
        }
        account.setBalance(balance);

        scanner.nextLine();

        account.setHolder(holder);
        return account;
    }

    private static BankAccountInsertDTO mapToAccountInsertDto(BankAccount account) {
        return new BankAccountInsertDTO(account.getId(), account.getIban(), mapToUserInsertDto(account.getHolder()), account.getBalance());
    }

    private static UserInsertDTO mapToUserInsertDto(User holder) {
        return new UserInsertDTO(holder.getId(), holder.getFirstname(), holder.getLastname(), holder.getSsn());
    }

    private static BankAccountUpdateDTO mapToAccountUpdateDto(BankAccount account) {
        return new BankAccountUpdateDTO(account.getId(), account.getIban(), mapToUserUpdateDto(account.getHolder()), account.getBalance());
    }

    private static UserUpdateDTO mapToUserUpdateDto(User holder) {
        return new UserUpdateDTO(holder.getId(), holder.getFirstname(), holder.getLastname(), holder.getSsn());
    }

    private static BankAccountReadOnlyDTO mapToAccountReadOnlyDto(BankAccount account) {
        return new BankAccountReadOnlyDTO(account.getId(), account.getIban(), mapToUserReadOnlyDto(account.getHolder()), account.getBalance());
    }

    private static UserReadOnlyDTO mapToUserReadOnlyDto(User holder) {
        return new UserReadOnlyDTO(holder.getId(), holder.getFirstname(), holder.getLastname(), holder.getSsn());
    }

    private static List<BankAccountReadOnlyDTO> mapToAccountsReadOnlyDto(List<BankAccount> accounts) {
        List<BankAccountReadOnlyDTO> accountReadOnlyDTOS = new ArrayList<>();
        for (BankAccount account : accounts) {
            accountReadOnlyDTOS.add(mapToAccountReadOnlyDto(account));
        }
        return accountReadOnlyDTOS;
    }


    public static void printMenu() {
        System.out.println("Επιλέξτε ένα από τα παρακάτω");
        System.out.println("1. Εισαγωγή λογαριασμού");
        System.out.println("2. Ενημέρωση λογαριασμού");
        System.out.println("3. Διαγραφή λογαριασμού");
        System.out.println("4. Αναζήτηση λογαριασμού με iban");
        System.out.println("5. Εκτύπωση όλων των λογαριασμών");
        System.out.println("6. Κατάθεση σε λογαριασμό");
        System.out.println("7. Ανάληψη από λογαριασμό");
        System.out.println("8. Υπόλοιπο λογαριασμού");
        System.out.println("9. q/Q για έξοδο");
    }

    public static String getChoice() {
        return scanner.nextLine().trim();
    }
}


