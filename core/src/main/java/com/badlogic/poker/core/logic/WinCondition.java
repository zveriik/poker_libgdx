package com.badlogic.poker.core.logic;

/**
 * Created by Zveriki on 09.02.2015.
 */
public enum WinCondition {
    NONE(-1), PAIR(2), TWO_PAIR(3), THREE_OF_KIND(5), STRAIGHT(15), FLUSH(25), FULL_HOUSE(50), FOUR_OF_KIND(200), STRAIGHT_FLUSH(500), ROYAL_FLUSH(1000);

    private int cost;

    WinCondition(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
