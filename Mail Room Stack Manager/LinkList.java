/**
 * Linked List class, extends to package stack
 * @author Anish
 *
 */
public class LinkList {

	private Node top;
	private int size;
	
	/**
	 * constructor for linklist
	 */
	public LinkList(){
		top = null;
		size = 0;
	}
	
	/**
	 * insertPack inserts a package to the top of the stack
	 * @param data
	 */
	public void insertPack(Package data) {
	    Node n = new Node(data);
	    n.setNext(top);
	    top = n;
	    size++;
	}
	
	/**
	 * deletes the top most pack
	 * @return
	 */
	public Node deletePack() {
	    Node temp = top;
	    top = top.getNext();
	    size--;
	    return temp;
	}
	
	/**
	 * returns the size fo the stack
	 * @return
	 */
	public int getSize()
    {
        return size;
    } 
	
	/**
	 * returns if the stack is empty
	 * @return
	 */
	public boolean isEmpty() {
	    return (top == null);
	  }
	
	/**
	 * displays the top of the stack
	 */
	public void displayTop() {
	    Node current = top;
	        current.displayNode();
	    }
	
	/**
	 * returns the data of the top most package
	 * @return
	 */
	public Package getLast() {
		return top.getData();
	}
}
