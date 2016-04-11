package br.com.urionline.judge.fabio.oliveira._1161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] linIncial;
	static String lerLinha;

	public static void main(String[] args) throws IOException {
		//String myPackage = Main.class.getPackage().getName().replace(".", "/");
		//FileInputStream stream = new FileInputStream("src/" + myPackage + "/inputUri1161.txt");
		//BufferedReader ler = new BufferedReader(new InputStreamReader(stream));
		BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
		while ((lerLinha = ler.readLine()) != null) {
			linIncial = lerLinha.split(" ");
			long fatorialM = fatorialRecursivo(Long.parseLong(linIncial[0]));
			long fatorialN = fatorialRecursivo(Long.parseLong(linIncial[1]));
			long somaFatorial = fatorialM + fatorialN;
			System.out.println(somaFatorial);
		}
	}

	/*static long fatorialRecursivo(long n) {
		return (n == 0) ? 1 : n * fatorialRecursivo(n - 1);
	}*/
	static long fatorialRecursivo(long n) {
		long fatorial = n;
		if (n == 0)
			return 1;
		
		while (n-- > 1){
			fatorial *= n;
		}
		return fatorial;
	}
}
