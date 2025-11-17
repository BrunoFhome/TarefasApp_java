package br.com.bank.model;

public class SavingsAccount extends Account{
    public SavingsAccount(int number, String owner){
        super(number, owner);
    }
    @Override
    public String toString(){
        return "ContaPoupanca{" +
                "numero=" + number +
                ", titular='" + owner + '\'' +
                ", saldo=" + balance +
                '}';
    }
}
