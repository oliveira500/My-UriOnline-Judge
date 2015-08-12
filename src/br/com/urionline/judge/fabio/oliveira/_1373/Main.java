package br.com.urionline.judge.fabio.oliveira._1373;

import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {

    public static void main(final String[] args) {
	final Scanner scanner = new Scanner(System.in);
	int k;
	String first, second;
	while (true) {
	    k = scanner.nextInt();
	    if (k == 0)
		break;
	    first = scanner.next();
	    second = scanner.next();
	    System.out.println(longestSubsequence(first, second, k));
	}
	scanner.close();

    }

    private static int longestSubsequence(final String first, final String second, final int k) {
	final String firstAux = "#" + first;
	final String secondAux = "#" + second;
	final int[][] lengths = new int[firstAux.length()][secondAux.length()];
	for (int i = k; i < firstAux.length(); i++) {
	    for (int j = k; j < secondAux.length(); j++) {
		lengths[i][j] = Math.max(lengths[i][j - 1], lengths[i - 1][j]);
		for (int y = 0; y <= i; y++) {
		    if (y >= k)
			lengths[i][j] = Math.max(lengths[i][j],	lengths[i - y][j - y] + y);
		    if (firstAux.charAt(i - y) != secondAux.charAt(j - y))
			break;

		}
	    }
	}
	return lengths[firstAux.length() - 1][secondAux.length() - 1];
    }
}
