package com.zbm.kata.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return type == operation.type && dateTime.equals(operation.dateTime) && amount.equals(operation.amount) && currentBalance.equals(operation.currentBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, dateTime, amount, currentBalance);
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
