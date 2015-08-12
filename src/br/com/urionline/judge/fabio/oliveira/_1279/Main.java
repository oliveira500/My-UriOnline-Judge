package br.com.urionline.judge.fabio.oliveira._1279;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static boolean isBissexto(final BigInteger ano) {
	return (ano.mod(new BigInteger("4")).equals(BigInteger.ZERO) && (!ano
		.mod(new BigInteger("100")).equals(BigInteger.ZERO) || ano.mod(
		new BigInteger("400")).equals(BigInteger.ZERO)));
    }

    static boolean isHuluculu(final BigInteger ano) {
	return ano.mod(new BigInteger("15")).equals(BigInteger.ZERO);
    }

    static boolean isBulukulu(final BigInteger ano) {
	return ano.mod(new BigInteger("55")).equals(BigInteger.ZERO)
		&& isBissexto(ano);
    }

    public static void main(final String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner != null && scanner.hasNext()) {
		final BigInteger input = scanner.nextBigInteger();
		final BigInteger ano = (input);
		if (isBissexto(ano)) {
		    System.out.println("This is leap year.");
		}
		if (isHuluculu(ano)) {
		    System.out.println("This is huluculu festival year.");
		}
		if (isBulukulu(ano)) {
		    System.out.println("This is bulukulu festival year.");
		}
		if (!isBissexto(ano) && !isHuluculu(ano)) {
		    System.out.println("This is an ordinary year.");
		}
		if (scanner.hasNext()) {
		    System.out.println();
		}
	    }
	    scanner.close();
	}
    }
}
