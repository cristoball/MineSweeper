/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.List;

/**
 * @author Christoball
 *
 */
public class GridSpace 
{
	private boolean _bIsMine = false;
	private int _nID = -1;
	private int _nMinesNear = 0;
	private boolean _isDisarmed = false;
	private boolean _bPossibleMine = false;
	private List lstNearMinePos = new List();
	
	public List getNearMinesList()
	{
		return lstNearMinePos;
	}
	
	public void  addNearMinesPos(List lst)
	{
		lstNearMinePos = lst;
	}
	
	public boolean getIsMine()
	{
		return _bIsMine;
	}
	
	public void setIsMine(boolean bIsMine)
	{
		_bIsMine = bIsMine;
	}

	/**
	 * @return the fieldID
	 */
	public int getGridSpaceID() 
	{
		return _nID;
	}

	/**
	 * @param nGridUnitID the fieldID to set
	 */
	public void setGridSpaceID(int nGridUnitID) 
	{
		this._nID = nGridUnitID;
	}

	/**
	 * @return the isArmed
	 */
	public boolean getIsIdentified() 
	{
		return _isDisarmed;
	}

	/**
	 * @param isArmed the isArmed to set
	 */
	public void setIdentified(boolean bDisarmed) 
	{
		this._isDisarmed = bDisarmed;
	}
	
	public void setMineCountNear(int nMineCount)
	{
		_nMinesNear = nMineCount;
	}

	/**
	 * @return The number of mines surrounding this grid space
	 */
	public int getMinesInProximity() 
	{
		return _nMinesNear;
	}

	/**
	 * 
	 * @param bPossible is a Possible Mine
	 */
	public void setPossibleMine(boolean bPossible) 
	{
		_bPossibleMine = bPossible;
	}
	
	/**
	 * @return Is a possible mine location
	 */
	public boolean getIsPossibleMine()
	{
		return _bPossibleMine;
	}
}
