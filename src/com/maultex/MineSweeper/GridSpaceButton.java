/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Christoball
 *
 */
public class GridSpaceButton extends JButton //?- cannot get Swing to show correct button size 
{

	private GridSpace _gridSpace = null;
	private boolean _bUncovered = false;

	/**
	 * @param iconGridUnit
	 */
	public GridSpaceButton(Icon iconGridSpace) 
	{
		this.setIcon(iconGridSpace);
		//ImageIcon iconUntouched = new ImageIcon("res/untouched.png");
//	    this.setSize(16, 16);
//	    this.setMaximumSize(new Dimension(16, 16));
//	    this.setMinimumSize(new Dimension(16, 16));
	}

	
	/**
	 * @return the nButtonID
	 */
	public int getButtonID() 
	{
		return _gridSpace.getGridSpaceID();
	}

	/**
	 * For testing purposes
	 */
	public void showGridUnitID()
	{
		JOptionPane.showMessageDialog(this, "Grid Unit ID = " + this.getGridSpace().getGridSpaceID());
//		this.setIcon(null);
//		this.setText("T");
//		repaint();
	}

	/**
	 * Put a flag on the mine and disable the button
	 */
	public void setMarkGridAsDisarmed() 
	{
		this.getGridSpace().setIdentified(true);
		this.getGridSpace().setPossibleMine(false);
		this.setIcon(Resources.iconDisarmed);
		this.setDisabledIcon(Resources.iconDisarmed);
		this.setEnabled(false);
	}
	
	/**
	 * @return is Marked As Disarmed
	 */
	public boolean getIsIdentified()
	{
		return this.getGridSpace().getIsIdentified();
	}

	/**
	 * @return the _gridSpace
	 */
	public GridSpace getGridSpace() 
	{
		return _gridSpace;
	}

	/**
	 * @param _gridSpace the gridUnit to set
	 */
	public void setGridSpace(GridSpace gridSpace) 
	{
		this._gridSpace = gridSpace;
	}


	/**
	 * Put ? icon on mine to signify possible mine location
	 */
	protected void setMarkAsPossibleMine() 
	{
		this.getGridSpace().setIdentified(false);
		this.getGridSpace().setPossibleMine(true);
		this.setIcon(Resources.iconPossibleMine);
		this.setDisabledIcon(Resources.iconPossibleMine);
		this.setEnabled(false);		
		
	}
	
	/**
	 * @return is Marked As Possible Mine
	 */
	protected boolean getIsMarkedAsPossibleMine()
	{
		return this.getGridSpace().getIsPossibleMine();
	}


	/**
	 * Shows regular enabled button with no special icon
	 */
	public void setMarkAsUntouched() 
	{
		this.getGridSpace().setIdentified(false);
		this.getGridSpace().setPossibleMine(false);
		this.setIcon(Resources.iconUntouched);
		this.setDisabledIcon(Resources.icon0Mines);
		this.setEnabled(true);				
		
	}
	
	/**
	 * 
	 * @return if this space (button) has been clicked or uncovered 
	 */
	protected boolean getIsUncovered()
	{
		return _bUncovered;
	}
	
	protected void setUncovered(boolean bUncovered)
	{
		_bUncovered = bUncovered;
	}
}
