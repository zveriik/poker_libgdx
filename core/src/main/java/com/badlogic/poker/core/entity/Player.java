package com.badlogic.poker.core.entity;

/**
 * Created by Zveriki on 10.02.2015.
 */
public class Player {

    private String name;
    private int cash;
    private int bet;

    public Player() {
    }

    public Player(int cash, int bet) {
        this.cash = cash;
        this.bet = bet;
    }

    public Player(String name, int cash, int bet) {
        this.name = name;
        this.cash = cash;
        this.bet = bet;
    }

    public Player(String name) {
        this.name = name;
        this.bet = 0;
        this.cash = 0;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Player: ").append(name).append("\n").append("cash: ").append(cash).append("\n").append("bet: ").append(bet).append("\n");
        return str.toString();
    }
}
