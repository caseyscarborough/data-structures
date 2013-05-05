package com.caseyscarborough.linkedlist;

/**
 * Holds the current position of a LinkedList object.
 * Written with help from Mark Allen Weiss at java-tips.org.
 * http://www.java-tips.org/java-se-tips/java.lang/linked-list-implementation-in-java.html
 * 
 * @author Casey Scarborough
 * @see LinkedList
 */
class LinkedListIterator {
	/**
	 * Constructor for the list iterator.
	 * @param theNode any node in the list
	 */
	LinkedListIterator(Node theNode) {
		current = theNode;
	} 

	/**
	 * Test if the position is valid.
	 * @return true if the current position is valid
	 */
	public boolean isValid() {
		return current != null;
	}

	/**
	 * Retrieve data from the list.
	 * @return the data if the position is valid, otherwise null
	 */
	public Object retrieve() {
		return isValid() ? current.data : null;
	}

	/**
	 * Advance to the next node in the list.
	 */
	public void advance() {
		if (isValid()) {
			current = current.next;
		}
	}

	Node current;
}

/**
 * Simple structure of a node to be stored in a LinkedList.
 * @author Casey Scarborough
 */
class Node {
	public Object data;
	public Node next;
	
	public Node(Object d) {
		this(d, null);
	}

	public Node(Object d, Node n) {
		this.data = d;
		this.next = n;
	}
}