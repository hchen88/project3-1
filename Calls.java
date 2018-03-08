package edu.project3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calls{
	//Formats the call log with time stamp, name, number times called, incoming or outgoing.
	
	ArrayList<String> callLog = new ArrayList<>();
	private int outgoingCounter = 0;
	private int incomingCounter = 0;
	private String callType = "";
	
	
	public void makeCallNumber(String number) {
		
		this.outgoingCounter ++;
		String outgoingTimeStamp = timeStamp(); 
		callType = "(Outgoing)";
		//need to implement call log
	}
	
	
	public void makeCallPreset() {

		this.outgoingCounter ++;
		String outgoingTimeStamp = timeStamp(); 
		callType = "(Outgoing)";
		//need to implement call log
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

	public String toString() {
		
		String str = "";
		str = "\n";
		return str;
		
	}
	

}
