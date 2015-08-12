package br.com.urionline.judge.fabio.oliveira._1305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Fabio Oliveira
 */

public class Main {

    public static void main(final String[] args) throws IOException {

	final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	while (true) {

	    final String nrReal = bufferedReader.readLine();

	    final String cutOff = bufferedReader.readLine();

	    if (nrReal == null || cutOff == null)
		break;

	    float nrRealAux = Float.parseFloat(nrReal);

	    final float nrDecimalAux = Float.parseFloat(cutOff);

	    if ((nrRealAux - (int) nrRealAux) >= nrDecimalAux) {
		nrRealAux++;
	    }

	    System.out.println((int) nrRealAux);

	}

    }

}
