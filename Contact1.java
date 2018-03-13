package edu.project3;


public class Contact {
	
	private String name = "N/A";
	private String number= "";
	private String email = "";
	private String notes = "";
	
	/**
	 * creates a default contact object
	 */
	public Contact() {

	}
	  
	/**
	 * creates a contact object with a given name and number
	 * @param name is a string variable with a name.
	 * @param number is a string variable with a phone number.
	 */
	public Contact(String name, String number, String email, String notes) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.notes = notes;
		
	}
	
	/**
	 * creates a contact object with only the number
	 * @param number is a string variable with a phone number.
	 */
	public Contact(String number) {
		this.number = number;
	}
	
	/**
	 * this is a method that returns a string variable number
	 * @return the string number variable 
	 */
	
	public String getNum() {
		return this.number;
	}
	
	/**
	 * this is a method that returns a string name
	 * @return the string name variable
	 */
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * this method sets/edits the name 
	 * @param name - String type variable 
	 */
	public void editName(String name) {
	
		this.name = name;
	}
	/**
	 * this method sets/edits the Number
	 * @param number - String type variable
	 */
	public void editNumber(String number) {
		this.number = number;
	}
	
	public void editEmail(String email) {
		this.email = email;
	}
	
	public void editNotes(String notes) {
		this.notes = notes;
	}
			
	
	public String toString() { //single contact information
		String str ="";
		
		if (this.name.equals("N/A")) {
			str = this.number;
		}else {
			String numFormat = "(" + this.number.substring(0,3) + ")" + this.number.substring(3,6) + "-" + this.number.substring(6); 
			str = this.name + "\t" + numFormat + "\t" + this.email + "\t" + this.notes;
		}
		return str;
	}
}
