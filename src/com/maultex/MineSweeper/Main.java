/**
 * 
 */
package com.maultex.MineSweeper;

/**
 * @author Christoball
 *
 */
public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 8;
		int y = 8;
		int mines = 9;
		
		if ((args[0] != null) && (args[1] != null) && args[2] != null)
		{
			try
			{
				x = Integer.parseInt(args[0]);
				y = Integer.parseInt(args[1]);
				mines = Integer.parseInt(args[2]);
				
				if (mines > x * y) //do we have more mines than grid spaces?
				{
					System.out.println("Mines Greater than field size.  Please re-enter parameters.");
					System.exit(1);
				}
			}
			catch (Exception ex)
			{
				//do nothing, use default values for x and y
				System.out.println("Invalid arugments. Using default settings of x = " + x + ", y = " + y + ", mines = " + mines + ".");
				System.exit(1);
			}
		}	

		runMineSweeper(x, y, mines);
		
	}

	public static void runMineSweeper(int width, int height, int nMines)
	{
		MineSweeperController controller = new MineSweeperController(width, height, nMines);
		controller.newGame();
		
	}
	
}
