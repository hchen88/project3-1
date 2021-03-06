package edu.project3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class logs all calls creates a Calls object to form a Call Log
 * @author Scott Arima, Howard Chen, Nora Koirala, Mario Bajenting
 * @version 1.0.0
 * @since 2018-03-13
 *
 */
public class Calls {
	
	private static HashMap<String, Calls > callLog = new HashMap<String, Calls>(); 
	private ArrayList<String> timeStamps = new ArrayList<String>(); // string of array list 
	private String callType;
	private String nameNumber;
	private boolean hasName;
	private String timeStamp;
	private int counter;
	
	/**
	 * method used to get callLog HashMap
	 * @returns callLog 
	 */
	public static HashMap<String,Calls> getCallLog() {
		return callLog;
	}

	/**
	 * Creates a calls object
	 * @param callType - outgoing or incoming call
	 * @param phoneNumber - name or number of contact
	 * @param hasName - boolean if name is present in contact
	 */
	public Calls(String callType, String nameNumber, boolean hasName){
		this.callType = callType;
		this.nameNumber = nameNumber;
		this.counter = 1;
		this.hasName = hasName;
		this.timeStamp = setTimeStamp();
		timeStamps.add(this.timeStamp); //adds timeStamp to arraylist for detailed.
	}
	
	
	/**
	 * if phone number was already in call log, updates call log
	 * @param phoneNumber - phonenumber as a string
	 */
	public void updateCallLog (String phoneNumber) {
		this.counter ++;
		this.timeStamp = setTimeStamp();
		timeStamps.add(this.timeStamp); 
	}
	
	/**
	 * this method gets the detailed calls
	 * @return the formatted detailed calls
	 */
	public static String getDetailedCalls() {
		String str = "";
		for(Calls s : callLog.values() ) {
			for(String tS : s.timeStamps) {
				if(s.hasName) {
					str += s.nameNumber + "\n" + tS + "\t" + s.callType + "\n";
				}else {
					if (s.nameNumber.length() == 10) {
						String numFormat = "(" + s.nameNumber.substring(0,3) + ")" + s.nameNumber.substring(3,6) + "-" + s.nameNumber.substring(6); 
						str += numFormat + "\n" + tS + "\t" + s.callType + "\n";
					}
					else {
						String numFormat = s.nameNumber.substring(0,3) + "-" + s.nameNumber.substring(3);
						str += numFormat + "\n" + tS + "\t" + s.callType + "\n";
					}
				}
			}
		}
		return str;
	}
	
	/**
	 * sets the time stamp for each call, and adds to the array list of all the time stamps for that call
	 * @returns timeStamp in String format
	 */
	public String setTimeStamp() {
		
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
		
		String timeStamp = month + "/" + day + "/" + year + "\t " + timeFormat;
		
		return timeStamp;
 
	}
	
	/**
	 * this method displays the regular calls not the detailed calls
	 * @return formatted regular calls
	 */
	public static String getShortCalls() {
		String str = "";
		for(Calls s : callLog.values() ) {
			if(s.hasName) {
				str += s.nameNumber +" (" + s.counter + ")\n" + s.timeStamp + "\t" + s.callType + "\n";
			}else {
				if (s.nameNumber.length() == 10) {
					String numFormat = "(" + s.nameNumber.substring(0,3) + ")" + s.nameNumber.substring(3,6) + "-" + s.nameNumber.substring(6); 
					str += numFormat +" (" + s.counter + ")\n" + s.timeStamp + "\t" + s.callType + "\n";
				}else {
					String numFormat = s.nameNumber.substring(0,3) + "-" + s.nameNumber.substring(3);
					str += numFormat + "\n" + s.timeStamp + "\t" + s.callType + "\n";
				}
			}
		}
		return str;
	}
	
	/**
	 * Formats the call log
	 */
	public String toString() { //to string contains all detailed time stamps for 
		String str = "";
		for(Calls s : callLog.values() ) {
			
			str += s.nameNumber + "\n" + s.timeStamp + "\t" + s.callType + "\n";
			}
		
		return str;
	}
}
