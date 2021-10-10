package com.zbm.kata.bank.service;

import com.zbm.kata.bank.domain.Operation;
import com.zbm.kata.bank.domain.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrintingServiceTest {

    @InjectMocks
    private CommonStatementPrintingService statementPrintingService;

    @Mock
    private Writer writer;

    @Test
    void shouldPrintStatement() {
        List<Operation> operations = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        Operation deposit = new Operation(dateTime, BigDecimal.valueOf(1000), OperationType.DEPOSIT, BigDecimal.valueOf(1000));
        Operation withdrawal = new Operation(dateTime, BigDecimal.valueOf(100), OperationType.WITHDRAW, BigDecimal.valueOf(900));
        operations.add(deposit);
        operations.add(withdrawal);

        statementPrintingService.print(operations);

        verify(writer, times(1)).writeLine("Operation|Date|Amount|Balance") ;
        verify(writer, times(1)).writeLine("DEPOSIT|" + deposit.getDateTime().toLocalDate() + "|1000|1000") ;
        verify(writer, times(1)).writeLine("WITHDRAW|" + withdrawal.getDateTime().toLocalDate() + "|100|900") ;
    }

}
