/**
 * Wraps an Car object to allow it to be inserted into a doubly linked-list 
 * data structure
 * @author Anish
 */
public class CarListNode {

	private Car data;
	private CarListNode next;
	private CarListNode prev;
	/**
	 * Default constructor
	 * Precond: initData is not null
	 * Postcond: This CarListNode has been initialized to wrap the indicated 
	 * Car, and prev and next have been set to null
	 * Throws Exception if initData is null
	 * @param initData parameter is an Object of the Car class
	 */
	public CarListNode(Car initData){
		
		if(initData==null){
			throw new IllegalArgumentException();
		}
		
		data = initData;
		next = null;
		prev = null;
	}
	/**
	 * This method is the getter for the data in the next cursor
	 * @return returns the next data
	 */
	public CarListNode getNext() {
		return next;
	}
	/**
	 * This method sets the data for the next of the cursor
	 * @param next the parameter is the CarListNode next
	 */
	public void setNext(CarListNode next) {
		this.next = next;
	}
	/**
	 * This method is the getter for the data prior to the cursor
	 * @return returns the data prior to the cursor
	 */
	public CarListNode getPrev() {
		return prev;
	}
	/**
	 * This metod is the setter for the previous set of data
	 * @param prev the parmeter is the CarListNode prev
	 */
	public void setPrev(CarListNode prev) {
		this.prev = prev;
	}
	/**
	 * This method is the getter for the data
	 * @return returns the data on the cursor
	 */
	public Car getData() {
		return data;
	}
	/**
	 * this method sets the data
	 * @param data parameter is Car data
	 */
	public void setData(Car data) {
		this.data = data;
	}
	
}
