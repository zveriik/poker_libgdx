package com.badlogic.poker.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.poker.core.mvc.CardBox;
import com.badlogic.poker.core.mvc.Controller;
import com.badlogic.poker.core.mvc.TableListener;

public class PokerGame extends Game {

	Stage stage;
	Controller controller;
	TableListener tableListener;

	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());
		controller = new Controller();
		tableListener = new TableListener(controller, stage);
		Group group = new Group();
		stage.addActor(group);

//		CardBox[] sprites = new CardBox[5];

		Image  frame = new Image(new Texture(Gdx.files.internal("cards/frame.png")));
		frame.setPosition(30, 90);
		frame.setName("frame");
		group.addActor(frame);


//		for (int i=0; i<5; i++) {
////			frames[i] = frame;
////			frames[i].setPosition(10+i*90, 50);
////			group.addActor(frames[i]);
//			sprites[i] = new CardBox(30+i*90, 90, new Texture(Gdx.files.internal("cards/frame.png")));
//			group.addActor(sprites[i]);
//
//		}

		Gdx.input.setInputProcessor(tableListener);

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}


}
