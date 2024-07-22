package com.example.testCode.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.time(2));
        assertEquals(new Dollar(15), five.time(3));

    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Dollar(5).equals(new Franc(5)));
    }

}