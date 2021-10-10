package com.zbm.kata.bank.service;

import com.zbm.kata.bank.domain.Operation;

import java.util.List;

public class CommonStatementPrintingService implements StatementPrintingService {

    private final Writer writer;

    public CommonStatementPrintingService(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void print(List<Operation> operations) {
        writer.writeLine("Operation|Date|Amount|Balance");
        operations.forEach(operation -> writer.writeLine(operation.toString()));
    }
}
