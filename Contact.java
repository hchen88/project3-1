package edu.project3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Contact {
	
	private String name = "N/A";
	private String number= "";
	private String email = "";
	private String notes = "";
	private int outgoingCounter = 0;
	private int incomingCounter = 0;
	private ArrayList <String> timeStamps = new ArrayList<String>();
	//private ArrayList <String> callType = new ArrayList<String>();
	public static ArrayList<String> callLogArray = new ArrayList<String>();
	
	
	

	
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
	
	//set time stamp.
	public void makeCall() {
		outgoingCounter++;
		
	}
	
	public String formatCall() {
		
		String str = "";
		if (incomingCounter >= 1) { 
			str = number + "\n" + timeStamps.get(timeStamps.size() -1) + "\t(Incoming)";
		} else if (outgoingCounter > 1 && name.equals("N/A")) {
			str = number + "\t("+ outgoingCounter + ")\n" + timeStamps.get(timeStamps.size()-1) + "\t(Outgoing)";
			
		}else if (outgoingCounter > 1 && !(name.equals("N/A"))){
			str = name + "\t(" + outgoingCounter + ")\n" + timeStamps.get(timeStamps.size() -1) + "\t(Outgoing)"; 
		}else {
			str = name + "\n" + timeStamps.get(timeStamps.size() -1) + "\t(Outgoing)"; 
		}
		
		return str;
	}
	
	public String formatDetailedCall() {
		String str = "";
		
		for( String time : timeStamps) {
			if (incomingCounter >= 1) { 
				str += number + "\n" + time + "\t(Incoming)";
			} else if (outgoingCounter > 1 && name.equals("N/A")) {
				str += number + "\n" + time + "\t(Outgoing)";
				
			}else if (outgoingCounter > 1 && !(name.equals("N/A"))){
				str += name +  "\n" + time + "\t(Outgoing)"; 
			}
		}
		return str;
	}
	
	public void receiveCall() {
		incomingCounter++;
	}
	
	public int getOutgoingCounter() {
		return outgoingCounter; 
	}
	
	public int getIncomingCounter() {
		return incomingCounter;
	}	
	
	public void setTimeStamp() {
		
		String now = LocalDateTime.now().toString();
		String year = now.substring(0,4);
		String month = now.substring(5,7);
		String day = now.substring(8, 10);
		String minute = now.substring(14,16);
		String hour_24 = now.substring(11,13);
		String hour_12;
		String timeFormat;
		
		if (Integer.parseInt(hour_24) > 12) {
			hour_12 = Integer.toString(Integer.parseInt(hour_24) - 12);
			timeFormat = hour_12 + ":" + minute + " PM";

			}
		else {
			hour_12 = Integer.toString(Integer.parseInt(hour_24) + 12);
			timeFormat = hour_12 + ":" + minute + " AM";
			}
		
		String timeStamp = month + "/" + day + "/" + year + "/t" + timeFormat;
		
		timeStamps.add(timeStamp);
	}
	
	public ArrayList<String> getTimeStamps() {
		return timeStamps; 
	}
	
	public String toString() { //single contact information
		String str ="";
		
		if (this.name.equals("N/A")) {
			str = this.number;
		}else {
			str = this.name + "\t" + this.number + "\t" + this.email + "\t" + this.notes;
		}
		return str;
	}
}
