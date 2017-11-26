package Matala1;

import java.util.ArrayList;
import java.util.List;

public interface Row {
	ArrayList<String> firstSort(ArrayList<List<String>> temp, int i, String ID);
	void extractInfo(ArrayList<List<String>> matrix);
	void uniteDates(ArrayList<List<String>> matrix);
	boolean badRegex(ArrayList<List<String>> matrix, int i);
	ArrayList<String> extraWIFI(ArrayList<List<String>> matrix, int extraIndex);
	boolean isDateEqual(ArrayList<List<String>> matrix, int newRow, int oldRow);
	boolean greatestSignal(int signal1, int signal2);
	void swapRows(ArrayList<List<String>> matrix, int newRow, int oldRow);
	void sortBySignal(ArrayList<List<String>> matrix);
	void headLine(ArrayList<List<String>> matrix);

}
