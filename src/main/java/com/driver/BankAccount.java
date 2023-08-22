package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    //---------- Constructor -----------
    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public BankAccount() {
    }

    //-------------Getters and Setters--------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    //------------- Other Functions ------------------
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder number = new StringBuilder();
        if(digits*9<sum) throw new Exception("Account Number can not be generated");
        else{
            while(digits>0){
                if(sum>=9){
                    number.append('9');
                    sum-=9;
                }else{
                    number.append(sum);
                    sum = 0;
                }
                digits--;
            }
        }
        return number.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance<amount){
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
    }

}