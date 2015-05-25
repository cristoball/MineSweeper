/**
 * 
 */
package com.maultex.MineSweeper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Christoball
 *
 */
public class BestTimesManager
{

	private static BestTimes _instance = null;
	
	/**
	 * Reads serialized object files for the time being
	 * @return return a single instance of the Best Times in the game
	 */
	public static BestTimes getBestTimes()
	{
		if (_instance == null)
		{
			//_instance = new BestTime();
			ObjectInputStream objectinputstream = null;
			FileInputStream streamIn = null;
			 try 
			 {
				 streamIn = new FileInputStream(Resources.fileBestTimes);
				 objectinputstream = new ObjectInputStream(streamIn);
				 _instance = (BestTimes) objectinputstream.readObject();
				 objectinputstream .close();
				 streamIn.close();
			 } 
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			 }
		}
		return _instance;
	}
	
	protected static BestTimes getInstance()
	{
		if (_instance == null)
		{
			getBestTimes();
		}
		return _instance;
	}	
	
	/**
	 * Save best times to file
	 */
	public static void saveTimes()
	{
		BestTimes times = new BestTimes();
		times.setBeginnerTime("Chris", "30.105");
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try
		{
			fout = new FileOutputStream(Resources.fileBestTimes, false);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(_instance);
			oos.close();
			fout.close();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
		
	
	public static void main(String[] args)
	{
		BestTimesManager.saveTimes();
		//System.out.println(times.getBeginnerName() + "\n");
		//System.out.println(times.getBeginnerTime() + "\n");
	}
}

