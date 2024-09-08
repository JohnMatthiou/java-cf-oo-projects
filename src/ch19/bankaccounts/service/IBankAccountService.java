package ch19.bankaccounts.service;

import ch19.bankaccounts.dto.BankAccountInsertDTO;
import ch19.bankaccounts.dto.BankAccountUpdateDTO;
import ch19.bankaccounts.model.BankAccount;
import ch19.bankaccounts.service.exceptions.*;

import java.util.List;

public interface IBankAccountService {

    BankAccount insertBankAccount(BankAccountInsertDTO dto)
            throws IbanAlreadyExistsException, AccountIdAlreadyExistsException;

    BankAccount updateBankAccount(long id, BankAccountUpdateDTO dto)
        throws IbanAlreadyExistsException, AccountIdAlreadyExistsException, AccountNotFoundException;

    void deleteBankAccountById(long id) throws AccountNotFoundException, BalanceNotZeroException;

    void deleteBankAccountByIban(String iban) throws AccountNotFoundException, BalanceNotZeroException;

    BankAccount getBankAccountById(long id) throws AccountNotFoundException;

    BankAccount getBankAccountByIban(String iban) throws AccountNotFoundException;

    List<BankAccount> getAllBankAccounts();

    double depositToBankAccount(String iban, double amount) throws AccountNotFoundException, NegativeAmountException;

    double withdrawFromBankAccount(String iban, double amount, String ssn)
        throws AccountNotFoundException, SsnNotValidException, NegativeAmountException, InsufficientBalanceException;

    double getBankAccountBalance(String iban) throws AccountNotFoundException;

}
