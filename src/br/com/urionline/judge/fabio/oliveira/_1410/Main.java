package br.com.urionline.judge.fabio.oliveira._1410;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Fabio Oliveira
 */
public class Main {   

    public static final void main(String[] args) throws Exception {
	Scanner scanner = new Scanner(new InputStreamReader(System.in));
	while (true) {
	    int nrAttack = scanner.nextInt();
	    int nrDefense = scanner.nextInt();
	    if ((nrAttack == 0 && nrDefense == 0) || (nrAttack < 2 || nrDefense > 11))
		break;
	    int[] attack = new int[nrAttack], defense = new int[nrDefense];
	    for (int i = 0; i < nrAttack; i++) {
		attack[i] = scanner.nextInt();
	    }
	    for (int j = 0; j < nrDefense; j++) {
		defense[j] = scanner.nextInt();
	    }
	    Arrays.sort(attack);
	    Arrays.sort(defense);
	    if (attack[0] < defense[1]) {
		System.out.println("Y");
	    } else {
		System.out.println("N");
	    }
	}
	scanner.close();
    }
}