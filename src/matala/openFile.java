package Matala1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class openFile {

	/**
	 * Works on each csv file separately
	 * @param location
	 * @return
	 */
	public ArrayList<List<String>> openFiles(String location){
		BufferedReader br = null;
		ArrayList<List<String>> matrix = new ArrayList<>();
		int index = 0;
		try {
			String csvFile;
			br = new BufferedReader(new FileReader(location));

			// How to read file in java line by line?
			while ((csvFile = br.readLine()) != null) {
				matrix.add(index++, CSVtoArrayList(csvFile));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException Exception) {
				Exception.printStackTrace();
			}
		}
		return matrix;
	}

	/** Utility which converts CSV to ArrayList using Split Operation
	 * @param csvFile
	 * @return
	 */
	public static ArrayList<String> CSVtoArrayList(String csvFile) {
		ArrayList<String> Result = new ArrayList<String>();

		if (csvFile != null) {
			String[] splitData = csvFile.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					Result.add(splitData[i].trim());
				}
			}
		}
		return Result;
	}
	/**
	 * For debug purpose only
	 * @param matrix
	 */
	public static void printMatrix(ArrayList<List<String>> matrix){
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++) {
				System.out.print(matrix.get(i).get(j)+", ");
			}
			System.out.println();
		}
	}
}
