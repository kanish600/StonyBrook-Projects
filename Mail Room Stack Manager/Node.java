/**
 * Node fot the linked list
 * @author Anish
 *
 */
public class Node {

	private Package data;
	private Node next;
	
	/**
	 * consturctor for the node
	 * @param initData
	 */
public Node(Package initData){
		
		if(initData==null){
			throw new IllegalArgumentException();
		}
		
		data = initData;
		next = null;
	}

/**
 * displays the data for the node at the top
 */
public void displayNode() {
    System.out.println(data);
 }

/**
 * getter for the package data
 * @return
 */
public Package getData() {
	return data;
}

/**
 * setter for the package data
 * @param data
 */
public void setData(Package data) {
	this.data = data;
}

/**
 * gets the next package
 * @return
 */
public Node getNext() {
	return next;
}

/**
 * sets the next package
 * @param next
 */
public void setNext(Node next) {
	this.next = next;
}
}
