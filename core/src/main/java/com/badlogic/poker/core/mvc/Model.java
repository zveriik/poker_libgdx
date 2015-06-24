package com.badlogic.poker.core.mvc;

import com.badlogic.poker.core.entity.Game;
import com.badlogic.poker.core.entity.Player;
import com.badlogic.poker.core.logic.Logic;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	Logic logic;

	Player player = new Player();
	
	public Model() {
		Game game = new Game();
		game.setPlayer(player);
		this.logic = new Logic(game);
	}
	
	
	List<ModelListener> modelListeners = new ArrayList<ModelListener>();
	
	public void addListener(final ModelListener listener) {
		modelListeners.add(listener);
	}
	
	public void removeListener(final ModelListener listener) {
		modelListeners.remove(listener);
	}
	
	void fireChangedEvent() {
		for (ModelListener modelListener : modelListeners) {
			modelListener.onChange(logic.getGame());
		}
	}

	public void moveLeft() {
		if (logic.moveLeft()) {
			fireChangedEvent();
		}
	}

	public void moveRight() {
		if(logic.moveRight()){
			fireChangedEvent();
		}
	}

	public void tapCard() {
		if (logic.tapCard()) {
			fireChangedEvent();
		}
	}

	public void replaceCards(){
		if (logic.replaceCards()){
			fireChangedEvent();
		}
	}
	
}
