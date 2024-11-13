package org.ozkangunduz.example;

public class Account {
    private String name;
    private int accountAge;

    public Account(String name, int accountAge) {
        this.name = name;
        this.accountAge = accountAge;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public int getAccountAge() {
        return accountAge;
    }

    public Account setAccountAge(int accountAge) {
        this.accountAge = accountAge;
        return this;
    }
}