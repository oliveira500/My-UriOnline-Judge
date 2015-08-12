package br.com.urionline.judge.fabio.oliveira._1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node {
	private final Character data;
	private Node parent;
	private final List<Node> next;

	public Node(Character data) {
	    this.data = data;
	    this.next = new ArrayList<>();
	}

	public void addNext(Node n) {
	    next.add(n);
	    n.parent = this;
	}

	public Character getData() {
	    return data;
	}

	public Node getParent() {
	    return parent;
	}

	public List<Node> getNext() {
	    return next;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Node) {
		Node other = (Node) obj;
		return (data == null && other.data == null)
			|| (data.equals(other.data));
	    }
	    return false;
	}

	@Override
	public String toString() {
	    return data != null ? data.toString() : "[EOT]";
	}

	public void printInto(StringBuilder builder) {
	    builder.append(toString());
	    builder.append("\n");
	    for (Node node : next) {
		node.printInto(builder);
	    }
	}
    }

    static class Tree {
	private final Node root;
	private int size;

	public Tree(Node root) {
	    this.root = root;
	    size = 1;
	}

	public Node getRoot() {
	    return root;
	}

	public boolean isPartOf(String s) {
	    char charAt = s.charAt(0);
	    return root.data.charValue() == charAt;
	}

	public int getSize() {
	    return size;
	}

	public void addData(String s) {
	    char[] chars = s.toCharArray();
	    List<Node> currents = root.getNext();
	    Node currentParent = root;
	    for (int i = 1; i < chars.length; i++) {
		char c = chars[i];
		Node n = new Node(c);
		if (currents.isEmpty()) {
		    currentParent.addNext(n);
		    currentParent = n;
		    currents = currentParent.getNext();
		    // ultimo
		    if (i == chars.length - 1) {
			currentParent.addNext(EOT);
		    }
		    continue;
		}
		boolean worked = false;
		for (Node node : currents) {
		    if (node == EOT) {
			continue;
		    }
		    if (node.data.charValue() == c) {
			currentParent = node;
			currents = currentParent.getNext();
			// ultimo
			if (i == chars.length - 1) {
			    currentParent.addNext(EOT);
			}
			worked = true;
			break;
		    }
		}
		if (!worked) {
		    currentParent.addNext(n);
		    currents = n.getNext();
		    currentParent = n;
		    // ultimo
		    if (i == chars.length - 1) {
			currentParent.addNext(EOT);
		    }
		}
	    }
	    if (s.length() < 2) {
		currentParent.addNext(EOT);
	    }
	    size++;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    root.printInto(sb);
	    return sb.toString();
	}
    }

    // end of tree
    private final static Node EOT = new Node(null);

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		System.in));
	String line = reader.readLine();
	while (line != null && line.trim().length() > 0) {
	    int wordCount = Integer.parseInt(line);
	    String[] words = new String[wordCount];
	    List<Tree> trees = new ArrayList<Tree>();
	    // montar a árvore
	    for (int i = 0; i < wordCount; i++) {
		words[i] = reader.readLine();
		String s = words[i];
		boolean added = false;
		for (Tree tree : trees) {
		    if (tree.isPartOf(s)) {
			tree.addData(s);
			added = true;
			break;
		    }
		}
		if (!added) {
		    Tree newTree = new Tree(new Node(s.charAt(0)));
		    newTree.addData(s);
		    trees.add(newTree);
		}
	    }
	    int keystrokesCount = 0;
	    // verificar a árvore
	    for (int i = 0; i < wordCount; i++) {
		int keystroke = 1;
		String word = words[i];
		char[] chars = word.toCharArray();
		for (Tree tree : trees) {
		    if (tree.isPartOf(word)) {
			Node currentNode = tree.root;
			List<Node> currents = currentNode.next;
			for (int j = 1; j < chars.length; j++) {
			    char c = chars[j];
			    for (Node node : currents) {
				if (node != EOT && c == node.data.charValue()) {
				    if (currents.size() > 1)
					keystroke++;
				    currentNode = node;
				    currents = currentNode.next;
				    break;
				}
			    }
			}
			break;
		    }
		}
		// System.out.println("word: " + word + " keystroke: " +
		// keystroke);
		keystrokesCount += keystroke;
	    }
	    NumberFormat format = DecimalFormat.getInstance();
	    format.setMaximumFractionDigits(2);
	    format.setMinimumFractionDigits(2);
	    double value = keystrokesCount / (wordCount * 1.0);
	    System.out.println(format.format(value));
	    line = reader.readLine();
	}
    }
}
