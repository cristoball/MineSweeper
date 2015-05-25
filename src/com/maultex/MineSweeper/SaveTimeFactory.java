/**
 * 
 */
package com.maultex.MineSweeper;

import javax.swing.JOptionPane;

/**
 * Determines which time to be saved: Beginner, Intermediate, or Expert
 * @author Christoball
 * 
 */
public class SaveTimeFactory 
{
	public static SaveTime getTimeSaver(int nSettings)
	{
		if (Settings.PLAYER_LEVEL == Settings.BEGINNER)
		{
			return new SaveBeginnerTime();
		}
		else if (Settings.PLAYER_LEVEL == Settings.INTERMEDIATE)
		{
			return new SaveIntermediateTime();
		}
		else
		{
			return new SaveExpertTime();
		}
	}
}

/**
 * Polymorphic way of saving time in the correct settings of
 * beginner, intermediate, or expert
 * @author Christoball
 *
 */
interface SaveTime
{
	public void saveTime(String sName, String sTime);
	
}

class SaveBeginnerTime implements SaveTime
{
	public void saveTime(String sName, String sTime)
	{
		BestTimes times = BestTimesManager.getBestTimes();
		float fNewTime = Float.parseFloat(sTime);
		float fOldTime = Float.parseFloat(times.getBeginnerTime());
		if (fNewTime < fOldTime)
		{
			times.setBeginnerTime(sName, sTime);
			BestTimesManager.saveTimes();
		}
	}
}

class SaveIntermediateTime implements SaveTime
{
	public void saveTime(String sName, String sTime)
	{
		BestTimes times = BestTimesManager.getBestTimes();
		float fNewTime = Float.parseFloat(sTime);
		float fOldTime = Float.parseFloat(times.getIntermediateTime());
		if (fNewTime < fOldTime)
		{
			times.setIntermediateTime(sName, sTime);
			BestTimesManager.saveTimes();
		}
		
	}
}

class SaveExpertTime implements SaveTime
{
	public void saveTime(String sName, String sTime)
	{
		BestTimes times = BestTimesManager.getBestTimes();
		float fNewTime = Float.parseFloat(sTime);
		float fOldTime = Float.parseFloat(times.getExpertTime());
		if (fNewTime < fOldTime)
		{
			times.setExpertTime(sName, sTime);
			BestTimesManager.saveTimes();
		}
		
	}
}