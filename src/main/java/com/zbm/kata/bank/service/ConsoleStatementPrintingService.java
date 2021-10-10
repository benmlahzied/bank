package com.zbm.kata.bank.service;

public class ConsoleStatementPrintingService  extends CommonStatementPrintingService {

    public ConsoleStatementPrintingService() {
        super(new ConsoleWriter());
    }
}
