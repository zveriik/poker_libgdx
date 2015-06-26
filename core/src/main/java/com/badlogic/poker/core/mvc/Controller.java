package com.badlogic.poker.core.mvc;

import com.badlogic.poker.core.entity.Game;
import com.badlogic.poker.core.entity.Table;

public class Controller implements ModelListener {

	private View view;
	private Model model;

	@Override
	public void onChange(final Game game) {
		view.draw(game);
	}

	public void setView(final View view) {
		this.view = view;
	}

	public void setModel(final Model model) {
		this.model = model;
	}

	public void moveLeft() {
		model.moveLeft();
	}

	public void moveRight() {
		model.moveRight();
	}

	public void tapCard() {
		model.tapCard();
	}

	public void replaceCards() {
		model.replaceCards();
	}

//	public Table getTable(){
//		model.getTable();
//	}

}
