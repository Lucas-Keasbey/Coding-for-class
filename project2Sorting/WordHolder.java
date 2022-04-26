package project2Sorting;
import java.util.*;

public class WordHolder {
	private int max = (int)Math.pow(2, 19);		//there are roughly 200,000 words in English
	private String[] words = new String[max];	//unique words
	private int[] count = new int[max];			//number of each word added
	private int uniqueCount = 0;
	private int totalCount = 0;
	
	public WordHolder() {
		super();
		for (int i=0;i<max;i++)
			words[i]="";
	}
	
	public int getUniqueCount() {
		return uniqueCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	private int hashCode(String word) {
		int hash = 1;
		for (int i=0;i<word.length();i++)
			hash = hash*(int)word.charAt(i);
		return hash;
	}
	
	public int addWordLinear(String word) {			//currently set for linear replacement
		word.toLowerCase();
		int hash = hashCode(word);
		totalCount++;
		while (!words[hash].isEmpty()) {
			if (words[hash].equals(word)) {
				count[hash]++;
				return count[hash];
			}
			hash++;
			if (hash>=max)
				hash=0;
		}
		words[hash]=word;
		count[hash]=1;
		uniqueCount++;
		return 1;
	}
	
	public int addWordsLinear(Collection<String> words) {
		int wordsAdded=0;
		for (String w : words)
			wordsAdded += addWordLinear(w);
		return wordsAdded;
	}
	
	public int addWordQuadratic(String word) {			//quadratic replacement
		word.toLowerCase();
		int hash = hashCode(word);
		int i=0;
		totalCount++;
		while (!words[hash].isEmpty()) {
			if (words[hash].equals(word)) {
				count[hash]++;
				return count[hash];
			}
			i++;
			hash=((int)(hashCode(word) + i*.5 + .5* Math.pow(i, 2))%max);
		}
		words[hash]=word;
		count[hash]=1;
		uniqueCount++;
		return 1;
	}
	
	public int addWordsQuadratic(Collection<String> words) {
		int wordsAdded=0;
		for (String w : words)
			wordsAdded += addWordQuadratic(w);
		return wordsAdded;
	}
	
	public List<String> getWords(){
		ArrayList<String> uniqueWords = new ArrayList<>();
		for (int i=0;i<max;i++) {
			if (!words[i].isEmpty())
				uniqueWords.add(words[i]);
		}
		Collections.sort(uniqueWords);
		return uniqueWords;
	}
	
	public int getWordCountLinear(String word) {
		word.toLowerCase();
		int hash = hashCode(word);
		int start = hash;
		while (!words[hash].isEmpty()) {
			if (words[hash].equals(word)) {
				return count[hash];
			}
			hash++;
			if (hash>=max)
				hash=0;
			if (hash==start)
				break;
		}
		return 0;
	}
	
	public int getWordCountQuadratic(String word) {
		word.toLowerCase();
		int hash = hashCode(word);
		int i=0;
		while (!words[hash].isEmpty()) {
			if (words[hash].equals(word)) {
				return count[hash];
			}
			i++;
			hash=((int)(hashCode(word) + i*.5 + .5* Math.pow(i, 2))%max);
		}
		return 0;
	}
	
	public void reset() {
		for (int i=0;i<max;i++)
			words[i]="";
		count = new int[max];
		uniqueCount = 0;
		totalCount = 0;
	}
}
