package listedouble;

public class Node {

	private int element;

	private Node next;
	private Node previous;
	
	public Node(int element, Node next, Node previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
	
	public int getElement() {
		return element;
	}
	
	public Node getNext() {
		return next;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
}
