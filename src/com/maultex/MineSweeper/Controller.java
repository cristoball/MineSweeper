/**
 * 
 */
package com.maultex.MineSweeper;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * @author Christoball
 *
 */
public class Controller implements Runnable
{

	private int _nMines = 9;
	
	private int _nWidth = 8;
	private int _nHeight = 8;
	private int _nFieldSize = _nWidth * _nHeight;
	
	private GridSpace[] _gridSpaces = null;
	private GridSpaceButton[] _gridSpaceBtns = null;
	
	//private int _nTime = 0;	
	
	private GridSpaceObserver _actionObserver = null;
	private GameButtonObserver _gameObserver = null;
	private View _view;	
	
	private boolean _bUserStarted = false;
	
	/**
	 * @param width
	 * @param height
	 * @param _nMines
	 */
	public Controller(int width, int height, int mines) 
	{
		_nMines = mines;
		_nWidth = width;
		_nHeight = height;
		_nFieldSize = _nWidth*_nHeight;
		Settings.PLAYER_LEVEL = Settings.BEGINNER;
	}

	/**
	 * construct a view with the game board, buttons, controls, menu, etc.
	 */
	public void run()
	{

		_actionObserver = new GridSpaceObserver(this, _view);  //glue for MVC
		_gameObserver = new GameButtonObserver(this);
		setView();

    	assignMines();
    	
        _actionObserver.setView(_view);
        _actionObserver.setController(this);
        getView().setVisible(true);

	}
	
	/**
	 * @param gameView the gameView to set
	 */
	public void setView() 
	{
		if (Settings.PLAYER_LEVEL == Settings.BEGINNER)
		{
			_nWidth = 8;
			_nHeight = 8;
			_nFieldSize = _nWidth*_nHeight;
			_nMines = 9;
			_view = new View(_nWidth, _nHeight, _nMines, _actionObserver, _gameObserver);
			_view.addBeginnerActionListener(this);
			_view.addIntermediateActionListener(this);
			_view.addExpertActionListener(this);
		}
		
		if (Settings.PLAYER_LEVEL == Settings.INTERMEDIATE)
		{
			_nWidth = 16;
			_nHeight = 16;
			_nFieldSize = _nWidth*_nHeight;
			_nMines = 40;
			_view = new IntermediateView(_nWidth, _nHeight, _nMines, _actionObserver, _gameObserver);
			_view.addBeginnerActionListener(this);
			_view.addIntermediateActionListener(this);
			_view.addExpertActionListener(this);			
		}
		if (Settings.PLAYER_LEVEL == Settings.EXPERT)
		{
			_nWidth = 16;
			_nHeight = 30;
			_nFieldSize = _nWidth*_nHeight;
			_nMines = 99;
			_view = new ExpertView(_nWidth, _nHeight, _nMines, _actionObserver, _gameObserver);
			_view.addBeginnerActionListener(this);
			_view.addIntermediateActionListener(this);
			_view.addExpertActionListener(this);			
		}		
	}	
	
	
	/**
	 * Start a new swing window thread
	 */
	public void newGame()
	{
		//_nFieldSize = _nWidth*_nHeight;
		if (this._view != null)
        {
        	_view.setVisible(false);
        	_view = null;
        }
		SwingUtilities.invokeLater(new Thread(this));
		//run();
	}
	
	
	/**
	 * Fill grid with mines and possible mines
	 * @param nMines2
	 */
	private void assignMines() 
	{
		_gridSpaces = new GridSpace[_nFieldSize];
		
		
		for (int i = 0; i < _nFieldSize; i++)
		{
			_gridSpaces[i] = new GridSpace(); //set all Spaces in the grid as empty of mines
			_gridSpaces[i].setGridSpaceID(i); //assign an ID to all grid Spaces
			
		}
		
		for (int i = 0; i < _nMines; i++)	//set randomly the grid Spaces that have mines
		{
			boolean bSetMine = false;
			while (bSetMine == false) //continue to generate random numbers in our range of mines until all mines are deployed in separate minefields on the grid
			{
				Random randNum = new Random();
				int nMineLoc = randNum.nextInt(_nFieldSize);
				if (_gridSpaces[nMineLoc].getIsMine() == false)
				{
					_gridSpaces[nMineLoc].setIsMine(true);
					bSetMine = true;
				}
			}	
		}
		
		
		//paste the each mine-field to each mine-button
		_gridSpaceBtns = getView().getGridSpaceBtns();
		for (int i = 0; i < _gridSpaces.length; i++)
		{
			_gridSpaceBtns[i].setGridSpace(_gridSpaces[i]);
		}
		
		setNearMineCount();
	}
	
	/**
	 * @return the gameView
	 */
	public View getView() 
	{
		return _view;
	}


	/**
	 * Game Over occurs when the player has clicked (with Button 1) on a space in 
	 * the grid that contains a mine that has not yet been identified
	 */
	protected boolean isGameOver() 
	{
		boolean bGameOver = false;
		
		return bGameOver;
	}	

	
	/**
	 * 
	 */
	protected void gameOver()
	{
		
	}
	
	/**
	 * Checks each space (game board) to see if all mines are identified correctly
	 * and if other spaces are uncovered
	 */
	protected boolean isGameWon() //game is won when all mines have been marked as disarmed and all other spaces are uncovered
	{
		
		for (int i = 0; i < _nFieldSize; i++)
		{
			//each mine should be identified/disarmed to win
			if(_gridSpaceBtns[i].getGridSpace().getIsMine() == true)
			{
				if (_gridSpaceBtns[i].getIsIdentified() == false)
				{
					return false;
				}
			}
			//all other buttons should be uncovered to win
			else if (_gridSpaceBtns[i].getIsUncovered() == false)
			{
				return false;
			}
			
		}
		return true;
	}	

	/**
	 * 
	 * @return true if player has won the game
	 */
	protected boolean checkGameIsWon()
	{
		if (isGameWon())
		{
			doGameIsWon();
			return true;
		}
		return false;
		
	}
	
	/**
	 * Freezes View, display winning time
	 * 
	 */
	protected void doGameIsWon()
	{
		_view.showCoolFace();
//		for (int i = 0; i < _gridSpaceBtns.length; i++)
//		{
//			_gridSpaceBtns[i].setEnabled(false);
//		}
		_view.stopTimer();
		_view.showWinningTime(_view.getFinishTime());
	}
	
	
	/**
	 * 
	 * @param nPos GridSpace position
	 */
	protected void uncoverSpace(int nPos)
	{
		if (_gridSpaceBtns[nPos].getIsUncovered() == true)  //exit if already uncovered
		{
			return;
		}

		if (_gridSpaceBtns[nPos].getGridSpace().getIsMine() == true) //exit if this space is a mine 
		{
			return;
		}
		int nNearMines = _gridSpaces[nPos].getMinesInProximity();
		_gridSpaceBtns[nPos].setIcon(Resources.htNumsToMineImages.get(nNearMines));
		_gridSpaceBtns[nPos].setUncovered(true);
		getView().repaint();
		if (nNearMines > 0)
		{
			return;	//if we run into spaces that are adjacent to mines, we don't uncover them
		}
		else
		{
			uncoverNearGridSpaces(nPos); //otherwise we continue uncovering spaces
		}
		
	}
	
	/**
	 * 
	 * @param nGridSpacePos
	 * @return true if the number of adjacent identified mines is
	 * equal to the number on the uncovered grid space 
	 */
	protected boolean checkAdjacentMinesIdentified(int nGridSpacePos)
	{
		int i = nGridSpacePos;
		int nMineCount = _gridSpaceBtns[i].getGridSpace().getMinesInProximity();
		ImageIcon iconNearMines = (ImageIcon)_gridSpaceBtns[i].getIcon();
		String sIconFile = iconNearMines.getDescription();
		String sIconTestFile = Resources.htNumsToMineImages.get(nMineCount).getDescription();
		if (sIconFile.equals(sIconTestFile))
		{
			uncoverNearGridSpaces(i);
			return true;
		}
				
		return false;
	}
	
	/**
	 * Recursively looks at surrounding grid Spaces and uncovers them, each with the correct near mine count
	 * then evaluating that uncovered space and its surrounding spaces
	 * @param btnGridSpace
	 */
	protected void uncoverNearGridSpaces(int nGridSpacePos) 
	{

		int i = nGridSpacePos;	//convenience of typing less

		int nMineCount = _gridSpaceBtns[i].getGridSpace().getMinesInProximity();
		
		int nRightEdge = _nWidth - 1;
		int nLeftEdge = _nWidth;
		//int nFirstRowEnd = _nWidth - 1;
		//int nLastRowStart = _nFieldSize - _nWidth;
		
		//count E (east) mine
		int nEpos = i + 1;
		if (nEpos < _nFieldSize && (nEpos % nLeftEdge != 0))
		{
			uncoverSpace(nEpos);
		}
		
		//count NE mine
		int nNEpos = i - (_nWidth - 1);
		if (nNEpos >= 0 && (nNEpos % nLeftEdge != 0))
		{
			uncoverSpace(nNEpos);
		}
		
		//count SE mine
		int nSEpos = i + (_nWidth + 1);
		if (nSEpos < _nFieldSize && (nSEpos % nLeftEdge != 0))
		{	
			uncoverSpace(nSEpos);
		}
		
		//count W (west) mine
		int nWpos = i - 1;
		if (nWpos >= 0  && (nWpos % _nWidth != (nRightEdge)))
		{
			uncoverSpace(nWpos);
		}			
		
		//count NW mine
		int nNWpos = i - (_nWidth + 1);
		if (nNWpos >= 0 && (nNWpos % _nWidth != (nRightEdge))) //checking right edge
		{
			uncoverSpace(nNWpos);
		}

		//count SW mine
		int nSWpos = i + (_nWidth - 1);
		if (nSWpos < _nFieldSize - 1 && (nSWpos % _nWidth != (nRightEdge)))
		{
			uncoverSpace(nSWpos);
			
		}
		
		//count N mine
		int nNpos = i - _nWidth;
		if (nNpos >= 0)
		{
			uncoverSpace(nNpos);

		}			
		
		//count S mine
		int nSpos = i + _nWidth;
		if (nSpos < _nFieldSize)
		{
			uncoverSpace(nSpos);
		
		}		
	}	
	
	/**
	 * @return Number of mines next to this grid space
	 */
	protected int setNearMineCount() 
	{
		
		int nMineCount = 0;
		
		int nRightEdge = _nWidth - 1;
		int nLeftEdge = _nWidth;
		int nFirstRowEnd = _nWidth - 1;
		int nLastRowStart = _nFieldSize - _nWidth;
		
		//count each adjacent mine
		for (int i = 0; i < _nFieldSize; i++)
		{
			nMineCount = 0; //reset mine count
			
			//count E (east) mine
			int nEpos = i + 1;
			if (nEpos < _nFieldSize && (nEpos % nLeftEdge != 0))
			{
				if (_gridSpaces[nEpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}
			
			//count NE mine
			int nNEpos = i - (_nWidth - 1);
			if (nNEpos >= 0 && (nNEpos % nLeftEdge != 0))
			{
				if (_gridSpaces[nNEpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}
			
			//count SE mine
			int nSEpos = i + (_nWidth + 1);
			if (nSEpos < _nFieldSize && (nSEpos % nLeftEdge != 0))
			{
				if (_gridSpaces[nSEpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}
			
			//count W (west) mine
			int nWpos = i - 1;
			if (nWpos >= 0  && (nWpos % _nWidth != (nRightEdge)))
			{
				if (_gridSpaces[nWpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}			
			
			//count NW mine
			int nNWpos = i - (_nWidth + 1);
			if (nNWpos >= 0 && (nNWpos % _nWidth != (nRightEdge))) //checking right edge
			if (_gridSpaces[nNWpos].getIsMine() == true)
			{
				nMineCount++;
			}

			//count SW mine
			int nSWpos = i + (_nWidth - 1);
			if (nSWpos < _nFieldSize - 1 && (nSWpos % _nWidth != (nRightEdge)))
			{
				if (_gridSpaces[nSWpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}
			
			//count N mine
			int nNpos = i - _nWidth;
			if (nNpos >= 0)
			{
				if (_gridSpaces[nNpos].getIsMine() == true)
				{
					nMineCount++;
				}
			}			
			
			//count S mine
			int nSpos = i + _nWidth;
			if (nSpos < _nFieldSize)
			{
				if (_gridSpaces[nSpos].getIsMine() == true)
				{
					nMineCount++;
				}			
			}
			_gridSpaces[i].setMinesInProximity(nMineCount);
		}
		
		return nMineCount;
	}	
	
}
