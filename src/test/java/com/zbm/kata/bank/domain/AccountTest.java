package com.zbm.kata.bank.domain;

import com.zbm.kata.bank.service.StatementPrintingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @InjectMocks
    private Account account;

    @Mock
    private StatementPrintingService statementPrintingService;

    @BeforeEach
    void init() {
        account = new Account(statementPrintingService);
    }

    @Test
    void shouldHaveZeroBalanceWhenAccountIsCreated() {
        assertThat(account.getTotalBalance()).isNotNull().isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("Deposit:1000|Deposit:10|withdraw:100|Balance:910")
    void shouldUpdateBalanceAfterDeposit() {
        account.deposit(BigDecimal.valueOf(1000));
        account.deposit(BigDecimal.TEN);
        account.withdraw(BigDecimal.valueOf(100));
        assertThat(account.getTotalBalance()).isNotNull().isEqualTo(BigDecimal.valueOf(910));
    }

    @Test
    void shouldRejectDepositOfNegativeAmount() {
        BigDecimal negativeAmount = BigDecimal.valueOf(-100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(negativeAmount));
    }

    @Test
    void shouldRejectDepositOfZeroAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.ZERO));
    }

    @Test
    void shouldRejectWithdrawalOfNegativeAmount() {
        BigDecimal negativeAmount = BigDecimal.valueOf(-100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(negativeAmount));
    }

    @Test
    void shouldRejectWithdrawalOfZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.ZERO));
    }

    @Test
    void shouldRejectWithdrawalInCaseOfInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.ZERO));
        account.deposit(BigDecimal.valueOf(1000));
        BigDecimal amount = BigDecimal.valueOf(1200);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(amount));
    }

    @Test
    void shouldCallStatementPrintingService() {
        account.deposit(BigDecimal.valueOf(1000));
        account.withdraw(BigDecimal.valueOf(100));
        account.printStatement();
        verify(statementPrintingService, times(1)).print(account.getOperations());
    }
}
