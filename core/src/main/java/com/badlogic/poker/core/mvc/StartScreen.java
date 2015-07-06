package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.PokerStage;
import com.badlogic.poker.core.entity.Table;

import static com.badlogic.poker.core.Utils.getRGBColor;

/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class StartScreen extends MyScreen {

    public StartScreen(PokerGame game) {
        super(game);
        initScreen();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        Color bgColor = getRGBColor(255, 255, 80);
//        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
//        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        Image img = new Image(new Texture(Gdx.files.internal("libgdx-logo.png")));
        img.setPosition(400-img.getWidth()/2, 240-img.getHeight()/2);
        stage.addActor(img);

        game.batch.begin();
        game.font.draw(game.batch, "Menu Screen", 100, 150);
        game.font.draw(game.batch, "Tap Here", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            dispose();
            game.setScreen(new MainScreen(game));
        }

    }

    private void initScreen(){
//        listener listener = new listener(game.controller, stage);
//        Gdx.input.setInputProcessor();
        Group tableGroup = new Group();
        Group background = new Group();
        stage.addActor(background);
        stage.addActor(tableGroup);

        System.out.println("Start Screen: Actors added");
//        background.addActor(new Image(new Texture(Gdx.files.internal("cards/table.png"))));
    }
}
