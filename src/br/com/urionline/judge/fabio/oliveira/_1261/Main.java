package br.com.urionline.judge.fabio.oliveira._1261;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {
    public static void main(final String[] args) {

	try (Scanner myInput = new Scanner(System.in)) {

	    final String input = myInput.nextLine();
	    String[] inputsArray = new String[input.length()];
	    inputsArray = input.split(" ");
	    final Integer inputM = new Integer(inputsArray[0]);
	    final Integer inputN = new Integer(inputsArray[1]);
	    final Map<String, Integer> dictionaryHayPoint = new HashMap<String, Integer>();

	    for (int i = 0; i < inputM; i++) {
		if (myInput.hasNext()) {
		    final String inputHayPoint = myInput.nextLine();
		    final String[] inputHayPointArray = inputHayPoint
			    .split(" ");
		    dictionaryHayPoint.put(inputHayPointArray[0],
			    Integer.parseInt(inputHayPointArray[1]));
		}
	    }

	    int count = 0;
	    String word = "";
	    Integer salary = 0;
	    while (myInput.hasNext()) {
		if (!(word = myInput.nextLine()).equals(".")) {
		    final String[] aux = word.split(" ");
		    for (final String string : aux) {
			if (dictionaryHayPoint.containsKey(string)) {
			    salary = salary + dictionaryHayPoint.get(string);
			}
		    }
		} else {
		    count++;
		    System.out.println(salary);
		    salary = 0;
		}
		if (count == inputN) {
		    break;
		}
	    }

	    myInput.close();

	}
    }

}
