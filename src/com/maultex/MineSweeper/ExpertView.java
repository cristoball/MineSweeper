/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

/**
 * @author Christoball
 *
 */
public class ExpertView extends View 
{
	public ExpertView(int width, int height, int nMineCount, GridSpaceObserver observer, GameButtonObserver gameBtnObserver)
	{
		super(width, height, nMineCount, observer, gameBtnObserver);
		_nFieldSize = _nWidth * _nHeight;
	}
	
	/**
	 * set out buttons on mine grid
	 */
	public void createNewGameView()
	{
		//MINE FIELD
		GridLayout layoutMineGrid = new GridLayout(this._nWidth, this._nHeight);
		pnlMineField.setLayout(layoutMineGrid);	
		
		//btnUntouched.setContentAreaFilled(false);	//need this to prevent extra button space beyond the image borders
	    setMineCount(_nMines);
	    
		for (int i = 0; i < _nFieldSize; i++)
		{
			
		    GridSpaceButton btnUntouched = new GridSpaceButton(Resources.iconUntouched);
		    btnUntouched.setSize(16, 16);
			
			
		    //frame.add(button);
			//mineButton.setSize(50,50);
			pnlMineField.add(btnUntouched);
			btnUntouched.setFocusable(false);
			
			this._gridSpaceBtns[i] = btnUntouched;
			
			btnUntouched.addMouseListener(_actionObserver);
			
		}
		pnlMineField.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(), BorderFactory.createLoweredSoftBevelBorder()));
		_gridSpaceBtns[0].requestFocus();
		this.add(pnlMineField, BorderLayout.SOUTH);
		
		this.setMinimumSize(new Dimension(810, 516));
		this.setResizable(false);
		//this.setResizable(true);
		//pack();
	}
	
	
}
