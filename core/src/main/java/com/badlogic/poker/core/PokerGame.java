package com.badlogic.poker.core;

import com.badlogic.gdx.Game;

public class PokerGame extends Game {

	@Override
	public void create() {
		setScreen(new PokerScreen());
	}
}
