package com.badlogic.poker.html;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.poker.core.PokerGame;

public class PokerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new PokerGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
