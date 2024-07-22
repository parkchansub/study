package com.example.testCode.chapter1;

import lombok.Getter;

public class Dollar extends Money{
    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar time(int multiplier) {

        return new Dollar(amount * multiplier);
    }



}
