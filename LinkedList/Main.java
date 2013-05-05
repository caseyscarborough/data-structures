package com.caseyscarborough.linkedlist;
import com.caseyscarborough.linkedlist.LinkedList;
import java.util.Random;

/**
 * Main driver for the linked list and linked list
 * iterator implementation.
 * @author Casey Scarborough
 */
public class Main {
	public static void main(String[] args) {
		// Create a new linked list and iterator
		LinkedList list1 = new LinkedList();
		LinkedListIterator itr;
		Random generator = new Random();
		
		// Set the iterator to the header of the list and print the list
		itr = list1.zeroth();
		list1.printList();

		// Fill the list with 10 random integers between 0 and 20.
		for (int i = 0; i < 10; i++) {
			int randomInt = generator.nextInt(20);
			list1.insert(randomInt, itr);
		}
		
		// Print the list and its size.
		list1.printList();
		System.out.println("Size is: " + list1.listSize());

		// Remove items from the list that are divisible by three.
		for (int i = 0; i < 10; i += 3) {
			list1.remove(new Integer(i));
		}
		
		// Insert two strings into the list.
		list1.insert("World", itr);
		list1.insert("Hello", itr);
		
		// Print the list.
		list1.printList();
		
		// Set the item to remove from the list.
		String itemToRemove = "Hello";
		
		try { // Search the list for Hello and remove it if it exists.
			if (list1.find(itemToRemove) != null) {
				try {
					list1.remove(list1.find(itemToRemove).current.data);
					System.out.println("Item \"" + itemToRemove + "\" removed from list!");
				} catch (Exception e) { 
					System.out.println("Item \"" + itemToRemove + "\" couldn't be removed from list!");
				}
			}
		} catch (NullPointerException e) { // Catch null pointer exception
			System.out.println("The item was not found in the list."); 
		}
		list1.printList();
		
		// Create a second linked list
		LinkedList list2 = new LinkedList();
		list2.printList();
		itr = list2.zeroth();
		
		// Fill the second list with 5 numbers between 30 and 59
		for(int i = 0; i < 5; i++) {
			int randomInt = ((generator.nextInt(60) % 30) + 30);
			list2.insert(randomInt, itr);
		}
		list2.printList();
		
		// Insert the second list into the first list and print the list
		list1.insert(list2, list1.zeroth());
		list1.printList();
	}

}
