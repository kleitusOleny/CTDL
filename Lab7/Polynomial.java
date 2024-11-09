package Lab7;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	private LinkedList<Node> expression = new LinkedList<Node>();

	public Polynomial() {

	}

	public Polynomial(LinkedList<Node> expression) {
		for (Node node : expression) {
			this.expression.add(new Node(node));
		}
	}

//Task 1. add a node to the polynomial expression
	public void add(Node node) {
		// TODO
	}

//Task 2. perform the subtraction operator between the polynomial expression and a given node
	public void subtract(Node node) {
		// TODO
	}

//Task 3. perform the addition operator between the current polynomial expression and other
	public Polynomial add(Polynomial other) {
		// TODO
		return null;
	}

// Task 4. perform the subtraction operator between the current polynomial expression and other
	public Polynomial subtract(Polynomial other) {
		// TODO
		return null;
	}

// Task 5. perform the multiplication operator between the current polynomial expression and other
	public Polynomial multiply(Polynomial other) {
		// TODO
		return null;
	}

//display the polynomial expression
	public String toString() {
		String re = "";
		for (Node node : expression) {
			if (node.getExponent() != 0)
				re += node.getCoefficient() + "x^" + node.getExponent() + " ";
			else
				re += node.getCoefficient();
		}
		return re;
	}
}
