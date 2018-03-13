package edu.project3;
/**
 * This class Adds, delete, rearrange, and displays presetlist
 * @author Scott Arima, Howard Chen, Nora Koirala, Mario Bajenting
 *  @version 1.0.0
 * @since 2018-03-13
 *
 */

public class PresetList {
	/**
	 * Adds, delete, rearrange, and displays preset list
	 */

	static String copy = "";
	static Contact copyObj = new Contact();
	
	private static Contact[] presetContactList = new Contact[5];
	private static String[] presetStringList = new String[5];
	
	/**
	 * creates a new preset list
	 */
	
	public PresetList() {
		
	}
	
	/**
	 * adds a preset favorite
	 * @param presetNum
	 * @param contactObj
	 */
	public static void addPreset(int presetNum, Contact contactObj) {
		
		presetStringList[presetNum - 1 ] =  contactObj.getName();
		presetContactList[presetNum-1] = contactObj;
		
	}
	
	/**
	 * removes a preset favorite
	 * @param presetNum
	 */
	public static void deletePreset(int presetNum) {
		presetStringList[presetNum - 1] =  null;
		presetContactList[presetNum-1] = null;
		
	}
	
	/**
	 * rearranges preset favorites
	 * @param presetNum1
	 * @param presetNum2
	 */
	
	public static void rearrangePreset(int presetNum1, int presetNum2) {
		copy = presetStringList[presetNum1 - 1];
		copyObj = presetContactList[presetNum1 - 1];
		presetStringList[presetNum1 -1] = presetStringList[presetNum2 - 1];
		presetContactList[presetNum1 -1] = presetContactList[presetNum2 - 1];
		presetStringList[presetNum2 - 1] = copy;
		presetContactList[presetNum2 - 1] = copyObj;
		
	}
	
	/**
	 * returns the preset favorite contact in order to call
	 * @param presetNum
	 * @return
	 */
	public Contact getPreset(int presetNum) {
		 return presetContactList[presetNum - 1]; 
	}
	
	/**
	 * formats and returns toString
	 */
	public String toString() {
		String str = "Presets:\n";
		for (int i = 0; i < presetStringList.length; i++) {
			int contactNum = i + 1;
			str += Integer.toString(contactNum) + ". ";
			if (presetStringList[i] == null) {
				str += " \n";
			}
			else {
				str += presetStringList[i] + "\n";
			}
		}
		
		return str;
	}

	public static Contact[] getPresetContactList() {
		
		return presetContactList;
	}
	

}