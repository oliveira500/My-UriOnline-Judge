package br.com.urionline.judge.fabio.oliveira._1548;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Fabio Oliveira
 */

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		System.in));
	String firstLine = reader.readLine();
	while (firstLine != null && firstLine.trim().length() > 0) {
	    int nrTestCase = Integer.parseInt(firstLine);
	    Integer[] result = new Integer[nrTestCase];
	    for (int i = 0; i < nrTestCase; i++) {
		String students = reader.readLine();
		if (students != null && students.trim().length() > 0) {
		    int nrStudents = Integer.parseInt(students);
		    if (nrStudents >= 1 && nrStudents <= 1000) {
			String[] notes = new String[nrStudents];
			String input = reader.readLine();
			notes = input.split(" ");
			Integer[] notesAux = new Integer[notes.length];
			for (int j = 0; j < notes.length; j++) {
			    notesAux[j] = Integer.parseInt(notes[j]);
			}
			Integer[] decreasing = notesAux.clone();

			Arrays.sort(decreasing, Collections.reverseOrder());
			int count = 0;
			for (int k = 0; k < notesAux.length; k++) {
			    if (notesAux[k] == decreasing[k]) {
				count++;
			    }

			}
			result[i] = count;
		    }

		}
	    }
	    for (int i = 0; i < result.length; i++) {
		System.out.println(result[i]);
	    }
	    firstLine = reader.readLine();
	}
	
    }

}
