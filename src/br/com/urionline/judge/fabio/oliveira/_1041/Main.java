package br.com.urionline.judge.fabio.oliveira._1041;

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
		    String[] inputAux = new String[myInput.length()];
		    inputAux = myInput.split(" ");
		    final double[] coordinate = parserCoordinate(inputAux);
		    if (coordinate[0] == 0 && coordinate[1] != 0) {
			System.out.println("Eixo Y");
		    } else if (coordinate[0] != 0 && coordinate[1] == 0) {
			System.out.println("Eixo X");
		    } else if (coordinate[0] > 0 && coordinate[1] > 0) {
			System.out.println("Q1");
		    } else if (coordinate[0] < 0 && coordinate[1] > 0) {
			System.out.println("Q2");
		    } else if (coordinate[0] < 0 && coordinate[1] < 0) {
			System.out.println("Q3");
		    } else if (coordinate[0] > 0 && coordinate[1] < 0) {
			System.out.println("Q4");
		    } else {
			System.out.println("Origem");
		    }
		}

	    }
	}

    }

    private static double[] parserCoordinate(final String[] inputAux)
	    throws NumberFormatException {
	final double[] coordinate = new double[inputAux.length];
	for (int i = 0; i < inputAux.length; i++) {
	    coordinate[i] = Double.parseDouble(inputAux[i]);
	}
	return coordinate;
    }

}
