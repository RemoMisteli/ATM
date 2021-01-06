
public class ATMCard {
	
	
	String name;
	String vorname;
	String IBAN;
	String Bankbezeichnung;
	String cardNumber;
	String validDate;
	String pin;
	
	
	
	boolean gespert=false;
	
	public void karteSperren() {
		gespert=true;
	}
	
	public boolean isGespert() {
		return gespert;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return name +" "+ vorname ;
	}







	public ATMCard(String name, String vorname, String iBAN, String bankbezeichnung, String cardNumber, String validDate,
			String pin, boolean gespert) {
		super();
		this.name = name;
		this.vorname = vorname;
		IBAN = iBAN;
		Bankbezeichnung = bankbezeichnung;
		this.cardNumber = cardNumber;
		this.validDate = validDate;
		this.pin = pin;
		this.gespert = gespert;
	}







	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getBankbezeichnung() {
		return Bankbezeichnung;
	}
	public void setBankbezeichnung(String bankbezeichnung) {
		Bankbezeichnung = bankbezeichnung;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}








	
	
	
	

}
