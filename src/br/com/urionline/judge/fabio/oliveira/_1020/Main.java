package br.com.urionline.judge.fabio.oliveira._1020;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {

    static boolean isDigit(final String string) {
	boolean isValid = true;
	String aux = string.replaceAll(" ", "");
	for (char character : aux.toCharArray()) {
	    if (!Character.isDigit(character)) {
		isValid = false;
	    }
	}
	return isValid;
    }

    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner != null && scanner.hasNext()) {
		String input = scanner.nextLine();
		if (isDigit(input)) {
		    int value = Integer.parseInt(input);
		    System.out.println(value / 365 + " ano(s)");
		    System.out.println((value % 365) / 30 + " mes(es)");
		    System.out.println((value % 365) % 30 + " dia(s)");

		}
	    }
	    scanner.close();
	}

    }
}
