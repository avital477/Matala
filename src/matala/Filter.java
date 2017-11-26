package Matala1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filter {
/**
 * Filter by user definition
 */
	writeKml kmlObject = new writeKml();
	openFile openFileObject = new openFile();
	DateFilter DateFilterObject = new DateFilter();
	FilterFunctions FilterObject = new FilterFunctions();

	public void fileChoose(String csvFile, String root){
		System.out.println("Choose a filter:\nID, Date, Location");
		System.out.println("For none filter type 0");
		Scanner flag = new Scanner(System.in);
		String userChoice = flag.next();
		if(userChoice.equals("ID")) filterByID(csvFile, root);
		else if(userChoice.equals("Date")) filterByDate(csvFile, root);
		else if(userChoice.equals("Location")) filterByLocation(csvFile, root);
		else if(userChoice.equals("0")) noneFilter(csvFile, root);
		else System.out.println("Wrong Input");
		flag.close();
	}
	/**
	 * Filter by ID
	 * @param csvFile
	 */
	public void filterByID(String csvFile, String root){
		ArrayList<List<String>> Result = openFileObject.openFiles(csvFile);
		FilterObject.ID(Result); //NMF26X FOR TESTING
		kmlObject.exportKml(Result, root);
	}
	/**
	 * Filter by Date
	 * @param csvFile
	 */
	public void filterByDate(String csvFile, String root){
		ArrayList<List<String>> Result = openFileObject.openFiles(csvFile);
		DateFilterObject.Date(Result);
		kmlObject.exportKml(Result, root);
	}
	/**
	 * Filter by Location
	 * @param csvFile
	 */
	public void filterByLocation(String csvFile, String root){
		ArrayList<List<String>> Result = openFileObject.openFiles(csvFile);
		FilterObject.Location(Result); //Lon 35.1745 Lat 32.1046 FOR TESTING, ARIEL CITY
		kmlObject.exportKml(Result, root);
	}
	/**
	 * No Filter
	 * @param csvFile
	 */
	public void noneFilter(String csvFile, String root){
		ArrayList<List<String>> Result = openFileObject.openFiles(csvFile);
		kmlObject.exportKml(Result, root);

	}

}
