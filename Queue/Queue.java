package com.caseyscarborough.queue;

/**
 * Implementation of a Queue, a first-in-first-out
 * data structure.
 * @author Casey Scarborough
 * @version 1.0.0
 * @since 2013-05-05
 */
public class Queue {
	
	private Object[] contents;
	private int size;
	private int front, back, numberOfItems = 0;
	
	Queue(int size) {
		this.size = size;
		contents = new Object[size];
		System.out.println("New queue created with size " + size + "!");
	}
	
	public void insert(Object o) {
		if(numberOfItems + 1 <= size) {
			contents[back] = o;
			System.out.println("Input \"" + o + "\" was added to the queue.");
			back++;
			numberOfItems++;
		} else {
			System.out.println("Sorry, but the queue is full.");
		}
	}
	
	public void remove() {
		if(numberOfItems > 0) {
			System.out.println("Item \"" + contents[front] + "\" was removed from the queue.");
			for(int i = 0; i < contents.length-1; i++) {
				contents[i] = contents[i+1];
			} contents[contents.length-1] = "-1";
			back--;
			numberOfItems--;
		} else {
			System.out.println("Sorry, but the queue is empty.");
		}
	}
	
	public void peek() {
		if(numberOfItems > 0) {
			System.out.println("The first element in the queue is \"" + contents[front] + "\".");
		}
	}
	
	public void insertMultiple(Object[] o) {
		for(int i = 0; i < o.length; i++) {
			insert(o[i]);
		}
	}
	
	private int getColumnWidth(int i) {
		int width = String.valueOf(i).length();
		if(contents[i] != null && contents[i] != "-1") {
			if(contents[i].toString().length() > width) {
				width = contents[i].toString().length();
			}
		} else width = 1;
		return width;
	}
	
	private void printLine(String type) {
		for(int i = 0; i < contents.length; i++) {
			if (type == "index")
				System.out.printf("| %-" + getColumnWidth(i) + "s ", i+1);
			else if (type == "data") {
				if(contents[i] != null && contents[i] != "-1")
					System.out.printf("| %-" + getColumnWidth(i) + "s ", contents[i]);
				else
					System.out.printf("| %-" + getColumnWidth(i) + "s ", "");
			}
			else System.out.printf("| %-" + getColumnWidth(i) + "s ", "");
		} System.out.println("|");
	}
	
	public void display() {
		int i = 0;
		for(i = 0; i < contents.length; i++) {
			System.out.print("-");
			for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
			System.out.print("--");
		} System.out.println("-");
		
		printLine("index");
		
		for(i = 0; i < contents.length; i++) {
			System.out.print("-");
			for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
			System.out.print("--");
		} System.out.println("-");
		
		printLine("data");
		
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
