package Matala1;

import java.util.ArrayList;
import java.util.List;

public class Run {

	String 	location;
	String 	destination;
	ArrayList<List<String>> matrix;


	openFolder	openFolderObject = new openFolder();
	openFile	openFileObject = new openFile();
	writeFile	writeFileObject = new writeFile();
	RowFunctions rowFunctionObject = new RowFunctions();
	Filter FilterObject = new Filter();

/**
 * The heart of the program
 * @param location
 * @param destination
 */
	public void Program(String location, String destination){
		String root = destination;
		destination = destination+"mergeCSV.csv";
		matrix = openFolderObject.openFolders(location, destination);
		rowFunctionObject.sortBySignal(matrix);
		rowFunctionObject.uniteDates(matrix);
		rowFunctionObject.headLine(matrix);
		writeFileObject.writeFiles(destination, matrix);
		FilterObject.fileChoose(destination, root);
	}
}