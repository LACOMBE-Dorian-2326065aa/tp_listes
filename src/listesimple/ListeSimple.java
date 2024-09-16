package listesimple;

public class ListeSimple {

	private Node head;
	private long size;
	
	public ListeSimple() {
		head = null;
		size = 0;
	}
	
	public void create(int element) {
		Node node = new Node(element, null);
		if(head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
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
		Node previousNode = null;
		Node currentNode = head;
		while (currentNode != null && currentNode.getElement() != element) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		if(head == currentNode) {
			head = currentNode.getNext();
		} else if (currentNode != null) {
			previousNode.setNext(currentNode.getNext());
		}
		--size;
	}
	
	public void insertStart(int element) {
		Node node = new Node(element, head);
		head = node;
	}
	
	public Node getPenultimate() {
		Node currentNode = head;
		while (currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	public void invert() {
        Node prev = null;
        Node current = head;
        Node next = null;
            
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;            
        }
            
        head = prev; 
     }
	
	public void invertReferences(int element1, int element2) {
	    if (element1 == element2) {
	        return;
	    }

	    Node previousX = null, currentX = head;
	    Node previousY = null, currentY = head;

	    while (currentX != null && currentX.getElement() != element1) {
	        previousX = currentX;
	        currentX = currentX.getNext();
	    }

	    while (currentY != null && currentY.getElement() != element2) {
	        previousY = currentY;
	        currentY = currentY.getNext();
	    }

	    if (currentX == null || currentY == null) {
	        return;
	    }

	    if (previousX != null) {
	        previousX.setNext(currentY);
	    } else {
	        head = currentY;
	    }

	    if (previousY != null) {
	        previousY.setNext(currentX);
	    } else {
	        head = currentX;
	    }

	    Node temp = currentX.getNext();
	    currentX.setNext(currentY.getNext());
	    currentY.setNext(temp);
	}

	
	public static void main(String[] args) {
		
		// Question 1
		
		ListeSimple liste = new ListeSimple();
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
		
		// Question 2
		
		liste.insertStart(98);
		
		liste.read();
		
		// Question 3
		
		System.out.println("Pénultième : " + liste.getPenultimate().getElement());
		
		// Question 4
		
		liste.invert();
		
		liste.read();
		
		// Question 5
		
		liste.invertReferences(1, 98);
		
		liste.read();
	}
	
}
