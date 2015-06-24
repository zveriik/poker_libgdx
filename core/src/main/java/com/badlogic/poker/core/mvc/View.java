package com.badlogic.poker.core.mvc;

import com.badlogic.poker.core.entity.Card;
import com.badlogic.poker.core.entity.Game;
import com.badlogic.poker.core.entity.Table;

import java.awt.*;

/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class View {

    final static int BOX_SIZE = 30;
    final static int ORIGIN_X = 50;
    final static int ORIGIN_Y = 50;

    Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw(final Game game) {
        drawTable(game.getTable());
//        drawCard(game.getDeck().removeFirst(), 1);
//        drawFigure(game.getFigure().getData(), game.row, game.col);
    }

    private void drawTable(Table table){
        int place = 1;
        for (Card card : table.getCardsOnDesk()){
            drawCard(card, place++);
        }
    }

    public void drawCard(Card card, int place){
        
    }

    private void drawBox(final int colorIndex, final int row, final int col) {
        graphics.fillRect(ORIGIN_X + 5 * BOX_SIZE, ORIGIN_Y + 5 * BOX_SIZE, BOX_SIZE, BOX_SIZE);
    }
}
