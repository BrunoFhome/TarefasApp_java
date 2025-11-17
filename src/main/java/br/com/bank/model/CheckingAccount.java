package br.com.bank.model;

public class CheckingAccount extends Account{
    public CheckingAccount (int number, String owner){
        super(number, owner);
    }

    @Override
    public String toString(){
        return "ContaCorrente{" +
                "numero=" + number +
                ", titular='" + owner + '\'' +
                ", saldo=" + balance +
                '}';
    }
}
