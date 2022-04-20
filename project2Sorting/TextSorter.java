package project2Sorting;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TextSorter {
	private WordHolder s = new WordHolder();
	File newFile;
	ArrayList<String> unsorted = new ArrayList<>();
	String[] sorted = new String[unsorted.size()];
	
	public TextSorter(String fileName) {
		super();
		this.newFile = new File(fileName);
		parseFile();
	}

	public TextSorter(File newFile) {
		super();
		this.newFile = newFile;
		parseFile();
	}
	
	public ArrayList<String> getUnsorted() {
		return unsorted;
	}

	public String[] getSorted() {
		return sorted;
	}
	
	public String[] sortWords() {
		
	}

	/*parseFile() converts the text file into a string array, then adds each word to 
	 * the unsorted ArrayList. it also uses the simplify and addWords methods to remove
	 * punctuation from the words and add them to the WordHolder hash table.
	 */
	private void parseFile(){
		Scanner inFile;
		try {
			inFile = new Scanner(newFile);
			while (inFile.hasNext()) {
				String[] line =(inFile.nextLine().split("\\s+"));
				for (String w : line)
					unsorted.add(w);
			}
			inFile.close();
			simplify();
			addWordsLinear();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//addWords() is used in the parseFile method to add the unsorted array into the WordHolder
	private void addWordsLinear() {
		s.addWordsLinear(unsorted);
	}
	
	//simplify removes all punctuation from the unsorted ArrayList
	private void simplify() {
		for (String w : unsorted)
			w = w.replaceAll("\\p{Punct}", "");
	}
}
