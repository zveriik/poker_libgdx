package com.badlogic.poker.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.poker.core.PokerGame;

import static com.badlogic.poker.core.Utils.getRGBColor;

public class PokerDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Poker";
		new LwjglApplication(new PokerGame(), config);
	}
}
