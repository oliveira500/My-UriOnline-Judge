package br.com.urionline.judge.fabio.oliveira._1387;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {
    public static void main(final String[] args) {
	final InputStreamReader inputReader = new InputStreamReader(System.in);
	final Scanner scanner = new Scanner(inputReader);
	while (true) {
	    final int childrens = scanner.nextInt();
	    final int daughters = scanner.nextInt();
	    if (childrens == 0 && daughters == 0)break;
	    System.out.println(childrens + daughters);
	}
	scanner.close();
    }

}
