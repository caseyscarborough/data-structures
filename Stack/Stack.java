package com.caseyscarborough.stack;

import java.util.Arrays;

/**
 * Implementation of a stack data structure.
 * @author Casey Scarborough
 * @version 1.0.0
 * @since 2013-05-05
 */
public class Stack {
	
	private Object[] contents;
	private int size;
	private int topOfStack = -1;
	
	Stack(int size) {
		this.size = size;
		contents = new Object[size];
		Arrays.fill(contents, "-1");
	}
	
	public void push(Object o) {
		if (topOfStack+1 < size) {
			topOfStack++;
			contents[topOfStack] = o;
			System.out.println("Input \"" + o + "\" was added to the stack."); 
		} else {
			System.out.println("Unable to push item. The stack is full.");
		}
	}
	
	public Object pop() {
		if(topOfStack >= 0) {
			System.out.println("Item \"" + contents[topOfStack] + "\" was removed from the stack."); 
			contents[topOfStack] = "-1";
			return contents[topOfStack--];
		} else {
			System.out.println("Sorry, but the stack is empty.");
			return "-1";
		}
	}
	
	public Object top() {
		if(topOfStack >= 0) {
			System.out.println("Item \"" + contents[topOfStack] + "\" is at the top of the stack.");
			return contents[topOfStack];
		} else {
			System.out.println("Sorry, but the stack is empty.");
			return "-1";
		}
	}
	
	public void pushMultiple(Object[] o) {
		for(int i = 0; i < o.length; i++) {
			push(o[i]);
		}
	}
	
	public void empty() {
		System.out.println("Emptying stack...");
		
		for(int i = topOfStack; i >= 0; i--) {
			pop();
		}
		System.out.println("Emptying stack successful!");
	}
	
	public void display(){
		int index = 0;
		for(int i = 0; i < size; i++) {
			int length = String.valueOf(i).length();
			if (length > index) {
				index = length;
			}
		}
		
		int data = 0;
		for(int i = 0; i < size; i++) {
			int length = contents[i].toString().length();
			if (length > data) {
				data = length;
			}
		}
		
		System.out.print(" _____");
		for(int i = 0; i < index; i++) System.out.print("_");
		for(int i = 0; i < data; i++) System.out.print("_");
		System.out.println();
		
		String index_width = "%-" + index + "s";
		String data_width = "%-" + data + "s";
		
		for(int i = size-1; i >= 0; i--) {
			if (contents[i] != "-1") {
				System.out.printf("| " + index_width + " | " + data_width +" |\n", i, contents[i]);
			} else {
				System.out.printf("| " + index_width + " | " + data_width +" |\n", i, "");
			}
		}
		System.out.print("|__");
		for(int i = 0; i < index; i++) System.out.print("_");
		System.out.print("|__");
		for(int i = 0; i < data; i++) System.out.print("_");
		System.out.println("|\n");
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(6);
		stack.push(8);
		stack.push("Hello there!");
		stack.push(15.23);
		stack.pushMultiple(new Object[]{12/2, "How're you?", 123.321});
		stack.push(new Integer(12));
		
		stack.display();
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(12);
		
		stack.display();
		stack.top();
		
		Object[] o = {"Hello", 12, 13.2, "World!"};
		stack.pushMultiple(o);
		stack.display();		
		stack.empty();
		
		System.out.println();
		stack.push(3.14);
		stack.display();
		
	}

}
