package com.wcu.cs540.enigma;

/**
 * @author Sourabh
 *
 *	This class provides functionality of Rotor including calculating the
 *  R->L wiring just once
 */
public class Rotor {

	//instance variables
	private int position;  // rotor position	
	public final static int max = 26; // number of alphabets
	// L->R wiring - from constructor parameter
	private char[] leftToRightWiring = new char[max];
	// R->L wiring - generated from R->L wiring
	private char[] rightToLeftWiring = new char[max];

	/**
	 * @param s
	 *      it accepts it's L->R wiring representation. Then calculates
	 *      the R->L wiring to improve time complexity
	 */
	public Rotor(String s) {
		leftToRightWiring = s.toCharArray();
		for (int i = 0; i < max; i++) {
			rightToLeftWiring[leftToRightWiring[i] - 65] = (char) (i + 65);
		}
	}

	/**
	 * @return true if rotor reaches its maximum position else return false
	 */
	public boolean inc() {
		if (position < max - 1) {
			position = (position + 1) % max;
		} else if (position == max - 1) {
			position = (position + 1) % max;
			return true;
		}
		return false;
	}

	public void set(int n) {
		this.position = n;
	}

	/**
	 * @param ch
	 * @return L->R equivalent of character c
	 */
	public char encodeLR(char ch) {
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(ch)) {
			int index = ch - 65;
			index = (index + position) % max;
			return leftToRightWiring[index];
		}
		return ch;
	}

	/**
	 * @param ch
	 * @return R->L equivalent of character c
	 */
	public char encodeRL(char ch) {
		char charReturn = ch;
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(ch)) {
			int index = ch - 65;
			index = rightToLeftWiring[index] - 65;
			
			if (index - position < 0)
				index = max + index - position;
			else
				index = index - position;
			return (char) (index + 65);
		}
		return charReturn;
	}
}
