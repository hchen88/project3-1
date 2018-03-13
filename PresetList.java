package edu.project3;

public class PresetList {
	String copy = "";
	private static Contact[] presetContactList = new Contact[5];
	private static String[] presetStringList = new String[5];
	
	/**
	 * makes preset list object
	 */
	public PresetList() {
		
	}
	
	/**
	 * adds preset to the array
	 * @param presetNum - preset number
	 * @param contactObj - contact object
	 */
	public static void addPreset(int presetNum, Contact contactObj) {
		presetStringList[presetNum - 1 ] =  contactObj.getName();
		presetContactList[presetNum-1] = contactObj;
	}
	
	/**
	 * deletes preset in the array
	 * @param presetNum - preset number
	 */
	public static void deletePreset(int presetNum) {
		presetStringList[presetNum - 1] =  null;
		presetContactList[presetNum-1] = null;
	}
	
	/**
	 * rearranges preset
	 * @param presetNum1 - first preset number
	 * @param presetNum2 - second preset number
	 */
	
	public static void rearrangePreset(int presetNum1, int presetNum2) {
		
		String copy = presetStringList[presetNum1 - 1];
		Contact copyObj = presetContactList[presetNum1 - 1];
		presetStringList[presetNum1 -1] = presetStringList[presetNum2 - 1];
		presetContactList[presetNum1 -1] = presetContactList[presetNum2 - 1];
		presetStringList[presetNum2 - 1] = copy;
		presetContactList[presetNum2 - 1] = copyObj;
		
	}
	
	/**
	 * gets the preset list
	 * @return - the preset list
	 */
	public static Contact[] getPresetContactList() {
		return presetContactList;
	}
	
	/**
	 * Formats the preset list
	 */
	public String toString() {
		String str = "";
		
		for (int i = 0; i < 5; i++) {
			str +=  Integer.toString(i+1 ) + ". " + presetStringList[i] + "\n";
		}
		for (String s : presetStringList) {
			str += s;
			str += "\n";
		}
		
		return str;
	}
}
