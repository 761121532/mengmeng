package com.example.web.Entity;

public class Echart {
    int value;
    String name;

    @Override
    public String toString() {
        return "Echart{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
