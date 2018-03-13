package edu.project3;

import java.util.TreeMap;

public class PhoneBook {
	
	/**
	 * Stores all contacts
Adds/Deletes contact
Displays contacts in alphabetical order
	 */
	 
	private static TreeMap<String, Contact> phoneBookMap = new TreeMap<String, Contact>(); //key contact name or number , value - Contact obj
	
	/**
	 * gets the phonebook tree map
	 * @return phoneBookMap - phonebook tree map
	 */
	public static TreeMap<String,Contact> getPhoneBook() {
		return phoneBookMap;
	}
	
	/**
	 * makes phonebook object
	 */
	public PhoneBook() {
		
	}
	/**
	 * This method is used to get phoneBookMap
	 * @returns phoneBookmap - phonebook tree map
	 */
	public TreeMap<String, Contact> getphoneBookMap() {
		return phoneBookMap;
	}
	
	/**
	 * Gets the contact in the phonebook tree map
	 * @param contactName - contact name as a string
	 * @return phoneBookMap - phonebook tree map
	 */
	public static Contact getContact(String contactName) {
		return phoneBookMap.get(contactName);
	}
	

	/**
	 * This method adds a new element to phoneBookMap with the key as a 
	 * string and the value as an object.
	 * @param contactName- String variable for each contact
	 * @param contactObj- Object for each contact
	 ***/
	public void addContact(String phoneNumber, Contact contactObj   ) {
		if ( !phoneBookMap.containsKey(phoneNumber)) {
			phoneBookMap.put(phoneNumber, contactObj);
		} else {
			System.out.println("Contact already added!");
		}

		
	}
	
	/**
	 * This method deletes the element with a specific contact name.
	 * @param contactName - string variable for contact name 
	 */
	public void delContact(String contactName) {
		
		phoneBookMap.remove(contactName);
		
	}
	
	/**
	 * Checks the phonebook to see if the contact is present
	 * @param contactName - contact name as a string
	 * @return found - true or false if found
	 */
	public static boolean checkPhonebook(String contactName) {
		
		boolean found = false;
		for( String key : phoneBookMap.keySet()) {
			if (contactName.equals(key)) {
				found = true;
			}
		}
		return found;
	}
	 
	/**
	 * Formats the phonebook tree map 
	 */
	public String toString() { //all contact information
		String str = "";
        for(Contact c : phoneBookMap.values()){
        	String numFormat = "(" + c.getNum().substring(0,3) + ")" + c.getNum().substring(3,6) + "-" + c.getNum().substring(6); 
            str += c.getName() + "\t" + numFormat + "\t" + c.getEmail() + "\t" + c.getNotes() + "\n";

        }
	    return str;
	}
}
