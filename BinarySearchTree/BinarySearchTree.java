/**
 * Class to implement a binary search tree containing
 * insert, find, remove, and traverse functionality.
 * @author Casey Scarborough
 * @version 1.0.1
 * @since 05-06-13
 */
public class BinarySearchTree {
	/**
	 * Node instance to hold the root of the tree.
	 */
	Node root;
	
	/**
	 * Used to add new nodes into the tree.
	 * @param key the key to be added to the tree
	 * @param value the name (or value) of the key
	 */
	public void addNode(int key, String value) {
		Node newNode = new Node(key, value);
		
		if(root == null) { 
			// If there is no root, create one
			root = newNode;
			System.out.println("Inserted key " + newNode.key + " as the root."); 
		} else { // If root exists, traverse the tree
			// Create a focus node for checking
			Node focusNode = root;
			// Create a parent node
			Node parent;
			while(true) { // Every time through the loop, set parent to focusNode
				parent = focusNode;
				// If the key is less than the current key, move left
				if (key < focusNode.key) {
					// Check set the focusNode equal to it's left child and check if it's null
					focusNode = focusNode.leftChild;
					if (focusNode == null) { // If it is, then create the new node in the tree
						parent.leftChild = newNode;
						System.out.println("Inserted key " + newNode.key); 
						return;
					} // If not, repeat the loop
				} else if (key > focusNode.key){ // If the key is greater, move right
					focusNode = focusNode.rightChild;
					if (focusNode == null) { // If no node exists in that location, create it
						parent.rightChild = newNode;
						System.out.println("Inserted key " + newNode.key); 
						return;
					}
				} else {
					System.out.println("Could not insert duplicate entry.");
					return;
				}
			}
		}
	}
	
	/**
	 * Performs and outputs an in-order traversal on the tree.
	 * @param focusNode the specified node to perform the search from.
	 */
	public void inOrderTraversal(Node focusNode) {
		if(focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			System.out.print(focusNode + " ");
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	/**
	 * Performs and outputs a pre-order traversal on the tree.
	 * @param focusNode the specified node to perform the search from.
	 */
	public void preOrderTraversal(Node focusNode) {
		if(focusNode != null) {
			System.out.print(focusNode + " ");
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
	}
	
	/**
	 * Performs and outputs a post-order traversal on the tree.
	 * @param focusNode the specified node to perform the search from.
	 */
	public void postOrderTraversal(Node focusNode) {
		if(focusNode != null) {
			postOrderTraversal(focusNode.leftChild);
			postOrderTraversal(focusNode.rightChild);
			System.out.print(focusNode + " ");
		}
	}
	
	/**
	 * Performs and outputs a reverse in-order traversal on the tree.
	 * @param focusNode the specified node to perform the search from.
	 */
	public void reverseInOrderTraversal(Node focusNode) {
		if(focusNode != null) {
			reverseInOrderTraversal(focusNode.rightChild);
			System.out.print(focusNode + " ");
			reverseInOrderTraversal(focusNode.leftChild);
		}
	}
	
	/**
	 * Removes a specified node from the tree
	 * @param key the key of the node to be removed.
	 * @return true if the node was removed, false if it was not found.
	 */
	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean isItALeftChild = true;
		
		// Search for the specified key
		while(focusNode.key != key) { // While a match hasn't been found
			parent = focusNode;
			if(key < focusNode.key) { // Check if it goes left or right
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			// If no match was found return false
			if(focusNode == null)
				return false;
		}
		// Otherwise, continue...
		
		// Handle if it does not have children
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if(focusNode == root) {
				root = null; // If it is the root, delete the root
			} // If it is a left child, delete its parent's left child (itself)
			else if (isItALeftChild) { 
				parent.leftChild = null;
			} else { // Same with right
				parent.rightChild = null;
			}
			
		}
		
		// Handle if it only has a left child
		else if (focusNode.rightChild == null) {
			if (focusNode == root) {
				root = focusNode.leftChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.leftChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}
		}
		
		// Handle if it only has a right child
		else if (focusNode.leftChild == null) {
			if (focusNode == root) {
				root = focusNode.rightChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.rightChild;
			} else {
				parent.rightChild = focusNode.rightChild;
			}
		}
		
		// If the node has two children
		else {
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root) {
				root = replacement;
			} else if (isItALeftChild) {
				parent.leftChild = replacement;
			} else {
				parent.rightChild = replacement;
			}
			
			replacement.leftChild = focusNode.leftChild;
		}
		System.out.println("Removed key " + key + ".");
		return true;
	}
	
	/**
	 * Used in the remove method to determine the replacement 
	 * node when the node to be removed has two children.
	 * @param replacedNode the node to be replaced.
	 * @return the replacement node.
	 */
	private Node getReplacementNode(Node replacedNode) {
		
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.rightChild;
		
		while(focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		
		return replacement;
	}
	
	/**
	 * Method used to find a specified node in the tree.
	 * @param key the specified node to search for.
	 * @return the node if it is found, or null if it isn't.
	 */
	public Node findNode(int key) {
		Node focusNode = root;
		
		while(focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.rightChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null) {
				System.out.println("A match was not found."); 
				return null;
			}
		}
		
		System.out.println("A match was found!"); 
		return focusNode;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(1, "1");
		bst.addNode(2, "2");
		bst.addNode(3, "3");
		bst.addNode(4, "4");
		bst.addNode(5, "5");
		bst.addNode(6, "6");
		bst.addNode(7, "7");
		bst.addNode(8, "8");
		System.out.println("\nStarting in-order traversal...");
		bst.inOrderTraversal(bst.root);
		
		System.out.println("\n\nStarting pre-order traversal...");
		bst.preOrderTraversal(bst.root);
		
		System.out.println("\n\nStarting post-order traversal...");
		bst.postOrderTraversal(bst.root);

		System.out.println("\n\nStarting reverse-order traversal...");
		bst.reverseInOrderTraversal(bst.root);
		System.out.println("\n");
		
		System.out.println(bst.findNode(7));
		
		bst.remove(7);
		bst.inOrderTraversal(bst.root);
		
	}

}

/**
 * Class containing the structure for the nodes
 * to be held in the Binary Search Tree.
 * @author Casey Scarborough
 * @since 05-06-2013
 */
class Node {
	
	int key;
	String value;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return "" + key;
	}
}