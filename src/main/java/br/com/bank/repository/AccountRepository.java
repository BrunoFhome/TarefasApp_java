package br.com.bank.repository;


import br.com.bank.model.Account;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Collection;


public class AccountRepository {
    private final Map<Integer, Account> accounts;

    public AccountRepository(){
        this.accounts = new HashMap<>();
    }

    public void save(Account account){
        accounts.put(account.getNumber(), account);
    }

    public Optional <Account> findByNumber(int number){
        return Optional.ofNullable(accounts.get(number));
    }

    public Collection <Account> findAll(){
        return accounts.values();
    }

    public boolean exists(int number){
        return accounts.containsKey(number);
    }
}
