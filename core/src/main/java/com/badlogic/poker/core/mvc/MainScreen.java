package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.PokerGame;

/**
 * Created by Aleksey_Zverkov on 7/1/2015.
 */
public class MainScreen extends MyScreen {

    public MainScreen(PokerGame game) {
        super(game);
        initScreen();
        Gdx.input.setInputProcessor(new GameScreenListener(game.controller, stage));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (game.controller.checkEnoughMoney()){
            dispose();
            game.setScreen(new EndScreen(game));
        }
        game.batch.begin();
        game.font.draw(game.batch, "MONEY: " + game.controller.getMoney(), 600, 420);
        game.batch.end();
    }

    private void initScreen() {
        Image table = new Image(new Texture(Gdx.files.internal("poker-table.jpg")));
        table.setTouchable(Touchable.disabled);
        stage.addActor(table);
        Group tableGroup = new Group();
        stage.addActor(tableGroup);

        Image[] tableTable = game.controller.startNewGame();
        for (int j = 0; j < tableTable.length; j++) {
            Image img = tableTable[j];
            img.setName("" + j);
            img.setPosition(30 + 90 * j, 90);
            tableGroup.addActor(img);
        }

        System.out.println("Main Screen: Actors added");
    }

}
