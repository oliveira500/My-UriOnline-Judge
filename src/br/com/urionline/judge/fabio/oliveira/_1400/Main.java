package br.com.urionline.judge.fabio.oliveira._1400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String lerLinha;
	static int n, m, k, i, contPalma, nextVlr;
	static StringTokenizer strToken;

	public static void main(String[] args) throws IOException {
		// String myPackage = Main.class.getPackage().getName().replace(".", "/");
		// FileInputStream stream = new FileInputStream("src/" + myPackage + "/inputUri1400.txt");
		// BufferedReader read = new BufferedReader(new InputStreamReader(stream));
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			lerLinha = read.readLine();
			strToken = new StringTokenizer(lerLinha);
			n = Integer.parseInt(strToken.nextToken());
			m = Integer.parseInt(strToken.nextToken());
			k = Integer.parseInt(strToken.nextToken());

			if (n == 0 && m == 0 && k == 0)
				break;

			i = m;
			if (checkSeven(i) == true || (i % 7 == 0))
				contPalma++;

			while (k != contPalma) {

				nextVlr = 2 * (n - m);

				if (nextVlr != 0) {
					i += nextVlr;
					if (checkSeven(i) == true || (i % 7 == 0))
						contPalma++;
				}

				if (k == contPalma)
					break;

				nextVlr = 2 * (m - 1);

				if (nextVlr != 0) {
					i += nextVlr;
					if (checkSeven(i) == true || (i % 7 == 0))
						contPalma++;
				}
			}
			print.write(i + "\n");
			contPalma = 0;
		}
		print.flush();
	}

	public static boolean checkSeven(int vlr) {
		while (vlr > 0) {
			if ((vlr % 10) == 7)
				return true;
			else
				vlr = vlr / 10;
		}
		return false;
	}
}
