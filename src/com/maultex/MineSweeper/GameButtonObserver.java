/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @author Christoball
 *
 */
public class GameButtonObserver extends MouseAdapter 
{

	private MineSweeperController _ctrlMineSweeper;
	
	public GameButtonObserver(MineSweeperController mineSweeperController)
	{
		_ctrlMineSweeper = mineSweeperController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) 
	{
		_ctrlMineSweeper.newGame();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		_ctrlMineSweeper.newGame();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) 
	{
		

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) 
	{
		_ctrlMineSweeper.getView().showHappyFacePressed();
		//JOptionPane.showMessageDialog(null, "Mouse Pressed");

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		_ctrlMineSweeper.getView().showHappyFace();

	}


}
