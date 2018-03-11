package edu.project3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Calls{
	//Formats the call log with time stamp, name, number times called, incoming or outgoing.
	
	//private static ArrayList<String> callLog = new ArrayList<>(); // actual call log  , would be easier with Hash Map
	
	private static HashMap<String, String> callLogMap = new HashMap<>(); // key string- contact name , value toString();
	private static HashMap<String, Integer> callOccurences = new HashMap<>(); //key contact( phone number or contact name), value numOccurances
	private int outgoingCounter = 0;
	private int incomingCounter = 0;
	private String callType = "";
	

	public void makeCallNumber(String number) {
		
		this.outgoingCounter ++;
		String outgoingTimeStamp = timeStamp(); 
		callType = "(Outgoing)";
		//need to implement call log
	}
	
	
	public void makeCallPreset(int presetNum) {
		
		
		this.outgoingCounter ++;
		String outgoingTimeStamp = timeStamp(); 
		callType = "(Outgoing)";
		//need to add element to ArrayList
		String finalStr = "" + outgoingTimeStamp + callType;
		callLog.add(finalStr);
	}
	
	public void makeNonContactCall(String randomNumber) {
		//needs conditonal if random call was called previously or not.
		if(checkCallLog(randomNumber)) { //number was found
			callOccurences.replace(randomNumber,callOccurences.get(randomNumber) + 1 ); //increments.
			String outgoingTimeStamp = timeStamp(); //calls timeStamp method for current time
			String callStr  = randomNumber + callOccurences.get(randomNumber) +"\n"+ outgoingTimeStamp + "(Outgoing)";
			// String for call Line
			callOccurences.replace(randomNumber, callStr); //replaces 
		}else {
			callOccurences.put(randomNumber, 1); // puts new randomnumber in with 1 occurance
			String outgoingTimeStamp = timeStamp(); //calls timeStamp method for current time
			String callStr = randomNumber + "\n"+ outgoingTimeStamp + "(Outgoing)"; // String for call Line
			callOccurences.add(callStr); //appends call String variable to ArrayList	
		}
	
		
	}
	
	/**
	 * this is a method that increments the incomingCounter
	 * every time a call is received.
	 */

	public void receiveCall() {
		
		this.incomingCounter ++;
		String incomingTimeStamp = timeStamp(); 
		callType = "(Incoming)";
		//need to implement call log
	}
	
	public ArrayList getCallLog () {
		return callLog;
	}
	
	
	public String timeStamp() {
		
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
			
		return timeStamp;

		
	}
	
	public boolean checkCallLog(String contact) {
		boolean found = false;
		if (callLogMap.containsKey(contact)) {
			found = true;
		}
		
		return found;
		
	}

	public String toString() { //to string for calls 
		
		String str = "";
		
		str = "\n";
		
		return str;
		
	}
	

}
