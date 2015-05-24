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
public class BestTimes implements Serializable
{
	private String _sBeginnerTime = "";
	private String _sBeginnerName = "";
	
	private String _sIntermediateTime = "";
	private String _sIntermediateName = "";
	
	private String _sExpertTime = "";
	private String _sExpertName = "";
	
	private static BestTimes _instance = null;
	
	/**
	 * 
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
				 streamIn = new FileInputStream("res/BestTimes.ser");
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
	
	/**
	 * Save best times to file
	 */
	public void saveTimes()
	{
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try
		{
		        fout = new FileOutputStream("res/BestTimes.ser", false);
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
	
	public static void main(String[] args)
	{
		BestTimes times = BestTimes.getBestTimes();
		System.out.println(times._sBeginnerName + "\n");
		System.out.println(times._sBeginnerTime + "\n");
		
		
	}
}
