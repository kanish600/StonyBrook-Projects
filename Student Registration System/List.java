public class List {

	private Node head;
	private Node tail;
	private Node cursor;
	private int count;

	/**
	 * Default constructor which initializes this object to an empty list of 
	 * Cars.
	 * Postcond: This CarList has been initialized with head, tail, and cursor 
	 * all set to null
	 */
	public List(){
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * Returns the total number of Cars in the list.
	 * @return return is count
	 */
	public int numCourses(){
		return count;
	}
	
	/**
	 * Gets the reference to the Car wrapped by the CarListNode currently 
	 * referenced by cursor.
	 * 
	 * @return Returns the reference by the Car wrapped by the CarListNode 
	 * currently referenced by cursor. 
	 * If the cursor is null, then this method should return null as well
	 */
	public Course getCursor(){
		if(cursor==null){
			return null;
		}
		
		return cursor.getData();
	}
	
	/**
	 * Returns the cursor to the start of the list.
	 * 
	 * Postcond:
	 * -If head is not null, the cursor now references the first CarListNode 
	 * in this list.
	 * 
	 * -If head is null, the cursor is set to null as well (there are no Cars 
	 * in this list).
	 */
	public void resetCursorToHead(){
		if(head == null){
			cursor = null;
		}
		else{
		cursor = head;
		}
	}
	
	/**
	 * Returns the cursor to the end of the list.
	 * 
	 * Postcond:
	 * -If tail is not null, the cursor now references the last CarListNode 
	 * in this list.
	 * 
	 * -If tail is null, the cursor is set to null as well (there are no Cars 
	 * in this list).
	 */
	public void resetCursorToTail(){
		if(tail == null){
			cursor = null;
		}
		else{
		cursor = tail;
		}
	}
	
	/**
	 * Moves the cursor to select the next CarListNode in the list.
	 * 
	 * @throws EndOfListException If the cursor is at the tail of the list, 
	 * this method throws an exception (this includes the case where cursor and
	 *  tail are both null).
	 */
	public void cursorForward() throws EndOfListException{
		cursor.getNext();
		
		if(cursor==tail){
			throw new EndOfListException();
		}
	}
	
	/**
	 * Moves the cursor to select the previous CarListNode in the list.
	 * 
	 * @throws EndOfListException If the cursor is at the head of the list, 
	 * this method throws an exception (this includes the case where cursor 
	 * and head are both null).
	 */
	public void cursorBackward() throws EndOfListException{
		cursor.getPrev();
		
		if(cursor==head){
			throw new EndOfListException();
		}
	}
	
	/**
	 * Inserts the indicated Car before the cursor.
	 * 
	 * Precond: newCar is not null
	 * 
	 * Postcond:
	 * -newCar has been wrapped in a new CarListNode object.
	 * -If cursor was previously not null, the newly created CarListNode 
	 * has been inserted into the list before the cursor.
	 * -If cursor was previously null, the newly created CarListNode has been 
	 * set as the new head of the list (as well as the tail).
	 * -The cursor remains unchanged.
	 * 
	 * @param newCar parameter is Car newCar
	 */
	public void insertBeforeCursor(Course newCourse){
		if(newCourse == null){
			throw new IllegalArgumentException();
		}
		
		Node node = new Node(newCourse);
		
		if(cursor==null){
			head=node;
			tail=node;
			cursor=node;
		}
		else if(cursor == head){
			cursor.setPrev(node);
			node.setNext(cursor);
			head=node;
		}
		else{
			Node temp = cursor.getPrev();
			
			cursor.setPrev(node);
			node.setNext(cursor);
			temp.setNext(node);
			node.setPrev(temp);
		}
	}
	
	/**
	 * Inserts the indicated Car after the tail of the list.
	 * 
	 * Precond: newCar is not null.
	 * 
	 * Postcond: 
	 * -newCar has been wrapped in a new CarListNode object.
	 * -If tail was previously not null, the newly created CarListNode has 
	 * been inserted into the list after the tail.
	 * -If tail was previously null, the newly created CarListNode has been 
	 * set as the new head of the list (as well as the tail and the cursor).
	 * -The tail now references the newly created CarListNode.
	 * 
	 * @param newCar parameter is Car newCar
	 */
	public void appendToTail(Course newCourse){
		if(newCourse == null){
			throw new IllegalArgumentException();
		}
		
		Node node = new Node(newCourse);
		
		if(cursor==null){
			head=node;
			tail=node;
			cursor=node;
		}
		
		else{
			tail.setNext(node);
			node.setPrev(tail);
			tail=node;
		}
	}
	
	/**
	 * Removes the CarListNode referenced by cursor and returns the Car inside.
	 * 
	 * Precond: cursor is not null
	 * 
	 * Postcond:
	 * -The CarListNode referenced by cursor has been removed from the list.
	 * -All other CarListNodes in the list exist in the same Car as before.
	 * -The cursor now references the previous CarListNode (or the head, if 
	 * the cursor previously referenced the head of the list).
	 * 
	 * @return returns cursors data
	 * 
	 * @throws EndOfListException if cursor is null
	 */
	public Course removeCursor() throws EndOfListException{
		
		if(cursor==null){
			throw new EndOfListException();
		}
		
		else if(cursor==head){
			head = cursor.getNext();
			cursor = head;
			return cursor.getData();
		}
		else if(cursor==tail){
			tail = cursor.getPrev();
			cursor = tail;
			return cursor.getData();
		}
		else{
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor=cursor.getNext();
			return cursor.getData();
		}
	}
}