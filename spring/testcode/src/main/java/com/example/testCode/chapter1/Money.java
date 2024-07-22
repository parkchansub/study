package com.example.testCode.chapter1;

public class Money {
    protected int amount;

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}
