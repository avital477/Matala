package Matala1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateFilter {
	/**
	 * Final Date Filter program for the costumer
	 * @param Result
	 */
	public void Date(ArrayList<List<String>> Result){
		Scanner flag = new Scanner(System.in);
		Scanner flag2 = new Scanner(System.in);
		System.out.println("Type the requested Date range");
		System.out.println("An examples of proper date and time: 2017-02-18 18:21:22");
		System.out.println("from ");
		String userStartDate = flag.nextLine();
		System.out.println("to ");
		String userEndDate = flag2.nextLine();
		dateFilter(Result, userStartDate, userEndDate);
		flag.close();
		flag2.close();

	}
/**
 * Remove unwanted dates
 * @param result
 * @param userStartDate
 * @param userEndDate
 */
	private void dateFilter(ArrayList<List<String>> result, String userStartDate, String userEndDate) {
		
		for (int i = 1; i < result.size(); i++) {
			if(!compareDate(userStartDate, userEndDate, result.get(i).get(0))){
				result.remove(i);
				i--;
			}
		}
	}
	/**
	 * Compare dates
	 * @param userStartDate
	 * @param userEndDate
	 * @param matrixDate
	 * @return
	 */
	private boolean compareDate(String userStartDate, String userEndDate, String matrixDate){
		Date startDate = StringToDate(userStartDate);
		Date endDate = StringToDate(userEndDate);
		Date pcDate = StringToDate(matrixDate);
		return (pcDate.before(endDate) && pcDate.after(startDate));		
	}
	/**
	 * Convert string to date
	 * @param Date
	 * @return
	 */
	private Date StringToDate(String Date){
		DateFormat tempDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"); 
		Date temp;
		try {
			temp = tempDate.parse(Date);
			return temp;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
