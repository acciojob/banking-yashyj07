package com.driver;

public class StudentAccount extends BankAccount{

    private String  institutionName;


    //--------- Constructor ----------
    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, 0);
        this.institutionName = institutionName;
    }


    public StudentAccount() {
    }

    //---------- Getter and Setter ------------

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

}
