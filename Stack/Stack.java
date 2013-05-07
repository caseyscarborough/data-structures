import java.util.Arrays;

/**
 * Implementation of a stack data structure.
 * @author Casey Scarborough
 * @version 1.0.0
 * @since 2013-05-05
 */
public class Stack {
	
	/**
	 * Object array to hold the contents of the stack.
	 */
	private Object[] contents;
	
	/**
	 * Keeps track of the current size of the stack.
	 */
	private int size;
	/**
	 * Keeps track of the current index for the top of the stack.
	 */
	private int topOfStack = -1;
	
	/**
	 * Constructor for creating a new stack.
	 * @param size the initial size of the stack.
	 */
	Stack(int size) {
		// Set the size and create a new array
		this.size = size;
		contents = new Object[size];
		// Fill the array with -1s (used to denote empty for output)
		Arrays.fill(contents, "-1");
	}
	
	/**
	 * Pushes an object onto the top of the stack if the stack is not full.
	 * @param o new object to be pushed onto the stack.
	 */
	public void push(Object o) {
		if (topOfStack+1 < size) { // If the stack isn't full
			topOfStack++; // Increment the top and add the object
			contents[topOfStack] = o;
			System.out.println("Input \"" + o + "\" was added to the stack."); 
		} else {
			System.out.println("Unable to push item. The stack is full.");
		}
	}
	
	/**
	 * Removes the object at the top of the stack if the stack is not empty.
	 * @return the removed object, or -1 if the stack is empty.
	 */
	public Object pop() {
		if(topOfStack >= 0) { // If an object exists in the stack, remove the top one
			System.out.println("Item \"" + contents[topOfStack] + "\" was removed from the stack."); 
			contents[topOfStack] = "-1";
			return contents[topOfStack--];
		} else {
			System.out.println("Sorry, but the stack is empty.");
			return "-1";
		}
	}
	
	/**
	 * Gets the item from the top of the stack if it is not empty.
	 * @return the object on the top of the stack, or -1 if the stack is empty.
	 */
	public Object top() {
		if(topOfStack >= 0) { // If an object exists in the stack, return the top one
			System.out.println("Item \"" + contents[topOfStack] + "\" is at the top of the stack.");
			return contents[topOfStack];
		} else {
			System.out.println("Sorry, but the stack is empty.");
			return "-1";
		}
	}
	
	/**
	 * Pushes multiple items onto the stack at once.
	 * @param o array of objects to be pushed onto the stack.
	 */
	public void pushMultiple(Object[] o) {
		// Push every value in the array onto the stack.
		for(int i = 0; i < o.length; i++) {
			push(o[i]);
		}
	}
	
	/**
	 * Removes all items from the stack.
	 */
	public void empty() {
		if(topOfStack >= 0) { // If the stack contains an object
			System.out.println("Emptying stack...");
			// Loop through the stack removing every item.
			for(int i = topOfStack; i >= 0; i--) {
				pop();
			}
			System.out.println("Emptying stack successful!");
		} else {
			System.out.println("The stack is already empty!");
		}
	}
	
	
	/**
	 * Displays the current contents of the stack.
	 */
	public void display(){
		// Determine the max width for the index column
		int index = 0;
		for(int i = 0; i < size; i++) {
			int length = String.valueOf(i).length();
			if (length > index) {
				index = length;
			}
		}
		
		// Determine the max width for the data column
		int data = 0;
		for(int i = 0; i < size; i++) {
			int length = contents[i].toString().length();
			if (length > data) {
				data = length;
			}
		}
		
		// Format the top line in the stack
		System.out.print(" _____");
		for(int i = 0; i < index; i++) System.out.print("_");
		for(int i = 0; i < data; i++) System.out.print("_");
		System.out.println();
		
		// Create format specifiers for the index width and data width
		String index_width = "%-" + index + "s";
		String data_width = "%-" + data + "s";
		
		for(int i = size-1; i >= 0; i--) {
			if (contents[i] != "-1") { // If an object exists, output the data
				System.out.printf("| " + index_width + " | " + data_width +" |\n", i, contents[i]);
			} else { // Output just the index and a blank space
				System.out.printf("| " + index_width + " | " + data_width +" |\n", i, "");
			}
		}
		// Format the bottom line in the stack
		System.out.print("|__");
		for(int i = 0; i < index; i++) System.out.print("_");
		System.out.print("|__");
		for(int i = 0; i < data; i++) System.out.print("_");
		System.out.println("|\n");
	}
	
	public static void main(String[] args) {
		// Create a new stack and push some stuff onto it
		Stack stack = new Stack(6);
		stack.push(8);
		stack.push("Hello there!");
		stack.push(15.23);
		stack.pushMultiple(new Object[]{12/2, "How're you?", 123.321});
		stack.push(new Integer(12));
		
		stack.display();
		
		// Remove most of the items
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(12);
		
		stack.display();
		stack.top();
		
		// Create an object array and push the items onto the stack
		Object[] o = {"Hello", 12, 13.2, "World!"};
		stack.pushMultiple(o);
		stack.display();	
		
		stack.empty();
		System.out.println();
		stack.push(3.14);
		stack.display();	
	}
}