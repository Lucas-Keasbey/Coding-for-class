package project2Sorting;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TextSorter {
	private WordHolder s = new WordHolder();
	File newFile;
	ArrayList<String> unsorted = new ArrayList<>();
	String[] sorted;
	
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
	
	public String[] sortSimple() {
		sorted = new String[unsorted.size()];
		for (int i=0;i<unsorted.size();i++)
			sorted[i]=unsorted.get(i);
		Arrays.sort(sorted);
		return sorted;
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
					unsorted.add(w.toLowerCase().replaceAll("\\p{Punct}", ""));
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//addWords() is used in the parseFile method to add the unsorted array into the WordHolder
	private void addWordsLinear() {
		s.addWordsLinear(unsorted);
	}
	
	public String[] sortLinear() {
		sorted = new String[unsorted.size()];
		int index = 0;
		addWordsLinear();
		List<String> uniqueWords = s.getWords();
		for (int i=0;i<uniqueWords.size();i++){
			String word = uniqueWords.get(i);
			int count = s.getWordCountLinear(word);
			for (int j=0;j<count;j++)
				sorted[index++]=word;
		}
		return sorted;
	}
	
	public String[] sortQuadratic() {
		sorted = new String[unsorted.size()];
		int index = 0;
		s.addWordsQuadratic(unsorted);
		List<String> uniqueWords = s.getWords();
		for (int i=0;i<uniqueWords.size();i++){
			String word = uniqueWords.get(i);
			int count = s.getWordCountQuadratic(word);
			for (int j=0;j<count;j++)
				sorted[index++]=word;
		}
		return sorted;
	}

	@Override
	public String toString() {
		return "TextSorter [File=" + newFile.getName() + ", unsorted=" + unsorted.size() + ", sorted="
				+ sorted.length + "]";
	}
	
	public static void main(String[] args) {
		TextSorter linear = new TextSorter("C:\\Users\\Lucas\\Desktop\\College\\Spring 2022\\CS 3410 Data Structures\\WORKSPACE\\DataStructuresGroupProject\\src\\project2Sorting\\ToBeSorted");
		long T1 = System.nanoTime(); 
		linear.sortLinear();
		long T2 = System.nanoTime(); 
		long totalTime = T2-T1;
		System.out.println("Linear Sort time:\t" + totalTime + "ms");
		TextSorter quadratic = new TextSorter("C:\\Users\\Lucas\\Desktop\\College\\Spring 2022\\CS 3410 Data Structures\\WORKSPACE\\DataStructuresGroupProject\\src\\project2Sorting\\ToBeSorted");
		T1 = System.nanoTime(); 
		quadratic.sortQuadratic();
		T2 = System.nanoTime(); 
		totalTime = T2-T1;
		System.out.println("Quadratic Sort time:\t" + totalTime + "ms");
	}
}
