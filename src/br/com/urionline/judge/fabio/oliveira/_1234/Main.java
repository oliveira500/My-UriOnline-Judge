package br.com.urionline.judge.fabio.oliveira._1234;

import java.util.Scanner;

/**
 *
 * @author Fabio Oliveira
 */
public class Main {

    public static void main(String[] args) {

	try (Scanner myInput = new Scanner(System.in)) {
	    while (myInput.hasNext()) {
		String string = myInput.nextLine();

		StringBuilder stringBuilder = new StringBuilder(string);
		boolean myFlag = true;
		for (int index = 0; index < stringBuilder.length(); index++) {
		    if (stringBuilder.charAt(index) == ' ') {
			continue;
		    } else if (myFlag) {
			stringBuilder.setCharAt(index, Character
				.toUpperCase(stringBuilder.charAt(index)));
		    } else {
			stringBuilder.setCharAt(index, Character
				.toLowerCase(stringBuilder.charAt(index)));
		    }
		    myFlag = !myFlag;
		}
		System.out.println(stringBuilder.toString());
	    }
	}

    }

}
