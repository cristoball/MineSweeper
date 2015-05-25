/**
 * 
 */
package com.maultex.MineSweeper;

import java.io.Serializable;

/**
 * Stores the names and times of winners of Mine Sweeper
 * @author Christoball
 *
 */
public class BestTimes implements Serializable
{
	private String _sBeginnerTime = "";
	private String _sBeginnerName = "";
	
	private String _sIntermediateTime = "";
	private String _sIntermediateName = "";
	
	private String _sExpertTime = "";
	private String _sExpertName = "";
	

	
	public void setExpertTime(String sName, String sTime)
	{
		this._sExpertName = sName;
		this._sExpertTime = sTime;
	}
	
	public String getExpertName()
	{
		return this._sExpertName;
	}
	
	public String getExpertTime()
	{
		return this._sExpertTime;
	}		
	
	public void setIntermediateTime(String sName, String sTime)
	{
		this._sIntermediateName = sName;
		this._sIntermediateTime = sTime;
	}
	
	public String getIntermediateName()
	{
		return this._sIntermediateName;
	}
	
	public String getIntermediateTime()
	{
		return this._sIntermediateTime;
	}
	
	public void setBeginnerTime(String sName, String sTime)
	{
		this._sBeginnerName = sName;
		this._sBeginnerTime = sTime;
	}
	
	public String getBeginnerName()
	{
		return this._sBeginnerName;
	}
	
	public String getBeginnerTime()
	{
		return this._sBeginnerTime;
	}	
}
