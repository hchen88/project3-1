package edu.project3;

public class PresetList {
	//Adds, delete, rearrange, and displays preset list
	//String[] presetStringList = new String[5];
	//Contact[] presetContactList = new Contact[5]; 
	String copy = "";
	private static Contact[] presetContactList = new Contact[5];
	private static String[] presetStringList = new String[5];
	private static FavoriteContactFrame[] presetFrameArray = new FavoriteContactFrame[5]; 
	
	
	public PresetList() {
		
	}
	
	/**
	 * 
	 * @param presetNum
	 * @param contactObj
	 */
	public static void addPreset(int presetNum, Contact contactObj) {
		presetStringList[presetNum - 1 ] =  contactObj.getName();
		presetContactList[presetNum-1] = contactObj;
	
	}
	
	/**
	 * 
	 * @param presetNum
	 */
	public static void deletePreset(int presetNum) {
		presetStringList[presetNum - 1] =  null;
		presetContactList[presetNum-1] = null;
		
	}
	
	/**
	 * 
	 * @param presetNum1
	 * @param presetNum2
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
	 * 
	 * @return
	 */
	public static Contact[] getPresetContactList() {
		return presetContactList;
	}
		
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
