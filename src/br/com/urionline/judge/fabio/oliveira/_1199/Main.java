package br.com.urionline.judge.fabio.oliveira._1199;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 */
public class Main {

    public static void main(final String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner.hasNext()) {
		final String myInput = scanner.nextLine();
		if (myInput != null && !myInput.isEmpty()) {
		    if (myInput.equals("-1")) {
			break;
		    } else if (myInput.contains("0x") || myInput.length() >= 2
			    && myInput.substring(2, 2).equals("x")) {
			System.out.println(Integer.parseInt(
				myInput.substring(2, myInput.length()), 16));
		    } else {
			System.out.println("0x"	+ Integer.toHexString(Integer.parseInt(myInput))
					.toUpperCase());
		    }

		}

	    }
	}

    }

}
