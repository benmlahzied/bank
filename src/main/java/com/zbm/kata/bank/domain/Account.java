package com.zbm.kata.bank.domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account() {
        balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero.");
        }
        balance = balance.add(amount);
    }

    public BigDecimal getTotalBalance() {
        return this.balance;
    }

    public void withdraw(BigDecimal amount) {

    }
}
