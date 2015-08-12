package br.com.urionline.judge.fabio.oliveira._1253;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
*
* @author Fabio Oliveira
*/
public class Main {

    public static void main(String[] args) {
	//final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	try (Scanner scanner = new Scanner(System.in)) {
	   while (scanner.hasNext()) {
		    int qtd = scanner.nextInt();
		    int count = 0;
		    List<String> decodeList = new ArrayList<String>();
		    while (scanner.hasNextLine() && count < qtd) {
			final String text = scanner.nextLine();
			final StringBuilder mensagem = new StringBuilder();
			if (scanner.hasNextInt()) {
			    final int deslocamento = scanner.nextInt();
			    if (deslocamento > 0 && deslocamento < 26) {
				for (int i = 0; i < text.length() ; i++) {
				    char c = (char)(text.charAt(i) - deslocamento);
				    mensagem.append(c);
				}
			    }
			    decodeList.add(mensagem.toString());
			    count ++;
			}
			
		    }
		    
		    for (String string : decodeList) {
			System.out.println(string);
		    }

	}
	}

    }

}
