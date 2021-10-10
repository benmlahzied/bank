package com.zbm.kata.bank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleWriterTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldWriteToConsole() {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeLine("test");
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("test");
    }
}
