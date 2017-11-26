package Matala1;

import java.util.ArrayList;
import java.util.List;

public class RowFunctions implements Row {

	/**
	 * Make a single list with all the relevant details
	 */
	@Override
	public ArrayList<String> firstSort(ArrayList<List<String>> temp, int i, String ID) {
		ArrayList<String> Result = new ArrayList<>();
		Result.add(temp.get(i).get(3));
		Result.add(ID);
		Result.add(temp.get(i).get(6));
		Result.add(temp.get(i).get(7));
		Result.add(temp.get(i).get(8));
		Result.add("1");//WIFI COUNT
		Result.add(temp.get(i).get(1));
		Result.add(temp.get(i).get(0));
		Result.add(temp.get(i).get(4));
		Result.add(temp.get(i).get(5));
		return Result;		
	}
	/**
	 * Keep the relevant details in the list
	 */
	@Override
	public void extractInfo(ArrayList<List<String>> matrix) {
		String ID = new String();
		for (int i = 0; i < matrix.size(); i++) {
			if(matrix.get(i).contains("WigleWifi-1.4")){
				ID = matrix.get(i).get(5).substring(8);
				matrix.remove(i);
				i--;
			}
			else if(!matrix.get(i).contains("AuthMode")){
				ArrayList<String> Result = firstSort(matrix, i, ID);
				matrix.remove(i);
				matrix.add(i, Result);
			}
			else{
				matrix.remove(i);
				i--;
			}
		}
	}
	/**
	 * Checks whether the given date is in the list or not
	 */
	@Override
	public boolean isDateEqual(ArrayList<List<String>> matrix, int newRow, int oldRow) {
		return (matrix.get(oldRow).get(0).equals(matrix.get(newRow).get(0)));
	}
	/**
	 * Checks whether signal2 is greater than signal1 or not 
	 */
	@Override
	public boolean greatestSignal(int signal1, int signal2) {
		return (signal2 >= signal1);
	}
	/**
	 * Replaces 2 given row in the list
	 */
	@Override
	public void swapRows(ArrayList<List<String>> matrix, int newRow, int oldRow) {
		String[] temp = new String[matrix.get(oldRow).size()];
		for (int i = 0; i < matrix.get(oldRow).size(); i++) {
			temp[i] = matrix.get(oldRow).get(i);
		}

		for (int i = 0; i < matrix.get(newRow).size(); i++) {
			matrix.get(oldRow).set(i, matrix.get(newRow).get(i));
		}

		for (int i = 0; i < temp.length; i++) {
			matrix.get(newRow).set(i, temp[i]);
		}
	}
	/**
	 * Sort the list by highest signals and dates
	 */
	@Override
	public void sortBySignal(ArrayList<List<String>> matrix) {
		for (int i = 0; i < matrix.size(); i++) {
			boolean flag = false;
			if(!badRegex(matrix, i)) flag = true; 
			else matrix.remove(i);
			for (int j = 0; j != i && j < matrix.size() && flag; j++) {
				if(!badRegex(matrix, j)){
					if(isDateEqual(matrix, j, i)){
						int signal1 = Integer.parseInt(matrix.get(j).get(9));
						int signal2 = Integer.parseInt(matrix.get(i).get(9));
						if(greatestSignal(signal1, signal2)) swapRows(matrix, j, i);
					}
				}
				else matrix.remove(j);
			}
		}
	}
	/**
	 * Look for similar dates, and unite their details
	 */
	@Override
	public void uniteDates(ArrayList<List<String>> matrix) {
		int count = 1;
		for (int i = 0; i < matrix.size() - 1; i++) {
			if(matrix.get(i).get(0).equals(matrix.get(i+1).get(0))){
				if(count < 10){
					matrix.get(i).set(5, ++count+"");
					ArrayList<String> extraWIFI = extraWIFI(matrix, i+1);
					matrix.get(i).addAll(matrix.get(i).size(), extraWIFI);
					matrix.remove(i+1);
					i--;
				}
				else matrix.remove(i+1);
			}
			else count = 1;
		}
	}
	/**
	 * Creates a list with the EXTRA wifi details to add to a row list
	 */
	@Override
	public ArrayList<String> extraWIFI(ArrayList<List<String>> matrix, int extraIndex){
		ArrayList<String> extraWIFI = new ArrayList<>();
		extraWIFI.add(matrix.get(extraIndex).get(6));
		extraWIFI.add(matrix.get(extraIndex).get(7));
		extraWIFI.add(matrix.get(extraIndex).get(8));
		extraWIFI.add(matrix.get(extraIndex).get(9));
		return extraWIFI;
	}
	/**
	 * Contain all the 'bad' characters we might see
	 */
	@Override
	public boolean badRegex(ArrayList<List<String>> matrix, int i) {
		return (matrix.get(i).contains(null) || matrix.get(i).contains("01/01/1970  02:00:00") || matrix.get(i).contains("?"));
	}
	/**
	 * Added titles to the csv file
	 */
	@Override
	public void headLine(ArrayList<List<String>> matrix) {
		ArrayList<String> temp = new ArrayList<>();
		temp.add("Time");
		temp.add("ID");
		temp.add("Lat");
		temp.add("Lon");
		temp.add("Alt");
		temp.add("#WiFi networks");
		for (int i = 1; i < 11; i++) {
			temp.add("SSID"+i);
			temp.add("MAC"+i);
			temp.add("Frequncy"+i);
			temp.add("Signal"+i);
		}
		matrix.add(0, temp);
	}
}
