package br.com.bank.model;

public class Account {

    protected int number;
    protected String owner;
    protected double balance;

    public Account(int number, String owner){
        this.number = number;
        this.owner = owner;
        this.balance = 0.0;
    }

    public int getNumber(){
        return number;
    }

    public String getOwner(){
        return owner;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double value){
        if (value <= 0){
            throw new IllegalArgumentException("Deposito deve ser positivo");
        }
        balance += value;
    }

    public void withdraw(double value){
        if (value <= 0){
            throw new IllegalArgumentException("Saque deve ser positivo");
        }
        if (balance<value){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        balance -= value;
    }

    public void transfer(Account destination, double value){
        withdraw(value);
        destination.deposit(value);
    }


    @Override
    public String toString(){
        return "Conta{" +
                "numero=" + number +
                ", titular='" + owner + '\'' +
                ", saldo=" + balance +
                '}';
    }
}
