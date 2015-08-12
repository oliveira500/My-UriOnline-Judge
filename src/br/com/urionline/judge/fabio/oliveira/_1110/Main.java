package br.com.urionline.judge.fabio.oliveira._1110;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Fabio Oliveira
 *
 */
public class Main {

    public static void main(final String[] args) {
	final int _50 = 50;
	final int _0 = 0;

	try (Scanner scanner = new Scanner(System.in)) {	    
	    while (scanner != null && scanner.hasNext()) {	
		String result = "";
		final int input = scanner.nextInt();
		if (input == _0 || input > _50) {		    
		    break;
		} else {
		    final LinkedList<Integer> stack = new LinkedList<Integer>();
		    final LinkedList<Integer> discarded = new LinkedList<Integer>();
		    fillStack(input, stack);
		    startOperation(stack, discarded);
		    result = resultFormat(result, stack, discarded);
		    System.out.println(result);
		}
	    }
	    scanner.close();
	}

    }

    private static String resultFormat(String result,
	    final LinkedList<Integer> stack, final LinkedList<Integer> discarded) {
	if (!result.isEmpty()) {
	    result += "\n";
	}
	result += "Discarded cards:";
	for (int i = 0; i < discarded.size(); i++) {
	    result += " " + discarded.get(i);
	    if (i < discarded.size() - 1) {
		result += ",";
	    } else {
		result += "\n";
		result += "Remaining card: " + stack.getFirst();
	    }
	}
	return result;

    }

    private static void startOperation(final LinkedList<Integer> stack,
	    final LinkedList<Integer> discarded) {
	for (int i = stack.size(); i > 1; i--) {
	    discarded.add(stack.getLast());
	    stack.removeLast();
	    stack.addFirst(stack.getLast());
	    stack.removeLast();
	}
    }

    private static void fillStack(final int input,
	    final LinkedList<Integer> stack) {
	for (int i = input; i > 0; i--) {
	    stack.add(i);
	}
    }

}
