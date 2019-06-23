package net.sourceforge.javaqemu.model;

public class JavaQemuUtils {
	private static int countChars(String str, String c) {
		// Source: https://stackoverflow.com/a/8910767
		return str.length() - str.replace(c, "").length();
	}
	
	private static String replaceFirst(String str, String c) {
		int index = str.indexOf(c);
		return str.substring(0, index) + str.substring(index + 1);
	}
	
	// Remove duplicate chars from given string! 
	public static String removeDupChars(String str, String c) {
		System.out.println("Testing removeDupChars...: " + str);
		while (countChars(str, c) > 1) {
			str = replaceFirst(str, c);
			System.out.println("Testing removeDupChars...: " + str);
		}
		
		System.out.println("Testing removeDupChars...: " + str);
		return str;
	}
}
