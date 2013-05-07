/**
 * Implementation of a Queue, a first-in-first-out data structure.
 * @author Casey Scarborough
 * @version 1.0.0
 * @since 2013-05-05
 */
public class Queue {
	
	/**
	 * An array of objects used to hold the contents of the queue.
	 */
	private Object[] contents;
	
	/**
	 * Keeps track of the size of the queue.
	 */
	private int size;
	
	/**
	 * Keeps track of the first place in the queue, index 0.
	 */
	private int front = 0;
	
	/**
	 * Keeps track of the open space in the back of the queue. 
	 */
	private int back;
	
	/**
	 * Holds the current number of items in the queue.
	 */
	private int numberOfItems = 0;
	
	/**
	 * Constructor for Queue, creates a new queue with its size.
	 * @param size the size to set the new queue to.
	 */
	Queue(int size) {
		this.size = size;
		contents = new Object[size];
		System.out.println("New queue created with size " + size + "!");
	}
	
	/**
	 * Inserts a new object into the queue.
	 * @param o the object to insert.
	 */
	public void insert(Object o) {
		if(numberOfItems + 1 <= size) { // If the queue is not full
			contents[back] = o; // Add the item to the queue
			System.out.println("Input \"" + o + "\" was added to the queue.");
			back++;
			numberOfItems++;
		} else { // If the queue is full
			System.out.println("Sorry, but the queue is full.");
		}
	}
	
	/**
	 * Removes the item at the front of the queue.
	 */
	public void remove() {
		if(numberOfItems > 0) { // If the queue contains items
			System.out.println("Item \"" + contents[front] + "\" was removed from the queue.");
			for(int i = 0; i < contents.length-1; i++) { // Shift everything in the queue left
				contents[i] = contents[i+1];
			} contents[contents.length-1] = null;
			back--;
			numberOfItems--;
		} else { // If it does not contain items
			System.out.println("Sorry, but the queue is empty.");
		}
	}
	
	/**
	 * Outputs the object in the front of the queue.
	 */
	public void peek() {
		if(numberOfItems > 0) { // If the queue contains items
			System.out.println("The first element in the queue is \"" + contents[front] + "\".");
		} else {
			System.out.println("Sorry, but the queue is empty.");
		}
	}
	
	/**
	 * Inserts multiple objects into the queue at once.
	 * @param o the array of objects to be added to the queue.
	 */
	public void insertMultiple(Object[] o) {
		// Loop through the array and insert each object into the queue
		for(int i = 0; i < o.length; i++) {
			insert(o[i]);
		}
	}
	
	/**
	 * Calculates the column width for the table output.
	 * @param i the column number to calculate for
	 * @return number of spaces for column width as an integer.
	 */
	private int getColumnWidth(int i) {
		// Set width to the length of the index
		int width = String.valueOf(i).length();
		// If contents exist, and are wider than the index, set width
		if(contents[i] != null) {
			if(contents[i].toString().length() > width) {
				width = contents[i].toString().length();
			} // If content doesn't exist, width = 1 for one space
		} else width = 1;
		return width;
	}
	
	/**
	 * Prints out either the data or the indices of the queue.
	 * @param type specifies whether to print the indices or the data.
	 */
	private void printLine(String type) {
		for(int i = 0; i < contents.length; i++) {
			if (type == "index") // Print index row
				System.out.printf("| %-" + getColumnWidth(i) + "s ", i+1);
			else if (type == "data") { // Print data row
				if(contents[i] != null) // If data exists
					System.out.printf("| %-" + getColumnWidth(i) + "s ", contents[i]);
				else // If data doesn't exist, print blank space
					System.out.printf("| %-" + getColumnWidth(i) + "s ", "");
			} // If incorrect type specified, print blank space
			else System.out.printf("| %-" + getColumnWidth(i) + "s ", "");
		} System.out.println("|");
	}
	
	/**
	 * Displays the contents of the queue in a table format.
	 * This is a terrible way to output the table I'm sure, but this is
	 * not the purpose of the class.
	 */
	public void display() {
		int i = 0;
		// Output the dashes for table head
		for(i = 0; i < contents.length; i++) {
			System.out.print("-");
			for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
			System.out.print("--");
		} System.out.println("-");
		
		printLine("index");
		
		// Output dashes to separate indices and data
		for(i = 0; i < contents.length; i++) {
			System.out.print("-");
			for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
			System.out.print("--");
		} System.out.println("-");
		
		printLine("data");
		
		// Output dashes for the table bottom
		for(i = 0; i < contents.length; i++) {
			System.out.print("-");
			for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
			System.out.print("--");
		} System.out.println("-");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue queue1 = new Queue(4);
		queue1.insert("Hello");
		queue1.insert(12);
		queue1.insert(13.41);
		queue1.display();
		
		queue1.peek();
		queue1.remove();
		queue1.remove();
		queue1.insert("World");
		queue1.display();
		
		Queue queue2 = new Queue(8);
		queue2.insertMultiple(new Object[]{"String", 3.14, 24, 'c'});
		queue2.display();
		queue2.remove();
		queue2.peek();
	}
}
