package Matala1;

import java.util.ArrayList;
import java.util.List;

public class writeKml {
	writeFile writeFileObjet = new writeFile();

	public void exportKml(ArrayList<List<String>> Result, String root){
		writeFileObjet.writeFiles(root+"/KmlFile.kml", Result);
	}
}
