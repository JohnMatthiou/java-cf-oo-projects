package ch19.bankaccounts.service;

import ch19.bankaccounts.dao.IBankAccountDAO;
import ch19.bankaccounts.dto.BankAccountInsertDTO;
import ch19.bankaccounts.dto.BankAccountUpdateDTO;
import ch19.bankaccounts.dto.UserInsertDTO;
import ch19.bankaccounts.dto.UserUpdateDTO;
import ch19.bankaccounts.model.BankAccount;
import ch19.bankaccounts.model.User;
import ch19.bankaccounts.service.exceptions.*;

import java.util.List;

public class BankAccountServiceImpl implements IBankAccountService {
    private final IBankAccountDAO dao;

    public BankAccountServiceImpl(IBankAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public BankAccount insertBankAccount(BankAccountInsertDTO dto) throws IbanAlreadyExistsException, AccountIdAlreadyExistsException {
        BankAccount account;

        try {
            account = mapBankAccountFromInsertDTO(dto);

            if (dao.ibanExists(account.getIban())) {
                throw new IbanAlreadyExistsException(account);
            }

            if (dao.accountIdExists(account.getId())) {
                throw new AccountIdAlreadyExistsException(account);
            }

            //logging for success
            return dao.insert(account);
        } catch (IbanAlreadyExistsException | AccountIdAlreadyExistsException e) {
            //logging
            throw e;
        }
    }


    private BankAccount mapBankAccountFromInsertDTO(BankAccountInsertDTO dto) {
        User holder = mapUserInsertDTO(dto.getUserInsertDTO());
        return new BankAccount(dto.getId(), dto.getIban(), holder, dto.getBalance());
    }

    private User mapUserInsertDTO(UserInsertDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }


    @Override
    public BankAccount updateBankAccount(long id, BankAccountUpdateDTO newDto) throws IbanAlreadyExistsException, AccountIdAlreadyExistsException, AccountNotFoundException {
        BankAccount account;

        try {
            account = mapBankAccountFromUpdateDTO(newDto);

            if (!dao.accountIdExists(id)) {
                throw new AccountNotFoundException(id);
            }

            BankAccount oldAccount = dao.get(id);

            if ((dao.ibanExists(account.getIban())) && (!account.getIban().equals(oldAccount.getIban()))) {
                throw new IbanAlreadyExistsException(account);
            }

            if ((dao.accountIdExists(account.getId())) && (account.getId() != oldAccount.getId())) {
                throw new AccountIdAlreadyExistsException(account);
            }

            //logging
            return dao.update(id, account);
        } catch (AccountNotFoundException | IbanAlreadyExistsException | AccountIdAlreadyExistsException e) {
            //logging
            throw e;
        }
    }

    private BankAccount mapBankAccountFromUpdateDTO(BankAccountUpdateDTO dto) {
        User holder = mapUserFromUpdateDTO(dto.getUserUpdateDTO());
        return new BankAccount(dto.getId(), dto.getIban(), holder, dto.getBalance());
    }

    private User mapUserFromUpdateDTO(UserUpdateDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    @Override
    public void deleteBankAccountById(long id) throws AccountNotFoundException, BalanceNotZeroException {
    try {
        if (!dao.accountIdExists(id)) {
            throw new AccountNotFoundException(id);
        }

        if (dao.getBalance(id) > 0){
            throw new BalanceNotZeroException(id, dao.getBalance(id));
        }

        //logging
        dao.delete(id);
    } catch (AccountNotFoundException | BalanceNotZeroException e) {
        //logging
        throw e;
    }

    }

    @Override
    public void deleteBankAccountByIban(String iban) throws AccountNotFoundException, BalanceNotZeroException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            if (dao.getBalance(iban) > 0){
                throw new BalanceNotZeroException(iban, dao.getBalance(iban));
            }

            //logging
            dao.delete(iban);
        } catch (AccountNotFoundException | BalanceNotZeroException e) {
            //logging
            throw e;
        }
    }

    @Override
    public BankAccount getBankAccountById(long id) throws AccountNotFoundException {
        BankAccount account;

        try {
            account = dao.get(id);
            if (account == null) {
                throw new AccountNotFoundException(id);
            }

            //logging
            return account;
        } catch (AccountNotFoundException e) {
         //logging
         throw e;
        }
    }

    @Override
    public BankAccount getBankAccountByIban(String iban) throws AccountNotFoundException {
        BankAccount account;

        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }

            //logging
            return account;
        } catch (AccountNotFoundException e) {
            //logging
            throw e;
        }
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return dao.getAll();
    }

    @Override
    public double depositToBankAccount(String iban, double amount) throws AccountNotFoundException, NegativeAmountException {

        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            if (amount < 0) {
                throw new NegativeAmountException();
            }

            //logging
            return dao.deposit(iban, amount);
        } catch (AccountNotFoundException | NegativeAmountException e) {
            //logging
            throw e;
        }
    }

    @Override
    public double withdrawFromBankAccount(String iban, double amount, String ssn) throws AccountNotFoundException, SsnNotValidException, NegativeAmountException, InsufficientBalanceException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            if (amount < 0) {
                throw new NegativeAmountException();
            }

            if (amount > dao.get(iban).getBalance()) {
                throw new InsufficientBalanceException(dao.get(iban).getBalance());
            }

            if (dao.getSsn(iban) == null || (!dao.getSsn(iban).equals(ssn))) {
                throw new SsnNotValidException();
            }

            //logging
            return dao.withdraw(iban, amount);
        } catch (AccountNotFoundException | NegativeAmountException | SsnNotValidException |
                 InsufficientBalanceException e) {
            //logging
            throw e;
        }
    }

    @Override
    public double getBankAccountBalance(String iban) throws AccountNotFoundException {

        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            //logging
            return dao.getBalance(iban);
        } catch (AccountNotFoundException e) {
            //logging
            throw e;
        }

    }
}
