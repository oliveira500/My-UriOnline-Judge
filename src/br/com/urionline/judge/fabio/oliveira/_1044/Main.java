package br.com.urionline.judge.fabio.oliveira._1044;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {

    public static void main(final String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner != null && scanner.hasNext()) {
		final String input = scanner.nextLine();
		final String[] textSplited = input.split("\\s");
		if (textSplited != null && textSplited.length == 2) {
		    final int valueA = Integer.parseInt(textSplited[0]);
		    final int valueB = Integer.parseInt(textSplited[1]);
		    if (valueB > valueA && valueB % valueA == 0)
			System.out.println("Sao Multiplos");
		    else if (valueA > valueB && valueA % valueB == 0)
			System.out.println("Sao Multiplos");
		    else
			System.out.println("Nao sao Multiplos");

		}
	    }
	    scanner.close();
	}

    }

}
