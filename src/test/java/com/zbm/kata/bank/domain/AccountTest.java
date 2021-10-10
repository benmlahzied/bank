package com.zbm.kata.bank.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account;

    @BeforeEach
    void init() {
        account = new Account();
    }

    @Test
    void shouldHaveZeroBalanceWhenAccountIsCreated() {
        assertThat(account.getTotalBalance()).isNotNull().isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("Deposit:1000|Deposit:10|Balance:1010")
    void shouldUpdateBalanceAfterDeposit() {
        account.deposit(BigDecimal.valueOf(1000));
        account.deposit(BigDecimal.TEN);
        assertThat(account.getTotalBalance()).isNotNull().isEqualTo(BigDecimal.valueOf(1010));
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

}
