package com.badlogic.poker.html;

import com.badlogic.poker.core.Poker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class PokerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Poker();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
