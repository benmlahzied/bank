package com.zbm.kata.bank.service;

import com.zbm.kata.bank.domain.Operation;
import com.zbm.kata.bank.domain.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @MethodSource("createEqualsTestCases")
    void shouldEqualsReturnExpectedBoolean (Operation operation1, Operation operation2, boolean expectedResult) {
        assertThat(operation1.equals(operation2)).isEqualTo(expectedResult);
    }

    @Test
    void shouldEqualsBeSymmetric() {
        LocalDateTime now = LocalDateTime.now();
        Operation operation1 = new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN);
        Operation operation2 = new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN);
        assertThat(operation1.equals(operation2)).isTrue();
        assertThat(operation2.equals(operation1)).isTrue();
        assertThat(operation1).hasSameHashCodeAs(operation2.hashCode());
    }

    @Test
    void shouldReturnOperationProperties() {
        LocalDateTime now = LocalDateTime.now();
        Operation operation = new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN);
        assertThat(operation.getType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(operation.getAmount()).isEqualTo(BigDecimal.TEN);
        assertThat(operation.getCurrentBalance()).isEqualTo(BigDecimal.TEN);
        assertThat(operation.getDateTime()).isEqualTo(now);
    }

    private static Stream<Arguments> createEqualsTestCases() {
        LocalDateTime now = LocalDateTime.now();
        return Stream.of(
                Arguments.of(new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN),
                        new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN), true),
                Arguments.of(new Operation(now.plusHours(1), BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN),
                        new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN), false),
                Arguments.of(new Operation(now, BigDecimal.ZERO, OperationType.DEPOSIT, BigDecimal.TEN),
                        new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN), false),
                Arguments.of(new Operation(now, BigDecimal.TEN, OperationType.WITHDRAW, BigDecimal.TEN),
                        new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN), false),
                Arguments.of(new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.ZERO),
                        new Operation(now, BigDecimal.TEN, OperationType.DEPOSIT, BigDecimal.TEN), false)
        );
    }
}
