/**
 * Simple structure of a node to be stored in a LinkedList.
 * @author Casey Scarborough
 * @since 05-06-2013
 * @see LinkedList, LinkedListIterator
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