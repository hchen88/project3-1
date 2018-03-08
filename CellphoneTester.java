package edu.project3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CellphoneTester {

	public static String mainMenu() {
		String mainMenu = "	---Main Menu--- \n1. Receive A Call \n2. Make A Call \n3. Modify Phonebook \n4. Display Phonebook \n5. Preset Favorites \n"
				+ "6. Display Call Log \n7. Quit ";
		return mainMenu;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput; 
		PhoneBook phoneBook = new PhoneBook();
		//TreeMap<String, Contact> phoneBook = new TreeMap<String, Contact>();
		//TreeMap<String, Contact> numberBook = new TreeMap<String, Contact>();
	
		do {
			System.out.println(mainMenu()); 
			userInput = in.nextLine().trim(); 
			if (userInput.equals("1")) {
				//receives a call
			}
			else if (userInput.equals("2")) {
				System.out.println("Choose an option: \n1. By using phone number. \n2. By using contact. \3. By using preset favorite.");
				String callInput = in.nextLine().trim();
				if (callInput.equals("1")) { //makes call by using phone number
					System.out.println("Enter a ten digit phone number:");
					String phoneNumber = in.nextLine().trim(); 
					numberBook.put(phoneNumber, new Contact(phoneNumber));
					numberBook.get(phoneNumber).updateOutgoingCounter();
					numberBook.get(phoneNumber).setTimeStamp();
				}
				else if (callInput.equals("2")) { //makes call by using contact
					String option;
					do { 
						System.out.println("Enter a contact name:");
						String contactName = in.nextLine().trim();
						boolean found = phoneBook.checkPhonebook(contactName);
						if (found) {
							//print contact
							Contact receivedContact = phoneBook.getContact(contactName);
							System.out.println(receivedContact);
							System.out.println("Would you like to call " + contactName + "?\n1. Yes \n2. No");
							String call = in.nextLine().trim();
							if (call.equals("1")) { 
								receivedContact.updateOutgoingCounter();
								receivedContact.setTimeStamp();
							}
							option = "2"; 
						} 
						else {
							System.out.println("Select an option: \n1. Enter a name again. \n2. Go to main menu.");
							option = in.nextLine().trim();
						}
					}while (!option.equals("2"));
				}
				else if(callInput.equals("3")) { //makes call by using preset favorites
					// CALLS USING PRESETS
				}
			}
			else if (userInput.equals("3")) {
				System.out.println("Would you like to: \n1. Add a Contact \n2. Edit a Contact \n3. Delete a Contact \n4. Display a Contact");
				String option = in.nextLine().trim();
				if (option.equals("1")) {
					System.out.println("Enter the name of the contact:");
					String contactName = in.nextLine().trim();
					System.out.println("Enter the phone number:");
					String phoneNumber = in.nextLine().trim();
					System.out.println("Enter email:");
					String email = in.nextLine().trim();
					System.out.println("Enter any notes:");
					String notes = in.nextLine().trim();
					phoneBook.addContact(contactName, new Contact(contactName, phoneNumber, email, notes));
				}
				else if (option.equals("2")) {
					System.out.println("Enter the name of the contact to be editted:");
					String contactName = in.nextLine().trim();
					boolean found = phoneBook.checkPhonebook(contactName);
					if (found) {
						Contact receivedContact = phoneBook.getContact(contactName);
						System.out.println("Enter a new name for the contact:");
						String newName = in.nextLine().trim();
						receivedContact.editName(newName);
						System.out.println("Enter a new phone number for the contact:");
						String newNumber = in.nextLine().trim();
						receivedContact.editNumber(newNumber);
						System.out.println("Enter a new email for the contact:");
						String newEmail = in.nextLine().trim();
						receivedContact.editEmail(newEmail);
						System.out.println("Enter any new notes:");
						String newNotes = in.nextLine().trim();
						receivedContact.editNotes(newNotes);
					}
					else {
						System.out.println("This contact is not in the phonebook.");
					}
				}
				else if (option.equals("3")) {
					System.out.println("Enter the name of the contact to be deleted:");
					String name = in.nextLine().trim();
					boolean found = phoneBook.checkPhonebook(name);
					if (found) {
						phoneBook.delContact(name);
					}
					else {
						System.out.println("This contact is already not in the phonebook.");
					}
				}
			else if (option.equals("4")) {
					System.out.println("Enter contact name to display:");
					String contactName = in.nextLine().trim();
					boolean found = phoneBook.checkPhonebook(contactName);
					if (found) {
						Contact receivedContact = phoneBook.getContact(contactName);
						System.out.println(receivedContact);
					}else {
						System.out.println("Contact doesn't exist.");
					}
				}
			}
			else if (userInput.equals("4")) {
				// PRINT PHONEBOOK TREEMAP
				System.out.println("Your Phonebook:\n");
				System.out.println(phoneBook);
			}
			else if (userInput.equals("5")) {
				//PRESET FAVORITES
				System.out.println("Would you like to: \n1. Display your Presets \n2. Add a Preset \n3. Delete a Preset \n4. Rearrange the Presets");
				String option = in.nextLine().trim();
				if(option.equals("1")) {
					//DISPLAY PRESETS
				}else if(option.equals("2")) {
					//ADD PRESET
					System.out.println("Enter contact you would like to preset: ");
					String contact = in.nextLine().trim();
					boolean found = phoneBook.checkPhonebook(contact);
					if(found) {
						System.out.println("Enter preset number: ");
						int presetNum = in.nextInt();
						
					}else {
						System.out.println("Contact doesn't exist in the phonebook.");
					}
					
				}else if(option.equals("3")) {
					//DELETE PRESET
				}else if(option.equals("4")) {
					//REARRANGE PRESETS
				}
			}
			else if (userInput.equals("6")) {
				// DISPLAY CALL LOG
				System.out.println("Enter 1 if you would like to see more details of the call log.\nIf not, then enter anything else to go back to the main menu.");
				String option = in.nextLine().trim();
				if(option.equals("1")) {
					//DETAILED CALL LOG (Multiple occurrences)
				}
			}
		}while (!userInput.equals("7")); 
		System.out.println("Goodbye");
		in.close();
	}
}
