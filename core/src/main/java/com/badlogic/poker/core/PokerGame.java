package com.badlogic.poker.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.poker.core.mvc.Controller;
import com.badlogic.poker.core.mvc.StartScreen;

public class PokerGame extends Game {

	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 480;

	public PokerStage stage;
	public Controller controller;

	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		stage = new PokerStage();
		controller = new Controller();
		font = new BitmapFont(Gdx.files.internal("myFonf.fnt"));
		batch = new SpriteBatch();

		this.setScreen(new StartScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
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
