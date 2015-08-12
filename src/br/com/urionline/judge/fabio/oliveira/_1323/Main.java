package br.com.urionline.judge.fabio.oliveira._1323;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 */
public class Main {

    public static void main(String[] args)  {
	Scanner scanner = new Scanner(System.in);
	int vetAux[] = new int[101];
	int nrSquare;
	for (nrSquare = 1; nrSquare <= 100; nrSquare++) {
	    vetAux[nrSquare] = vetAux[nrSquare - 1] + nrSquare * nrSquare;
	}
	while (scanner != null) {
	    nrSquare = scanner.nextInt();
	    if (nrSquare == 0)
		break;
	    System.out.println(vetAux[nrSquare]);
	}
	scanner.close();	
    }

}
