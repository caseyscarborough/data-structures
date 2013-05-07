Data Structures in Java
=======================

I've created this repository to practice common data structures using Java. I will be implementing each of them, including linked lists, stacks, queues, binary trees, and hash tables.

Linked List Implementation
--------------------------

The linked list implementation is located in the LinkedList directory and contains three relevant classes, along with the accompanying documentation.

The first two classes are LinkedListIterator and Node. The Node class contains the structure for the nodes in the linked list, while the LinkedListIterator class handles keeping track of the current node being operated on in a List.

The LinkedList class contains the data and structure needed for the linked list as well as the operations to be performed on the list, such as inserting, deleting, searching, and printing out the list.

The <code>Main.java</code> file is the main driver for the application, and gives some example usage of the classes. It shows inserting, deleting, searching, and printing from the lists, including inserting a list into another list and retrieving the data.

Binary Search Tree Implementation
---------------------------------

The binary search tree is a little more complex than the others in this list, but has several advantages as well. It performs sorting, searching, and traversing the structure in a very efficient manner.

The implementation contains two classes, Node and BinarySearchTree. Similar to the linked list, the Node class contains the structure to be used for each Node in the Binary Tree. This consists of the data, a pointer to the left child, and a pointer to the right child.

The BinarySearchTree class contains the operations and data needed for a tree to be built and operated on. It contains the root, which is set for the first insert, and can from there be built. It contains methods for adding a node to the tree, removing a node, finding a node and traversing the node. The following depth-first traversals are implemented in the <code>BinarySearchTree.java</code> file:
- In-Order Traversal
- Pre-Order Traversal
- Post-Order Traversal
- Reverse In-Order Traversal

You can read more about the different binary search tree traversals [here](http://en.wikipedia.org/wiki/Tree_traversal#Depth-first). For more information about the supplied implementation, please refer to the given documentation.

Stack Implementation
--------------------

You'll find the stack implementation in the Stack directory. It is a single Java class that contains the functionality needed to create and operate on a stack.

In the <code>Stack.java</code> file, you'll find the Stack class. The Stack class implements six main methods:
- Adding an item to the top of the stack: push()
- Removing the item on top of the stack: pop()
- Peeking at the top of the stack: top()
- Emptying the stack: empty()
- Displaying the stack: display()
- Adding multiple items at once: pushMultiple()

It also includes a main method that instantiates a stack and performs operations on the stack. Refer to the included documentation as well for more in depth explanations of the code.

Queue Implementation
--------------------

Like the previous data structures, the queue is located in its respective directory. The Queue class contains five public methods for the implementation. These are very similar to the methods for the Stack class, and consist of insert(), remove(), peek(), display(), and insertMultiple(). These perform the actions to insert, remove, view the first item in the queue, display the queue, and insert multiple items at once, respectively. The main method is also included in this class with some example uses of the Queue class. The documentation is also included if anything is unclear in the code.


To Do
-----

- [x] Linked List
- [x] Binary Search Tree
- [x] Stack
- [x] Queue
- [&nbsp;&nbsp;] Vector / ArrayList
- [&nbsp;&nbsp;] Hash Table
