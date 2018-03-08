package edu.project3;

public class PresetList {
	//Adds, delete, rearrange, and displays preset list
	//String[] presetStringList = new String[5];
	//Contact[] presetContactList = new Contact[5]; 
	String copy = "";
	Contact copyObj = new Contact();
	
	private Contact[] presetContactList = new Contact[5];
	private String[] presetStringList = new String[5];
	
	public PresetList() {
		
	}
	
	/**
	 * 
	 * @param presetNum
	 * @param contactObj
	 */
	public void addPreset(int presetNum, Contact contactObj) {
		
		presetStringList[presetNum - 1 ] =  contactObj.getName();
		presetContactList[presetNum-1] = contactObj;
		
	}
	
	/**
	 * 
	 * @param presetNum
	 */
	public void deletePreset(int presetNum) {
		presetStringList[presetNum - 1] =  null;
		presetContactList[presetNum-1] = null;
		
	}
	
	/**
	 * 
	 * @param presetNum1
	 * @param presetNum2
	 */
	
	public void rearrangePreset(int presetNum1, int presetNum2) {
		copy = presetStringList[presetNum1 - 1];
		copyObj = presetContactList[presetNum1 - 1];
		presetStringList[presetNum1 -1] = presetStringList[presetNum2 - 1];
		presetContactList[presetNum1 -1] = presetContactList[presetNum2 - 1];
		presetStringList[presetNum2 - 1] = copy;
		presetContactList[presetNum2 - 1] = copyObj;
		
	}
	
	public String toString() {
		String str = "";
		for (String s : presetStringList) {
			str += s;
			str += "\n";
		}
		
		return str;
	}
	

}

