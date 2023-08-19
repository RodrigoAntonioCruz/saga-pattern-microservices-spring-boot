package com.payment.application.core.domain;

import java.math.BigDecimal;

public class User {

    public User() {

    }

    public User(String id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    private String id;

    private String name;

    private BigDecimal balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void debitBalance(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

}
