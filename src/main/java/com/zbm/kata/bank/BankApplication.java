package com.zbm.kata.bank;

import com.zbm.kata.bank.domain.Account;
import com.zbm.kata.bank.service.ConsoleStatementPrintingService;
import com.zbm.kata.bank.service.StatementPrintingService;

import java.math.BigDecimal;

public class BankApplication {

    public static void main(String... args) {
        StatementPrintingService statementPrintingService = new ConsoleStatementPrintingService();
        Account account = new Account(statementPrintingService);
        account.deposit(BigDecimal.valueOf(1000));
        account.deposit(BigDecimal.TEN);
        account.withdraw(BigDecimal.valueOf(100));
        account.printStatement();
    }
}

