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
public class MenuExpertObserver implements ActionListener 
{
	private Controller _controller;

	public MenuExpertObserver(Controller cntrl)
	{
		_controller = cntrl;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Settings.PLAYER_LEVEL = Settings.EXPERT;
		_controller.newGame();

	}

}

