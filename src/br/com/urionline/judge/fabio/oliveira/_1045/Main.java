package br.com.urionline.judge.fabio.oliveira._1045;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Fabio Oliveira
 */
public class Main {

    public static void main(final String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner != null && scanner.hasNext()) {
		final String input = scanner.nextLine();
		final String[] textSplited = input.split("\\s");
		if (textSplited != null && textSplited.length == 3) {
		    final double[] sides = parserToDouble(textSplited);
		    Arrays.sort(sides);		    
		    if (sides[2] >= (sides[1] + sides[0])) {
			System.out.println("NAO FORMA TRIANGULO");
		    } else {
			if (Math.pow(sides[2], 2) == (Math.pow(sides[1], 2) + Math
				.pow(sides[0], 2))) {
			    System.out.println("TRIANGULO RETANGULO");
			}
			if (Math.pow(sides[2], 2) > (Math.pow(sides[1], 2) + Math
				.pow(sides[0], 2))) {
			    System.out.println("TRIANGULO OBTUSANGULO");
			}
			if (Math.pow(sides[2], 2) < (Math.pow(sides[1], 2) + Math
				.pow(sides[0], 2))) {
			    System.out.println("TRIANGULO ACUTANGULO");
			}
			if (sides[2] == sides[1] && sides[1] == sides[0]) {
			    System.out.println("TRIANGULO EQUILATERO");
			} else if (sides[2] == sides[1] || sides[2] == sides[0]
				|| sides[1] == sides[0]) {
			    System.out.println("TRIANGULO ISOSCELES");
			}

		    }
		    if (scanner.hasNext()) {
			System.out.println();
		    }
		}
	    }
	    scanner.close();
	}

    }

    private static double[] parserToDouble(final String[] textSplited) {
	final double sides[] = new double[textSplited.length];
	for (int i = 0; i < textSplited.length; i++) {
	    sides[i] = Double.parseDouble(textSplited[i]);
	}
	return sides;
    }
}
