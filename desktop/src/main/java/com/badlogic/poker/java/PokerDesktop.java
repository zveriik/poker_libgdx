package com.badlogic.poker.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.poker.core.Poker;
import com.badlogic.poker.core.PokerGame;

import static com.badlogic.poker.core.Utils.getRGBColor;

public class PokerDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Color bgColor = getRGBColor(50, 255, 80);
		config.width = 500;
		config.height = 300;
		config.title = "Poker";
		config.initialBackgroundColor = new com.badlogic.gdx.graphics.Color(bgColor.r, bgColor.g, bgColor.b, 1f);
		new LwjglApplication(new PokerGame(), config);
	}
}
