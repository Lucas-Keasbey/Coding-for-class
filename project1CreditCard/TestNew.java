package project1;


public class Test {

	public static void main (String[] args) {
		TestAddAccount();
		TestMultipleAddAccount();
		TestAddMultipleAccountsWithSameUser();
		TestGetAccountValid();	
		TestGetAccountInValid();
		TestMultipleGetAccountsValid();
		TestMultipleGetAccountsInValid();
		TestGetAcountOneUserMultipleAccounts();
		TestDeleteAccount();
		TestDeleteMultipleAccounts();
	}
	
	//create an account
	public static void TestAddAccount() {
		System.out.println("==>TestAddAccount()");
		CardStorage s = new CardStorage();
		System.out.println(s);
		String name = "James Thomas";
		int card =  123456;
		String password = "thomas";
		s.addAccount(name, card, password);
		System.out.println("Number of accounts added: " + s.numAccount());
	}

	//create multiple accounts at the same time
	public static void TestMultipleAddAccount() {
		System.out.println("/n==>TestMultipleAddAccount()");
		CardStorage s = new CardStorage();
		String name1 = "James Thomas";
		int card1 =  123456;
		String password = "thomas";
		String name2 = "Charles Darwin";
		int card2 = 257859;
		String password2 = "tommy";
		s.addAccount(name1, card1, password);
		s.addAccount(name2, card2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
	}
	
	//create two account for a user
	public static void TestAddMultipleAccountsWithSameUser() {
		System.out.println("==>TestAddMultipleAccountsWithSameUser()");
		CardStorage s = new CardStorage();
		String name = "James Thomas";
		int card =  123456;
		int card2 = 298124;
		String password = "thomas";
		s.addAccount(name, card, password);
		s.addAccount(name, card2, password);
		System.out.println("Number of Accounts: " +s.numAccount());

	}
	
	//create an account and get the account using the right password
	public static void TestGetAccountValid() {
		System.out.println("==>TestGetAccountValid()");
		CardStorage s = new CardStorage();
		String name = "James Thomas";
		int card =  123456;
		String password = "thomas";
		s.addAccount(name, card, password);
		System.out.println("Account number: " + s.getAccount(name, password));
	}
	
	
	//created an account and get the account using the wrong password
	public static void TestGetAccountInValid() {
		System.out.println("==>TestGetAccountValid()");
		CardStorage s = new CardStorage();
		String name = "James Thomas";
		int card =  123456;
		String password = "thomas";
		String password2 = "Jerry";
		s.addAccount(name, card, password);
		System.out.println("Account number: " + s.getAccount(name, password2));
	}
	
	//create two accounts and accounts are returned
	public static void TestMultipleGetAccountsValid() {
		System.out.println("/n==>TestMultipleGetAccountsValid()");
		CardStorage s = new CardStorage();
		String name1 = "James Thomas";
		int card1 =  123456;
		String password = "thomas";
		String name2 = "Charles Darwin";
		int card2 = 257859;
		String password2 = "tommy";
		s.addAccount(name1, card1, password);
		System.out.println("Account number: "  + s.getAccount(name1, password));
		s.addAccount(name2, card2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
		System.out.println("Account number: "  + s.getAccount(name2, password2));
	}
	
	//multiple accounts added. Wrong password to get the accounts, and no accounts gotten
	public static void TestMultipleGetAccountsInValid() {
		System.out.println("/n==>TestMultipleGetAccountsInValid()");
		CardStorage s = new CardStorage();
		String name1 = "James Thomas";
		int card1 =  123456;
		String password = "thomas";
		String name2 = "Charles Darwin";
		int card2 = 257859;
		String password2 = "tommy";
		s.addAccount(name1, card1, password);
		System.out.println("Account number: "  + s.getAccount(name1, password2));
		s.addAccount(name2, card2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
		System.out.println("Account number: "  + s.getAccount(name2, password));
	}
	
	//get accounts of the same user
	public static void TestGetAcountOneUserMultipleAccounts() {
		System.out.println("==>TestDeleteAccount()");
		CardStorage s = new CardStorage();
		String name = "James Thomas";
		int card =  123456;
		int card2 = 298124;
		String password = "thomas";
		s.addAccount(name, card, password);
		System.out.println("First Account: " + s.getAccount(name, password));
		s.addAccount(name, card2, password);
		System.out.println("First Account: " + s.getAccount(name, password));
	}
	//test deleteAccount to delete an Account
	public static void TestDeleteAccount() {
		System.out.println("==>TestDeleteAccount()");
		CardStorage s = new CardStorage();
		System.out.println(s);
		String name = "James Thomas";
		int card =  123456;
		String password = "thomas";
		s.addAccount(name, card, password);
		System.out.println("Number of accounts added: " + s.numAccount());
		s.deleteAccount(name, password);
		System.out.println("Number of accounts added: " + s.numAccount());
	}
	
	//create two accounts and make sure one account is deleted
	public static void TestDeleteOneAccountMultipleAdded() {
		System.out.println("/n==>TestDeleteOneAccountMultipleAdded()");
		CardStorage s = new CardStorage();
		String name1 = "James Thomas";
		int card1 =  123456;
		String password = "thomas";
		String name2 = "Charles Darwin";
		int card2 = 257859;
		String password2 = "tommy";
		s.addAccount(name1, card1, password);
		s.addAccount(name2, card2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
		s.deleteAccount(name1, password);
		s.deleteAccount(name2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
	}
	
	//create two accounts and delete both
	public static void TestDeleteMultipleAccounts() {
		System.out.println("/n==>TestDeleteMultipleAccounts()");
		CardStorage s = new CardStorage();
		String name1 = "James Thomas";
		int card1 =  123456;
		String password = "thomas";
		String name2 = "Charles Darwin";
		int card2 = 257859;
		String password2 = "tommy";
		s.addAccount(name1, card1, password);
		System.out.println("Number of accounts added: " + s.numAccount());
		s.deleteAccount(name1, password);
		System.out.println("Number of accounts added: " + s.numAccount());
		s.addAccount(name2, card2, password2);
		System.out.println("Number of accounts added: " + s.numAccount());
		s.deleteAccount(name2, password2);
		System.out.println("Account: " + s.getAccount(name2, password2));
		System.out.println("Number of accounts added: " + s.numAccount());

	}
	
	
}
