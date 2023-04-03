package com.example.testCode.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        Dollar product = five.time(2);
        assertEquals(10, product.getAmount());
        product = five.time(3);
        assertEquals(15, product.getAmount());

    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

}