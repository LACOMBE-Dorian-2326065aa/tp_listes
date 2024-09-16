package listedouble;

import listedouble.Node;
import listesimple.ListeSimple;

public class ListeDouble {

	private Node head;
	private long size;
	
	public ListeDouble() {
		head = null;
		size = 0;
	}
	
	public void create(int element) {
		Node node = new Node(element, null, null);
		if(head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			node.setPrevious(currentNode);
		}
		++size;
	}
	
	public void read() {
		Node currentNode = head;
		while (currentNode.getNext() != null) {
			System.out.print(currentNode.getElement() + " > ");
			currentNode = currentNode.getNext();
		}
		System.out.print(currentNode.getElement());
		System.out.println("");
	}
	
	public void update(int previousElement, int newElement) {
		Node currentNode = head;
		while (currentNode != null && currentNode.getElement() != previousElement) {
			currentNode = currentNode.getNext();
		}
		if (currentNode != null) {
			currentNode.setElement(newElement);
		}
	}
	
	public void delete(int element) {
		Node currentNode = head;
		while (currentNode != null && currentNode.getElement() != element) {
			currentNode = currentNode.getNext();
		}
		if(head == currentNode) {
			head = currentNode.getNext();
			currentNode.getNext().setPrevious(null);
		} else if (currentNode != null) {
			currentNode.getPrevious().setNext(currentNode.getNext());
			if (currentNode.getNext() != null) {
				currentNode.getNext().setPrevious(currentNode.getPrevious());
			}
		}
		--size;
	}
	
	public void invertReferences(int element1, int element2) {
		if (element1 == element2) {
			return;
		}
		
		Node node1 = null, node2 = null, currentNode = head;
		
		while (currentNode != null) {
			if (currentNode.getElement() == element1) {
				node1 = currentNode;
			} else if (currentNode.getElement() == element2) {
				node2 = currentNode;
			}
			currentNode = currentNode.getNext();
		}
		
		if (node1 != null && node2 != null) {
			Node prev1 = node1.getPrevious();
			Node next1 = node1.getNext();
			Node prev2 = node2.getPrevious();
			Node next2 = node2.getNext();
			
			if (prev1 != null) {
				prev1.setNext(node2);
			} else {
				head = node2;
			}
			if (next1 != null) {
				next1.setPrevious(node2);
			}
			
			if (prev2 != null) {
				prev2.setNext(node1);
			} else {
				head = node1;
			}
			if (next2 != null) {
				next2.setPrevious(node1);
			}
			
			node1.setPrevious(prev2);
			node1.setNext(next2);
			node2.setPrevious(prev1);
			node2.setNext(next1);
		}
	}
	
	public long count() {
		return size;
	}
	
	public boolean equals(ListeDouble liste2) {
		if (count() != liste2.count())
			return false;
		Node currentNode = head;
		Node currentNode2 = liste2.head;
		while (currentNode != null) {
			if(currentNode.getElement() != currentNode2.getElement())
				return false;
			currentNode = currentNode.getNext();
			currentNode2 = currentNode2.getNext();
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ListeDouble liste = new ListeDouble();
		liste.create(0);
		liste.create(1);
		liste.create(2);
		liste.create(3);
		liste.create(4);
		
		liste.read();
		
		liste.update(2, 42);
		
		liste.read();
		
		liste.delete(42);
		
		liste.read();
		
		liste.delete(0);
		
		liste.read();
		
		liste.delete(4);
		
		liste.read();
		
		liste.create(4);
		
		liste.read();
		
		liste.invertReferences(1, 4);
		
		liste.read();
		
		System.out.println("Nombre : " + liste.count());
		
		ListeDouble liste2 = new ListeDouble();
		liste2.create(4);
		liste2.create(3);
		liste2.create(1);
		
		System.out.println(liste.equals(liste2));
	}
}
