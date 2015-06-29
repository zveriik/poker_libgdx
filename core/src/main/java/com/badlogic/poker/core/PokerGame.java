package com.badlogic.poker.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
		Group tableGroup = new Group();
		stage.addActor(tableGroup);

		Image  frame = new Image(new Texture(Gdx.files.internal("cards/frame.png")));
		frame.setPosition(30, 90);
		frame.setName("frame");
		tableGroup.addActor(frame);

		Image[] table = controller.getTable();

		for(int i=0; i<table.length; i++){
			Image img = table[i];
			img.setName(""+i);
			img.setPosition(30+90*i, 90);
			tableGroup.addActor(img);
		}


//		Image card = new Image(new Texture(Gdx.files.internal("cards/1.png")));
//		card.setName("2");
//		card.setPosition(120, 90);


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
