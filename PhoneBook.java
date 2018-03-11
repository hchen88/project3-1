package edu.project3;

import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
	
	/**
	 * Stores all contacts
Adds/Deletes contact
Displays contacts in alphabetical order

	 */
	
	private static TreeMap<String, Contact> phoneBookMap = new TreeMap<String, Contact>();
	
	public PhoneBook() {
		
	}
	/**
	 * This method is used to get phoneBookMap
	 * @returns phoneBookmap
	 */
	public TreeMap<String, Contact> getphoneBookMap() {
		return phoneBookMap;
	}
	
	public Contact getContact(String contactName) {
		return phoneBookMap.get(contactName);
	}

	/**
	 * This method adds a new element to phoneBookMap with the key as a 
	 * string and the value as an object.
	 * @param contactName- String variable for each contact
	 * @param contactObj- Object for each contact
	 ***/
	public void addContact(String contactName, Contact contactObj   ) {
		if ( !phoneBookMap.containsKey(contactName)) {
			phoneBookMap.put(contactName, contactObj);
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
	
	
	public boolean checkPhonebook(String contactName) {
		
		boolean found = false;
		for( String key : phoneBookMap.keySet()) {
			if (contactName.equals(key)) {
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * This is a method 
	 */
	public String toString() { //all contact information
		String str = "";
		Set<String> keys = phoneBookMap.keySet();
        for(String key: keys){
            System.out.println(phoneBookMap.get(key));
        }
	    return str;
	}
	
	
}

