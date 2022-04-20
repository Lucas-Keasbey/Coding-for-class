package project1CreditCard;
import java.util.*;

public class cardStorage {
	private int max = 1000000;					//max number of accounts
	private String[] names = new String[max];	//hash key source
	private int[] cards = new int[max];			//hash table value
	private String[] pw = new String[max];		//validation/security
	private int count = 0;						//number of accounts stored
	
	public cardStorage() {
		super();
		for (int i=0;i<max;i++) {				//fill names with empty strings
			names[i] = "";						//to avoid null errors
		}
	}
	
	public int numAccount() {					//get number of accounts
		return count;
	}
	
	private int hashKey(String name) {			//convert String to int based on
		long key=0;								//ASCII value of each character
		int length= name.length();				//returned int is in range [0,max)
		for (int i=0;i<length;i++) {
			key +=((int)name.charAt(i))*Math.pow(7, i)*Math.pow(13,length-i);
		}
		return Math.abs((int)key%max);
	}
	
	public void addAccount(String name, int card, String password) {
		System.out.println("Creating a new account:");
		int key= hashKey(name);					
		int loops = max;						
		while (!names[key].isEmpty()) {			
			if (names[key].equals("DELETED")) {
				break;
			}
			if (validate(name, key, password)) {
				cards[key]=card;
				return;
			}
			key++;
			if (key==max); { key=0; }
			if (loops--==0) {break;}
		}
		pw[key] = password;
		names[key]=name;
		cards[key]=card;
		count++;
		System.out.println("Account created");
	}
	
	public int getAccount(String name, String password) {
		int key = hashKey(name);
		int loops = max;
		while (!names[key].isEmpty()) {
			if (validate(name, key, password)) {
				System.out.println("Account found");
				return cards[key];
			}
			key++;
			if (key==max) { key=0;}
			if (loops--==0) {break;}
		}
		System.out.println("Account not found");
		return 0;
	}
	
	public void deleteAccount(String name, String password) {
		int key = hashKey(name);
		int loops = max;
		while (!names[key].isEmpty()) {
			if (validate(name, key, password)) {
				names[key]="DELETED";
				cards[key]=0;
				pw[key]="";
				count--;
				System.out.println("Account Deleted");
				break;
			}
			key++;
			if (key==max) { key=0;}
			if (loops--==0) {break;}
		}
	}
	
	private boolean validate(String name, int key, String password) {
		if (names[key].equals(name)) {
			if (password.equals(pw[key])){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "cardStorage [Accounts=" + count + "]\n"
				+ "[Max accounts=" + max + "]";
	}
}
