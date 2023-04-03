package com.example.testCode.chapter1;

import lombok.Getter;

@Getter
public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar time(int multiplier) {

        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object o) {
        Dollar dollar = (Dollar) o;
        return amount == dollar.getAmount();
    }

}
