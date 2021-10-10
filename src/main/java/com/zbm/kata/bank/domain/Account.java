package com.zbm.kata.bank.domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account() {
        balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {
        checkThatAmountIsGreaterThanZero(amount);
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        checkThatAmountIsGreaterThanZero(amount);
        if(amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance = balance.subtract(amount);
    }

    public BigDecimal getTotalBalance() {
        return this.balance;
    }

    private void checkThatAmountIsGreaterThanZero(BigDecimal amount) {
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero.");
        }
    }
}
