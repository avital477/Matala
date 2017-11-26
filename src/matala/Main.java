package Matala1;

public class Main {
	/**
	 * Matala 1, OOP Course, Ariel University
	 * Made by: @author חני בקבני, איתי בן משה, אביטל ישראל
	 * 
	 * Credits for http://crunchify.com/ 
	 */
	
	public static void main(String[] args) {
		/**
		 * Set the location of the folder where the csv files are
		 * Set the destination folder, that you would like the export csv file will be
		 */
		
		String location = "C:/OOP/AMatala0";
		String destination = "C:/OOP/AMatala0/OutPut/";
		
		Run function = new Run();
		function.Program(location, destination);
		
	}

}
