package edu.project3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import edu.project3.PhoneBook;

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
		String[] presetList = new String[5];
		HashMap<String, Calls>  callLog = Calls.getCallLog();
		TreeMap<String, Contact> phoneBookMap = PhoneBook.getPhoneBook();
		HashMap<String, FavoriteContactFrame> contactFrameMap = new HashMap<>();
		int fWidth = 900;
		int fHeight = 600;
		
		do {
			System.out.println(mainMenu()); 
			userInput = in.nextLine().trim();
			callLog = Calls.getCallLog();
			phoneBookMap = PhoneBook.getPhoneBook();
			
			if (userInput.equals("1")) {
				if (!callLog.containsKey("5555555555")) { //no received calls in call log yet
					callLog.put("5555555555", new Calls("Incoming", "5555555555", false)); //adds new call to call log
					System.out.println("Received call from (555)555-5555");
				} else {
					callLog.get("5555555555").updateCallLog("5555555555"); 
					}
							
			}else if (userInput.equals("2")) {
				System.out.println("Choose an option: \n1. By using phone number. \n2. By using contact. \n3. By using preset favorite.");
				String callInput = in.nextLine().trim();
				if (callInput.equals("1")) { //makes call by using phone number
					System.out.println("Enter a ten digit phone number:");
					String phoneNumber = in.nextLine().trim();
					
					if(!phoneBookMap.containsKey(phoneNumber)) { //is not in phone book
						if(!callLog.containsKey(phoneNumber)) { //is not in phone book and not call log
							callLog.put(phoneNumber, new Calls("Outgoing",phoneNumber, false)); //adds new call to call log
							System.out.println("Making call to " + phoneNumber);
							
						}else {   //is not in  phone book but is in call log
							callLog.get(phoneNumber).updateCallLog(phoneNumber); //adds call to call log.
							System.out.println("Making call to" + phoneNumber);
						}
					}else { //is in phone book 
						if(!callLog.containsKey(phoneNumber)) { //is in phone book but not in callLog yet
							String contactName = phoneBookMap.get(phoneNumber).getName();
							callLog.put(phoneNumber, new Calls("Outgoing", contactName, true)); //adds new call to call log
							System.out.println("Making call to" + contactName);
						}else {  // is in phone book but already in call log.
							callLog.get(phoneNumber).updateCallLog(phoneNumber); //adds call to call log.
							String contactName = phoneBookMap.get(phoneNumber).getName();
							System.out.println("Making call to" + contactName);  //done
						}	
					}
					
				}else if (callInput.equals("2")) { //makes call by using contact 
					String option = null;
					do { 
						callLog = Calls.getCallLog();
						phoneBookMap = PhoneBook.getPhoneBook();
						System.out.println("Enter a contact name:");
						String contactName = in.nextLine().trim();
						boolean found = PhoneBook.checkPhonebook(contactName);
						if (found) { //in Phone book
							System.out.println(phoneBookMap.get(contactName)); //print contact info object
							System.out.println("Would you like to call " + contactName + "?\n1. Yes \n2. No");
							String call = in.nextLine().trim();
							if (call.equals("1")) { //calling by contactName 
								if(!callLog.containsKey(contactName)){ //call log does not contain contactName yet		
									callLog.put(contactName, new Calls("Outgoing", contactName, true));
									System.out.println("Making call to " +  contactName);
									option = "2";
								}else { //contact already in log
									callLog.get(contactName).updateCallLog(contactName);
									System.out.println("Making call to " +  contactName);
									option = "2";
								}
							}else {
								option = "2";//does nothing to break out of loop
								
							}
						}else{ //not found in phone book
							System.out.println("Name was not in PhoneBook!");
							System.out.println("Select an option: \n1. Enter a name again. \n2. Go to main menu.");
							option = in.nextLine().trim();
						}
					}while (!option.equals("2"));
				}
				else if(callInput.equals("3")) { //makes call by using preset favorites
					// CALLS USING PRESETS
					//Working here
					int presetNum = 5;
					callLog = Calls.getCallLog();
					phoneBookMap = PhoneBook.getPhoneBook();
					
					do {
						System.out.println("Enter a preset number:");
						presetNum = in.nextInt();
						Contact[] contact = PresetList.getPresetContactList();
						Contact contactObj = contact[presetNum-1];
						String contactName = contactObj.getName();
						String contactNum = contactObj.getNum();
						System.out.println("Calling" + contactName + "\t" + contactNum);
						if ( callLog.containsKey(contactName)) { //in callog already
							callLog.get(contactName).updateCallLog(contactName);
						} else { // not in call log
							callLog.put(contactName, new Calls("Outgoing", contactName, true));
						}
					} while(presetNum < 6 && presetNum > 0 );
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
					System.out.println("New contact added.");
				}
				else if (option.equals("2")) {
					System.out.println("Your Phonebook:\n");
					System.out.println(phoneBook);
					System.out.println("Enter the name of the contact to be editted:");
					String contactName = in.nextLine().trim();
					boolean found = PhoneBook.checkPhonebook(contactName);
					if (found) {
						Contact receivedContact = PhoneBook.getContact(contactName);
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
						System.out.println("Contact editted.");
					}
					else {
						System.out.println("This contact is not in the phonebook.");
					}
				}
				else if (option.equals("3")) {
					System.out.println("Enter the name of the contact to be deleted:");
					String name = in.nextLine().trim();
					boolean found = PhoneBook.checkPhonebook(name);
					if (found) {
						phoneBook.delContact(name);
						System.out.println("Contact deleted.");
					}
					else {
						System.out.println("This contact is already not in the phonebook.");
					}
				}
			else if (option.equals("4")) {
					System.out.println("Enter contact name to display:");
					String contactName = in.nextLine().trim();
					boolean found = PhoneBook.checkPhonebook(contactName);
					boolean go = true;
					while(go) {
						if (found) {
							Contact receivedContact = PhoneBook.getContact(contactName);
							System.out.println(receivedContact);
						}else {
							System.out.println("Contact doesn't exist.");
							System.out.println("1. Would you like to re-enter contact.\n2. Create a new contact.\n3. Return to main menu.");
							String choice = in.nextLine().trim();
							if (choice == "1") {
								System.out.println("Enter new contact name to find:");
								String contactInput = in.nextLine().trim();
								PhoneBook.checkPhonebook(contactInput);
							}else if(choice == "2") {
								System.out.println("Enter the name of the contact:");
								String contactInput = in.nextLine().trim();
								System.out.println("Enter the phone number:");
								String phoneNumber = in.nextLine().trim();
								System.out.println("Enter email:");
								String email = in.nextLine().trim();
								System.out.println("Enter any notes:");
								String notes = in.nextLine().trim();
								phoneBook.addContact(contactInput, new Contact(contactInput, phoneNumber, email, notes));
								System.out.println("New contact added.");
								go = false;
							}else if(choice == "3") {
								go = false;
							}
						}
					}
				}
			}
			else if (userInput.equals("4")) {
				System.out.println("Your Phonebook:\n");
				System.out.println(phoneBook);
			}
			else if (userInput.equals("5")) {
				//PRESET FAVORITES
				System.out.println("Would you like to: \n1. Display your Presets \n2. Add a Preset \n3. Delete a Preset \n4. Rearrange the Presets");
				String option = in.nextLine().trim();
				if(option.equals("1")) {
					//DISPLAY PRESETS
					System.out.println("Your Presets:\n");
					System.out.println(presetList);
				}else if(option.equals("2")) {
					//ADD PRESET
					System.out.println("Enter contact you would like to preset: ");
					String contact = in.nextLine().trim();
					boolean found = PhoneBook.checkPhonebook(contact);
					if(found) {
						System.out.println("Enter preset number (1-5): ");
						String presetNum = in.nextLine().trim();
						int intPresetNum = Integer.parseInt(presetNum);
						PresetList.addPreset(intPresetNum, PhoneBook.getContact(contact));
						String formatedNum ="(" + PhoneBook.getContact(contact).getNum().substring(0,3) + ")" + PhoneBook.getContact(contact).getNum().substring(3,6) + "-" + PhoneBook.getContact(contact).getNum().substring(6);
						System.out.println("Go to C:\\Users\\Scott Arima\\Desktop\\Pokemon\\ to view photos");
						System.out.println("Enter a picture you would like to use for this Preset:");
						String pictureName = in.nextLine().trim();
						contactFrameMap.put(contact, new FavoriteContactFrame("C:\\Users\\Scott Arima\\Desktop\\Pokemon\\" + pictureName +".jpg", fWidth, fHeight, contact, formatedNum, PhoneBook.getContact(contact).getEmail(), PhoneBook.getContact(contact).getNotes()));
						System.out.println("Preset added with this picture");
						contactFrameMap.get(contact).displayContactFrame();
					}else {
						System.out.println("Contact doesn't exist in the phonebook.");
					}
				}else if(option.equals("3")) {
					//DELETE PRESET
					System.out.println("Enter preset number you would like to delete:");
					int presetNum = in.nextInt();
					PresetList.deletePreset(presetNum);
					System.out.println("Preset deleted");
				}else if(option.equals("4")) {
					//REARRANGE PRESETS
					System.out.println("You will enter 2 preset numbers to swap the order.");
					System.out.println("Enter first preset number:");
					int presetNum1 = in.nextInt();
					System.out.println("Enter second preset number:");
					int presetNum2 = in.nextInt();
					PresetList.rearrangePreset(presetNum1, presetNum2);
					System.out.println("Presets rearranged.");
				}
			}
			else if (userInput.equals("6")) {
				System.out.println(Calls.getShortCalls());
				System.out.println("Would you like to view detailed calls?Y/N");
				String response = in.nextLine();
				if(response.equals("Y")) {
				System.out.println(Calls.getDetailedCalls());
				}
			}
		}while (!userInput.equals("7")); 
		System.out.println("Goodbye");
		in.close();
	}
}
