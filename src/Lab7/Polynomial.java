package Lab7;

import java.util.Iterator;
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
		if (node.isZeroCoefficient()){
			return;
		}
		ListIterator<Node> iter = this.expression.listIterator();
		while(iter.hasNext()) {
			Node element = iter.next();
			if (element.lessThanExponent(node)) {
				iter.previous();
				iter.add(node);
				return;
			} else if (element.isSameExponent(node)) {
				if (element.getCoefficient() + node.getCoefficient() == 0){
					iter.remove();
				}else{
					element.updateCoefficient(node, 1);
				}
				return;
			}
		}
		iter.add(node);
	}

//Task 2. perform the subtraction operator between the polynomial expression and a given node
	public void subtract(Node node) {
		if (node.isZeroCoefficient()){
			return;
		}
		ListIterator<Node> iter = this.expression.listIterator();
		while(iter.hasNext()) {
			Node element = iter.next();
			if (element.lessThanExponent(node)) {
				iter.previous();
				iter.add(node);
				return;
			} else if (element.isSameExponent(node)) {
				if (element.getCoefficient() - node.getCoefficient() == 0){
					iter.remove();
				}else{
					element.updateCoefficient(node, 2);
				}
				return;
			}
		}
		iter.add(node);
	}

//Task 3. perform the addition operator between the current polynomial expression and other
	public Polynomial add(Polynomial other) {
		ListIterator<Node> iterOther = other.expression.listIterator();
		Polynomial res = new Polynomial(this.expression);
		
		while (iterOther.hasNext()) {
			Node otherElement = iterOther.next();
			res.add(otherElement);
		}
		return res;
	}

// Task 4. perform the subtraction operator between the current polynomial expression and other
	public Polynomial subtract(Polynomial other) {
		ListIterator<Node> iterOther = other.expression.listIterator();
		Polynomial res = new Polynomial(this.expression);
		
		while (iterOther.hasNext()) {
			Node otherElement = iterOther.next();
			res.subtract(otherElement);
		}
		return res;
	}

// Task 5. perform the multiplication operator between the current polynomial expression and other
	public Polynomial multiply(Polynomial other) {
		Polynomial res = new Polynomial();
		for (Node e1 : this.expression){
			for (Node e2 : other.expression){
				int nodeExponent = e1.getExponent() + e2.getExponent();
				int nodeCoefficient = e1.getCoefficient() * e2.getCoefficient();
				Node node = new Node(nodeExponent, nodeCoefficient);
				res.add(node);
			}
		}
		return res;
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
