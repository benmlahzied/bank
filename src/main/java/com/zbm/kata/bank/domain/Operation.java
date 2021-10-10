package com.zbm.kata.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Operation {

    private final OperationType type;
    private final LocalDateTime dateTime;
    private final BigDecimal amount;
    private final BigDecimal currentBalance;

    public Operation(LocalDateTime dateTime, BigDecimal amount, OperationType type, BigDecimal currentBalance) {
        this.amount = amount;
        this.type = type;
        this.currentBalance = currentBalance;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add(type.toString())
                .add(dateTime.toLocalDate().toString())
                .add(amount.toString())
                .add(currentBalance.toString())
                .toString();
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public OperationType getType() {
        return this.type;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getCurrentBalance() {
        return this.currentBalance;
    }
}
