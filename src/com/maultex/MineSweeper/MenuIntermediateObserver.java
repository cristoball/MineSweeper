/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Christoball
 *
 */
public class MenuIntermediateObserver implements ActionListener 
{

	private Controller _controller;
	
	public MenuIntermediateObserver(Controller cntrl)
	{
		_controller = cntrl;	
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Settings.PLAYER_LEVEL = Settings.INTERMEDIATE;
		_controller.newGame();
	}

}

