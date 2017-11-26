package Matala1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterFunctions {
	
	/**
	 * Final IDFilter program for the costumer
	 * @param Result
	 */
	public void ID(ArrayList<List<String>> Result){
		System.out.println("Type the requested phone ID");
		Scanner flag = new Scanner(System.in);
		String userID = flag.next();
		IDfilter(Result, userID);
		flag.close();
	}
	/**
	 * IDFilter
	 * Remove all the arrays without the specific ID
	 * @param Result
	 * @param ID
	 */
	private void IDfilter(ArrayList<List<String>> Result, String ID){
		if(!isIDExist(Result, ID)) System.out.println("ID not exist");
		else {
			for (int i = 1; i < Result.size(); i++) {
				if(!Result.get(i).get(1).equals(ID)){
					Result.remove(i);
					i--;
				}
			}
		}
	}
	/**
	 * IDFilter
	 * Verify if the ID is in the list
	 * @param Result
	 * @param ID
	 * @return
	 */
	private boolean isIDExist(ArrayList<List<String>> Result, String ID){
		for (int i = 1; i < Result.size(); i++) {
			if(Result.get(i).get(1).equals(ID)) return true;
		}
		return false;
	}
	/**
	 * 
	 * Final LocaitonFilter program for the costumer
	 * @param Result
	 */
	public void Location(ArrayList<List<String>> Result){
		Scanner flag = new Scanner(System.in);

		System.out.println("Type the minimum Latitude requested point");
		String minLat = flag.next();
		System.out.println("Type the maximum Latitude requested point");
		String maxLat = flag.next();

		System.out.println("Type the minimum Longitude requested point");
		String minLon = flag.next();
		System.out.println("Type the maximum Longitude requested point");
		String maxLon = flag.next();
		
		Locationfilter(Result, minLat, maxLat, minLon, maxLon);
		flag.close();
	}
	/**
	 * LocaitonFilter
	 * Remove all the arrays without the right locations points 
	 * @param Result
	 * @param minLat
	 * @param maxLat
	 * @param minLon
	 * @param maxLon
	 */
	private void Locationfilter(ArrayList<List<String>> Result, String minLat, String maxLat, String minLon, String maxLon){
		for (int i = 1; i < Result.size(); i++) {
			if(!verifyLocation(minLat, maxLat, minLon, maxLon, Result.get(i).get(3), Result.get(i).get(2))){
				Result.remove(i);
				i--;
			}
		}
	}
	/**
	 * LocaitonFilter
	 * A boolean functions, checks the range of a given point
	 * @param minLat
	 * @param maxLat
	 * @param minLon
	 * @param maxLon
	 * @param Lon
	 * @param Lat
	 * @return
	 */
	private boolean verifyLocation(String minLat, String maxLat, String minLon, String maxLon, String Lon, String Lat){
		return (Double.parseDouble(Lat) <= Double.parseDouble(maxLat) && Double.parseDouble(Lat) >= Double.parseDouble(minLat)
				&& Double.parseDouble(Lon) <= Double.parseDouble(maxLon) && Double.parseDouble(Lon) >= Double.parseDouble(minLon)); 
	}
}
