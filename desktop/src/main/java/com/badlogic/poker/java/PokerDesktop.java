package com.badlogic.poker.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.badlogic.poker.core.Poker;
import com.badlogic.poker.core.PokerGame;

public class PokerDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1000;
		config.height = 500;
		config.title = "Poker";
		config.initialBackgroundColor = new com.badlogic.gdx.graphics.Color(0.2f, 1.0f, 0.25f, 1f);
		new LwjglApplication(new PokerGame(), config);
	}
}
