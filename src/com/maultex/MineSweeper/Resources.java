/**
 * 
 */
package com.maultex.MineSweeper;

import java.util.Hashtable;

import javax.swing.ImageIcon;

/**
 * @author Christoball
 *
 */
public class Resources 
{
	public static final String IMG_DIRECTORY = "res/";
	public static final String IMG_TYPE = ".png";
	
	public static final String GAME_TITLE = " Mine Sweeper";
	public static final String WINNING_MESSAGE = "Congratulations! You won the game! PLEASE ENTER YOUR NAME.\n\nYour winning time (seconds) is ";
	
	
	public static final ImageIcon iconHappyFace = new ImageIcon("res/HappyFace.png");
	public static final ImageIcon iconHappyPressedFace = new ImageIcon("res/HappyPressedFace.png");
	public static final ImageIcon iconUncertainFace = new ImageIcon("res/UncertainFace.png");
	public static final ImageIcon iconYuckFace = new ImageIcon("res/YuckFace.png");
	public static final ImageIcon iconCoolFace = new ImageIcon("res/CoolFace.png");
	
	public static final ImageIcon iconUntouched = new ImageIcon("res/untouched.png");
	public static final ImageIcon icon0Mines = new ImageIcon("res/0Mines.png");
	public static final ImageIcon icon1Mines = new ImageIcon("res/1Mines.png");
	public static final ImageIcon icon2Mines = new ImageIcon("res/2Mines.png");
	public static final ImageIcon icon3Mines = new ImageIcon("res/3Mines.png");
	public static final ImageIcon icon4Mines = new ImageIcon("res/4Mines.png");
	public static final ImageIcon icon5Mines = new ImageIcon("res/5Mines.png");
	public static final ImageIcon icon6Mines = new ImageIcon("res/6Mines.png");
	public static final ImageIcon icon7Mines = new ImageIcon("res/7Mines.png");
	public static final ImageIcon icon8Mines = new ImageIcon("res/8Mines.png");

	public static final ImageIcon iconRedMine = new ImageIcon("res/RedMine.png");
	public static final ImageIcon iconBlackMine = new ImageIcon("res/BlackMine.png");
	public static final ImageIcon iconDisarmed = new ImageIcon("res/DisarmedMine.png");
	public static final ImageIcon iconPossibleMine = new ImageIcon("res/PossibleMine.png");
	
	public static final ImageIcon icon0 = new ImageIcon("res/0.png");
	public static final ImageIcon icon1 = new ImageIcon("res/1.png");
	public static final ImageIcon icon2 = new ImageIcon("res/2.png");
	public static final ImageIcon icon3 = new ImageIcon("res/3.png");
	public static final ImageIcon icon4 = new ImageIcon("res/4.png");
	public static final ImageIcon icon5 = new ImageIcon("res/5.png");
	public static final ImageIcon icon6 = new ImageIcon("res/6.png");
	public static final ImageIcon icon7 = new ImageIcon("res/7.png");
	public static final ImageIcon icon8 = new ImageIcon("res/8.png");
	public static final ImageIcon icon9 = new ImageIcon("res/9.png");
	
	public static Hashtable <String, ImageIcon> htMineProximity = new Hashtable();
	public static Hashtable <String, ImageIcon> htDigits = new Hashtable();
	
	static 
	{
		htMineProximity.put("0", icon0Mines);
		htMineProximity.put("1", icon1Mines);
		htMineProximity.put("2", icon2Mines);
		htMineProximity.put("3", icon3Mines);
		htMineProximity.put("4", icon4Mines);
		htMineProximity.put("5", icon5Mines);
		htMineProximity.put("6", icon6Mines);
		htMineProximity.put("7", icon7Mines);
		htMineProximity.put("8", icon8Mines);
		
	}
	
}
