package com.zbm.kata.bank.domain;

import com.zbm.kata.bank.service.StatementPrintingService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.zbm.kata.bank.domain.OperationType.DEPOSIT;
import static com.zbm.kata.bank.domain.OperationType.WITHDRAW;

public class Account {

    private BigDecimal balance;
    private StatementPrintingService statementPrintingService;
    private List<Operation> operations;

    public Account(StatementPrintingService statementPrintingService) {
        balance = BigDecimal.ZERO;
        operations = new ArrayList<>();
        this.statementPrintingService = statementPrintingService;
    }

    public void deposit(BigDecimal amount) {
        checkThatAmountIsGreaterThanZero(amount);
        balance = balance.add(amount);
        operations.add(new Operation(LocalDateTime.now(), amount, DEPOSIT, balance));
    }

    public void withdraw(BigDecimal amount) {
        checkThatAmountIsGreaterThanZero(amount);
        if(amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance = balance.subtract(amount);
        operations.add(new Operation(LocalDateTime.now(), amount, WITHDRAW, balance));
    }

    public BigDecimal getTotalBalance() {
        return this.balance;
    }

    private void checkThatAmountIsGreaterThanZero(BigDecimal amount) {
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero.");
        }
    }

    public void printStatement() {
        statementPrintingService.print(operations);
    }
}
