
public class ATMCard {
	
	
	String name;
	String vorname;
	String IBAN;
	String kontoBezeichnung;
	
	String bankbezeichnung;
	String cardNumber;
	String validDate;
	String pin;
	
	
	
	
	
	
	public String getKontoBezeichnung() {
		return kontoBezeichnung;
	}

	public void setKontoBezeichnung(String kontoBezeichnung) {
		this.kontoBezeichnung = kontoBezeichnung;
	}
	
	
	
	@Override
	public String toString() {
		return name +" "+ vorname ;
	}







	public ATMCard(String name, String vorname,String kontoBezeichnung, String iBAN, String bankbezeichnung, String cardNumber, String validDate,
			String pin) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.kontoBezeichnung=kontoBezeichnung;
		this.IBAN = iBAN;
		this.bankbezeichnung = bankbezeichnung;
		this.cardNumber = cardNumber;
		this.validDate = validDate;
		this.pin = pin;
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
		return bankbezeichnung;
	}
	public void setBankbezeichnung(String bankbezeichnung) {
		bankbezeichnung = bankbezeichnung;
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
