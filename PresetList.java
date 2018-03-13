package edu.project3;

import java.util.ArrayList;
import java.util.Arrays;

public class PresetList {
	String copy = "";
	private static Contact[] presetContactList = new Contact[5];
	private static ArrayList<String> presetStringList = new ArrayList<String>();

	
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
		presetStringList.add(presetNum - 1, contactObj.getName());
		presetContactList[presetNum-1] = contactObj;
	}
	
	/**
	 * deletes preset in the array
	 * @param presetNum - preset number
	 */
	public static void deletePreset(int presetNum) {
		presetStringList.remove(presetNum);
		presetContactList[presetNum-1] = null;
	}
	
	/**
	 * rearranges preset
	 * @param presetNum1 - first preset number
	 * @param presetNum2 - second preset number
	 */
	
	public static void rearrangePreset(int presetNum1, int presetNum2) {
		
		String copy = presetStringList.get(presetNum1-1); 
		String copy2 = presetStringList.get(presetNum2-1);
		Contact copyObj = presetContactList[presetNum1 - 1];
		presetStringList.remove(presetNum1-1);
		presetStringList.add(presetNum1-1, copy);
		presetStringList.remove(presetNum2-1);
		presetStringList.add(presetNum2 -1, copy2);
		presetContactList[presetNum1 -1] = presetContactList[presetNum2 - 1];
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
		int i = 0;
		str = Arrays.toString(presetStringList.toArray());
		
		for (String s : presetStringList) {
			str += i + ". " + s;  
		}
		return str;
	}
}
