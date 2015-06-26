package com.badlogic.poker.core.entity;

/**
 * Created by Zveriki on 09.02.2015.
 */
public enum CardValue {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK("jack"), QUEEN("queen"), KING("king"), ACE("ace");

    private String name;

    CardValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}