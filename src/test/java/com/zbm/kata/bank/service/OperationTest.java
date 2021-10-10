package com.zbm.kata.bank.service;

import com.zbm.kata.bank.domain.Operation;
import com.zbm.kata.bank.domain.OperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    void shouldReturnOperationProperties() {
        LocalDateTime now = LocalDateTime.now();
        Operation operation = new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN);
        assertThat(operation.getType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(operation.getAmount()).isEqualTo(BigDecimal.TEN);
        assertThat(operation.getCurrentBalance()).isEqualTo(BigDecimal.TEN);
        assertThat(operation.getDateTime()).isEqualTo(now);
    }
}
