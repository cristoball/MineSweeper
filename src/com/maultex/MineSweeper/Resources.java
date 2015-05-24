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
	
	public static Hashtable <ImageIcon, Integer> htMineImagesToNums = new Hashtable();
	public static Hashtable <Integer, ImageIcon> htNumsToMineImages = new Hashtable();
	public static Hashtable <String, ImageIcon> htDigits = new Hashtable();
	
	static 
	{
		htMineImagesToNums.put(icon0Mines, 0 );
		htMineImagesToNums.put(icon1Mines, 1 );
		htMineImagesToNums.put(icon2Mines, 2 );
		htMineImagesToNums.put(icon3Mines, 3 );
		htMineImagesToNums.put(icon4Mines, 4 );
		htMineImagesToNums.put(icon5Mines, 5 );
		htMineImagesToNums.put(icon6Mines, 6 );
		htMineImagesToNums.put(icon7Mines, 7 );
		htMineImagesToNums.put(icon8Mines, 8 );
		
		htNumsToMineImages.put(0, icon0Mines);
		htNumsToMineImages.put(1, icon1Mines);
		htNumsToMineImages.put(2, icon2Mines);
		htNumsToMineImages.put(3, icon3Mines);
		htNumsToMineImages.put(4, icon4Mines);
		htNumsToMineImages.put(5, icon5Mines);
		htNumsToMineImages.put(6, icon6Mines);
		htNumsToMineImages.put(7, icon7Mines);
		htNumsToMineImages.put(8, icon8Mines);
	}
	
}
