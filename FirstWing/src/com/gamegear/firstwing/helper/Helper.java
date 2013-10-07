package com.gamegear.firstwing.helper;

import com.badlogic.gdx.graphics.Color;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Helper {
	public static Color colorEnumToColor(ColorEnum colorEnum){
		Color color = new Color();
		switch(colorEnum){
			case blue:
				color = new Color(0f, 0.545f, 0.968f, 1f);
				break;
			case green:
				color = new Color(0.435f, 0.984f, 0.125f, 1f);
				break;
			case lightblue:
				color = new Color(0f, 0.968f, 0.917f, 1f);
				break;
			case orange:
				color = new Color(0.968f, 0.607f, 0f, 1f);
				break;
			case purple:
				color = new Color(0.380f, 0f, 0.968f, 1f);
				break;
			case red:
				color = new Color(0.984f, 0.184f, 0.125f, 1f);
				break;
			case yellow:
				color = new Color(0.968f, 0.807f, 0f, 1f);
				break;
			default:
				color = new Color(1f, 1f, 1f, 1f);
				break;
		}
		
		return color;
	}
	
	public static Color darkenColor(Color color, float value){
		color.r = color.r * (1f - value);
		color.g = color.g * (1f - value);
		color.b = color.b * (1f - value);
		return color;
	}
}
