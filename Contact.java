package edu.project3;
/**
 * creates a default contact object
 * @author Scott Arima, Howard Chen, Nora Koirala, Mario Bajenting
 * @version 1.0.0
 * @since 2018-03-13
 *
 */
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
	
	/**
	 * this method returns a string email
	 * @return the string email variable
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * this method returns a string notes
	 * @return the string notes variable
	 */
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
	
	/**
	 * this method edits the email variable
	 * @param email - String email varaible
	 */
	public void editEmail(String email) {
		this.email = email;
	}
	
	/**
	 * this method edits the notes variable
	 * @param notes - String notes variable
	 */
	public void editNotes(String notes) {
		this.notes = notes;
	}
			
	/**
	 * Formats the contact objects
	 */
	public String toString() { //single contact information
		String str ="";
		
		if (this.name.equals("N/A")) {
			str = this.number;
		}else {
			String numFormat = "";
			if(this.number.length()==10) {
				numFormat = "(" + this.number.substring(0,3) + ")" + this.number.substring(3,6) + "-" + this.number.substring(6);
			}
			else {
				numFormat = this.number.substring(0,3) + "-" + this.number.substring(3);
			}
			str = this.name + "\t" + numFormat + "\t" + this.email + "\t" + this.notes;
		}
		return str;
	}
}
