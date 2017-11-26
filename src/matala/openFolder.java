package Matala1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class openFolder {
	
	openFile openFileObject = new openFile();
	RowFunctions RowFunctionObject = new RowFunctions();

	/**
	 * Main program, open the folder which contains csv files
	 * @param location
	 * @param destination
	 * @return
	 */
	public ArrayList<List<String>> openFolders(String location, String destination) {
		ArrayList<List<String>> matrix = new ArrayList<>();
		ArrayList<List<String>> temp = new ArrayList<>();
		
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();
		for(int i = 0; i < listOfFiles.length; i++){
			String filename = listOfFiles[i].getName();
			if(filename.endsWith(".csv")){
				temp = openFileObject.openFiles(location+"/"+filename);
			}
			updateMatrix(matrix, temp);
		}		
		RowFunctionObject.extractInfo(matrix);
		return matrix;
	}
	/**
	 * Keep update our main matrix using temporary array list
	 * @param matrix
	 * @param temp
	 */
	public void updateMatrix(ArrayList<List<String>> matrix, ArrayList<List<String>> temp){
		for (int i = 0; i < temp.size(); i++) {
				matrix.add(temp.get(i));
		}
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
