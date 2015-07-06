package com.badlogic.poker.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.mvc.Controller;
import com.badlogic.poker.core.mvc.MainScreen;
import com.badlogic.poker.core.mvc.StartScreen;
import com.badlogic.poker.core.mvc.GameScreenListener;

public class PokerGame extends Game {

	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 480;

	public PokerStage stage;
	public Controller controller;

	public Texture texture;
	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		stage = new PokerStage();
		controller = new Controller();
		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
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
