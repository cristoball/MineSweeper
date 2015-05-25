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
				 
				 try
				 {
					 _instance = (BestTimes) objectinputstream.readObject();
				 }
				 catch (Exception ex)
				 {
					 ex.printStackTrace();
				 }
				 objectinputstream .close();
				 streamIn.close();
			 } 
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			 }
			 if (_instance == null)
			 {
				 _instance = new BestTimes();
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
		BestTimes bestTimes = BestTimesManager.getInstance();
		bestTimes.setBeginnerTime("Chris", "30.105");
		bestTimes.setIntermediateTime("Chris", "66.143");
		bestTimes.setExpertTime("Chris", "233.347");
		
		BestTimesManager.saveTimes();
		BestTimesManager.getBestTimes();
		
		System.out.println(bestTimes.getBeginnerName() + "\n");
		System.out.println(bestTimes.getBeginnerTime() + "\n");
		System.out.println(bestTimes.getIntermediateName() + "\n");
		System.out.println(bestTimes.getIntermediateTime() + "\n");
		System.out.println(bestTimes.getExpertName() + "\n");
		System.out.println(bestTimes.getExpertTime() + "\n");
	}
}

