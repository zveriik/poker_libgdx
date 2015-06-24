package com.badlogic.poker.core;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Aleksey_Zverkov on 6/23/2015.
 */
public class Utils {

    public static Color getRGBColor(int r, int g, int b){
        return getRGBColor(r, g, b, 1.0f);
    }

    public static Color getRGBColor(int r, int g, int b, float a){
        return new Color(r/255f, g/255f, b/255f, 1.0f);
    }
}
