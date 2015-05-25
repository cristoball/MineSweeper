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
public class MenuNewObserver implements ActionListener 
{
	Controller _controller;
	
	public MenuNewObserver(Controller ctrlr)
	{
		_controller = ctrlr;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		_controller.newGame();

	}

}
