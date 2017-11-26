package Matala1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class writeFile {
	
	/**
	 * Write the finished united csv file
	 * @param destination
	 * @param matrix
	 */
	public void writeFiles(String destination, ArrayList<List<String>> matrix){
		try {
			FileWriter fw = new FileWriter(destination);
			PrintWriter outs = new PrintWriter(fw);
			
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					outs.print(matrix.get(i).get(j)+", ");
				}
				outs.println();
			}
			outs.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
	}
}
