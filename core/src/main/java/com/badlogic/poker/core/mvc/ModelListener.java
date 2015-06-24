package com.badlogic.poker.core.mvc;

import com.badlogic.poker.core.entity.Game;

/**
 * Created by Aleksey_Zverkov on 6/23/2015.
 */
public interface ModelListener {
    public void onChange(Game game);
}
