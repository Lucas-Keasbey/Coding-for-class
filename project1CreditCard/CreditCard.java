package project1CreditCard;

public class CreditCard {
	private int cardNumber;
	private int expMonth;
	private int expYear;
	private int secCode;

	public CreditCard(int cardNumber, int expMonth, int expYear, int secCode) {
		super();
		if (checkLuhn(cardNumber)) {
			this.cardNumber = cardNumber;
			this.expMonth = expMonth;
			this.expYear = expYear;
			this.secCode = secCode;
		}
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		if (checkLuhn(cardNumber)) {
			this.cardNumber = cardNumber;
		}
	}
	
	public int getExpMonth() {
		return expMonth;
	}
	
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	
	public int getExpYear() {
		return expYear;
	}
	
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	
	static boolean checkLuhn(int cardNumber){
		String cardNo = ""+cardNumber;
	    int nDigits = cardNo.length();
	    int nSum = 0;
	    boolean isSecond = false;
	    for (int i = nDigits - 1; i >= 0; i--){
	        int d = cardNo.charAt(i) - '0';
	        if (isSecond == true)
	            d = d * 2;
	 
	        // We add two digits to handle
	        // cases that make two digits
	        // after doubling
	        nSum += d / 10;
	        nSum += d % 10;
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}
	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + "\nexpMonth=" + expMonth + "\nexpYear=" + expYear + "]";
	}
}
