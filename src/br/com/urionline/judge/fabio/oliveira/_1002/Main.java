package br.com.urionline.judge.fabio.oliveira._1002;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 */
public class Main {

    public static void main(final String[] args) {	
	final double pi = 3.14159D;
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner.hasNext()) {
		final String myInput = scanner.nextLine();
		if (myInput != null && !myInput.isEmpty()) {		    
		    System.out.printf("A=%.4f",(pi * Math.pow(Double.parseDouble(myInput), 2)));
		    System.out.println();
		}
		
	    }
	}    

    }

}
