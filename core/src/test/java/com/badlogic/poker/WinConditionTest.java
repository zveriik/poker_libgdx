package com.badlogic.poker;

import com.badlogic.poker.core.entity.*;
import com.badlogic.poker.core.logic.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksey_Zverkov on 5/7/2015.
 */

@RunWith(Parameterized.class)
public class WinConditionTest {

    private Logic logic = new Logic();

    private Card[] testedCombination;
    private WinCondition executeCondition;

    @Parameterized.Parameters
    public static Collection<Object[]> tests() {
        return Arrays.asList(
                new Object[][]{
                        {WinCondition.NONE, new Card[]{new Card(CardSuit.SPADES, CardValue.TWO), new Card(CardSuit.SPADES, CardValue.FOUR),
                                new Card(CardSuit.HEARTS, CardValue.ACE), new Card(CardSuit.DIAMONDS, CardValue.SIX), new Card(CardSuit.SPADES, CardValue.EIGHT)}},
                        {WinCondition.PAIR, new Card[]{new Card(CardSuit.SPADES, CardValue.TWO), new Card(CardSuit.SPADES, CardValue.FOUR),
                                new Card(CardSuit.HEARTS, CardValue.TWO), new Card(CardSuit.SPADES, CardValue.SIX), new Card(CardSuit.SPADES, CardValue.EIGHT)}},
                        {WinCondition.TWO_PAIR, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.CLUBS, CardValue.EIGHT),
                                new Card(CardSuit.SPADES, CardValue.TWO), new Card(CardSuit.HEARTS, CardValue.TWO), new Card(CardSuit.SPADES, CardValue.ACE)}},
                        {WinCondition.THREE_OF_KIND, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.CLUBS, CardValue.EIGHT),
                                new Card(CardSuit.DIAMONDS, CardValue.EIGHT), new Card(CardSuit.HEARTS, CardValue.TWO), new Card(CardSuit.SPADES, CardValue.ACE)}},
                        {WinCondition.FULL_HOUSE, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.CLUBS, CardValue.EIGHT),
                                new Card(CardSuit.SPADES, CardValue.TWO), new Card(CardSuit.HEARTS, CardValue.TWO), new Card(CardSuit.DIAMONDS, CardValue.TWO)}},
                        {WinCondition.FOUR_OF_KIND, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.CLUBS, CardValue.EIGHT),
                                new Card(CardSuit.DIAMONDS, CardValue.EIGHT), new Card(CardSuit.HEARTS, CardValue.EIGHT), new Card(CardSuit.SPADES, CardValue.ACE)}},
                        {WinCondition.FLUSH, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.SPADES, CardValue.TWO),
                                new Card(CardSuit.SPADES, CardValue.FIVE), new Card(CardSuit.SPADES, CardValue.KING), new Card(CardSuit.SPADES, CardValue.ACE)}},
                        {WinCondition.STRAIGHT, new Card[]{new Card(CardSuit.CLUBS, CardValue.EIGHT), new Card(CardSuit.SPADES, CardValue.NINE),
                                new Card(CardSuit.SPADES, CardValue.FIVE), new Card(CardSuit.SPADES, CardValue.SIX), new Card(CardSuit.SPADES, CardValue.SEVEN)}},
                        {WinCondition.STRAIGHT_FLUSH, new Card[]{new Card(CardSuit.SPADES, CardValue.EIGHT), new Card(CardSuit.SPADES, CardValue.NINE),
                                new Card(CardSuit.SPADES, CardValue.FIVE), new Card(CardSuit.SPADES, CardValue.SIX), new Card(CardSuit.SPADES, CardValue.SEVEN)}},
                        {WinCondition.ROYAL_FLUSH, new Card[]{new Card(CardSuit.SPADES, CardValue.TEN), new Card(CardSuit.SPADES, CardValue.ACE),
                                new Card(CardSuit.SPADES, CardValue.JACK), new Card(CardSuit.SPADES, CardValue.KING), new Card(CardSuit.SPADES, CardValue.QUEEN)}}
                }
        );
    }

    public WinConditionTest(WinCondition executeCondition, Card[] testedCombination) {
        this.testedCombination = testedCombination;
        this.executeCondition = executeCondition;
    }

    @Test
    public void testWinCondition() {
        logic.getGame().getTable().setCardsOnDesk(testedCombination);
        assertEquals(executeCondition, logic.checkCombination());
    }
}
