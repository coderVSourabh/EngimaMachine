package com.wcu.cs540.enigma;

/**
 * @author Sourabh
 * 
 * 	This is Reflector. Provides the functionality to returns the symmetric
 * 	equivalent of given character
 */
public class Reflector {

	//instance variable
	private String convertString;

	//Parametrised Constructor
	public Reflector(String str) {
		this.convertString = str;
	}

	/**
	 * @param ch
	 * @return the symmetric equivalent from Reflector
	 */
	public char convert(char ch) {
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(ch)) {
			int index = ch - 65;
			return convertString.charAt(index);
		}
		return ch;
	}
}
