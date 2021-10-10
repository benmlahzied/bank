package com.zbm.kata.bank.service;

import com.zbm.kata.bank.domain.Operation;

import java.util.List;

public interface StatementPrintingService {

    void print(List<Operation> operations);
}
