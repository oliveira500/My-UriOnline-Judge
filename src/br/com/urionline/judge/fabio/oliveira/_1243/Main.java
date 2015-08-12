/**
 * 
 */
package br.com.urionline.judge.fabio.oliveira._1243;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner != null && scanner.hasNextLine()) {
		final String text = scanner.nextLine();
		final String[] textSplited = text.split("\\s");
		int counterWords = 0;
		int counterLetters = 0;
		final String regex = "^[A-z]+\\.?$";
		for (String word : textSplited) {
		    if (word.matches(regex)) {
			counterWords++;
			word = word.replace(".", "");
			counterLetters += word.toCharArray().length;
		    }
		}
		int width = 0;
		if (counterWords != 0) {
		    width = counterLetters / counterWords;
		}
		if (width <= 3) {
		    System.out.println("250");
		} else if (width == 4 || width == 5) {
		    System.out.println("500");
		} else if (width >= 6) {
		    System.out.println("1000");
		}
	    }
	}
    }

}
