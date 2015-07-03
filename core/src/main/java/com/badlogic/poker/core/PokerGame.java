package com.badlogic.poker.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.poker.core.mvc.Controller;
import com.badlogic.poker.core.mvc.MainScreen;
import com.badlogic.poker.core.mvc.StartScreen;
import com.badlogic.poker.core.mvc.TableListener;

public class PokerGame extends Game {

	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 480;

	PokerStage stage;
	Controller controller;
	TableListener tableListener;

	public StartScreen startScreen;
	public MainScreen mainScreen;

	Sprite bg = new Sprite();

	@Override
	public void create() {
		startScreen = new StartScreen(this);
		mainScreen = new MainScreen(this);
		setScreen(startScreen);

		stage = new PokerStage();
		controller = new Controller();
		tableListener = new TableListener(controller, stage);
		Group tableGroup = new Group();
		Group background = new Group();
		stage.addActor(background);
		stage.addActor(tableGroup);

		background.addActor(new Image(new Texture(Gdx.files.internal("cards/table.png"))));

		System.out.println(tableGroup.toString());
//		Gdx.input.setInputProcessor(tableListener);
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
