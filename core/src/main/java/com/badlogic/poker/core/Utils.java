package com.badlogic.poker.core;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Aleksey_Zverkov on 6/23/2015.
 */
public class Utils {


//    public static final int CARD_WIDTH = 72;
//    public static final int CARD_HEIGHT = 96;
    public static final int X_STEP = 150;
    public static final int HOLDS_UP = 30;
    public static final int INIT_X = 25;
    public static final int INIT_Y = 140;
//    public static final int PLACE_WIDTH = CARD_WIDTH*1.1;
//    public static final int PLACE_HEGHT = 90;

    public static Color getRGBColor(int r, int g, int b){
        return getRGBColor(r, g, b, 1.0f);
    }

    public static Color getRGBColor(int r, int g, int b, float a){
        return new Color(r/255f, g/255f, b/255f, 1.0f);
    }
}
