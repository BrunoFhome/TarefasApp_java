package br.com.bank.service;

import br.com.bank.model.Account;
import br.com.bank.model.CheckingAccount;
import br.com.bank.model.SavingsAccount;
import br.com.bank.repository.AccountRepository;


public class BankService {
    private final AccountRepository repository;

    public BankService(AccountRepository repository){
        this.repository = repository;
    }

    public Account createCheckingAccount(int number, String owner){
        if (repository.exists(number)){
            throw new IllegalArgumentException("Conta ja existe");
        }
        Account account = new CheckingAccount(number, owner);
        repository.save(account);
        return account;
    }

    public Account createSavingsAccount(int number, String owner){
        if (repository.exists(number)){
            throw new IllegalArgumentException("Conta ja existe");
        }
        Account account = new SavingsAccount(number, owner);
        repository.save(account);
        return account;
    }

    public void deposit(int number, double value){
        Account account = getAccountOrThrow(number);
        account.deposit(value);
    }

    public void withdraw(int number, double value){
        Account account = getAccountOrThrow(number);
        account.withdraw(value);
    }

    public void transfer(int sourceNumber, int destinationNumber, double value){
        Account source = getAccountOrThrow(sourceNumber);
        Account destination = getAccountOrThrow(destinationNumber);
        source.transfer(destination, value);
    }

    public Iterable<Account> listAccounts(){
        return repository.findAll();
    }

    private Account getAccountOrThrow(int number){
        return repository.findByNumber(number)
                .orElseThrow(()-> new IllegalArgumentException("Conta nao encontrada" + number));
    }
}
