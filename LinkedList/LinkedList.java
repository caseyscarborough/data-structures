package com.caseyscarborough.linkedlist;

/**
 * LinkedList class to implement the Node and LinkedListIterator
 * classes. It is implemented using a header node.
 * @author Casey Scarborough
 * @version 1.0.1
 * @since 2013-05-04
 * @see LinkedListIterator
 */
public class LinkedList {
	
	/**
	 * The beginning of the linked list.
	 */
	private Node header;
	
	/**
	 * Create the list using a constructor.
	 */
	public LinkedList() {
		header = new Node(null);
	}

	/**
	 * Checks to see if the list is empty.
	 * @return true if the list is empty.
	 */
	public boolean isEmpty() {
		return header.next == null;
	}

	/**
	 * Makes the list empty.
	 */
	public void makeEmpty() {
		header.next = null;
	}

	/**
	 * @return the iterator for the header node of the list.
	 */
	public LinkedListIterator zeroth() {
		return new LinkedListIterator(header);
	}
	
	
	/**
	 * @return the iterator for the first node in the list.
	 */
	public LinkedListIterator first() {
		return new LinkedListIterator(header.next);
	}

	/**
	 * Inserts a new node after p.
	 * @param x the item to insert.
	 * @param p the position before the one being inserted.
	 */
	public void insert(Object x, LinkedListIterator p) {
		if(p != null && p.current != null) {
			p.current.next = new Node(x, p.current.next);
		}
	}
	
	/**
	 * Returns an iterator that corresponds to the first node
	 * containing an item to search for.
	 * @param x the item to search for.
	 * @return the iterator.
	 */
	public LinkedListIterator find(Object x) {
		Node itr = header.next;
		while(itr != null && !itr.data.equals(x)) {
			itr = itr.next;
		}

		return new LinkedListIterator(itr);
	}
	
	
	/**
	 * Returns an iterator that corresponds to the node before
	 * an item to search for
	 * @param x the item to search for
	 * @return the iterator
	 */
	public LinkedListIterator findPrevious(Object x) {
		Node itr = header;

		while (itr.next != null && !itr.next.data.equals(x)) {
			itr = itr.next;
		}

		return new LinkedListIterator(itr);
	}

	/**
	 * Remove the first occurrence of an item.
	 * @param x the item to be removed.
	 */
	public void remove(Object x) {
		LinkedListIterator p = findPrevious(x);
		if(p.current.next != null) {
			p.current.next = p.current.next.next;
		}
	}
	/**
	 * Simple print method to output the list contents.
	 * If the list contains another list, output that also.
	 */
	public void printList() {
		if (this.isEmpty()) {
			System.out.println("The list is empty."); 
		} else {
			LinkedListIterator itr = this.first();
			for (; itr.isValid(); itr.advance()) {
				// Check if list contains a list, if so call printList() on that list also
				if(itr.retrieve() instanceof LinkedList) {
					// Create a new LinkedList and set it equal to the list item
					LinkedList temp = (LinkedList)itr.retrieve();
					System.out.print("List inside of list: ");
					temp.printList();
				} else { // If the item is not a list
					System.out.print(itr.retrieve() + " ");
				}
			}
			System.out.println("END");
		}
	}
	
	/**
	 * A simple method to retrieve the size of a specified list.
	 * @return size of the list as an integer.
	 */
	public int listSize() {
		LinkedListIterator itr;
		int size = 0;

		for (itr = this.first(); itr.isValid(); itr.advance()) {
			size ++;
		}

		return size;
	}
	
}