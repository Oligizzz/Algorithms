package com.oligizzz.Rondom;

public class IntegerFrequency {
    private int number;
    private int count;

    public void setNumber(int m) {
        if (m >= 0) {
            number = m;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setCount(int m) {
        if (m >= 0) {
            count = m;
        }
    }

    public int getCount() {
        return count;
    }
}