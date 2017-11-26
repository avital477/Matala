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

	public void Program(String location, String destination){
		destination = destination+"final.csv";
		matrix = openFolderObject.openFolders(location, destination);
		rowFunctionObject.sortBySignal(matrix);
		rowFunctionObject.uniteDates(matrix);
		rowFunctionObject.headLine(matrix);
		writeFileObject.writeFiles(destination, matrix);
	}
}