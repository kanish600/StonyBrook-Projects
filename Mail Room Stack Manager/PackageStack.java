/**
 * PackageStack must only use stack methods (push, pop, isEmpty, isFull,
 *  and peek), with the exception of printing.
 * @author Anish
 *
 */
public class PackageStack {

	private final int CAPACITY = 7;
	
	LinkList stack = new LinkList();
	
	/**
	 * Pushes x onto the top of the backing data structure.
	 * Throws: FullStackException if the stack is at capacity.
	 * 
	 * @param x the package
	 * @throws FullStackException
	 */
	public void push(Package x) throws FullStackException{
		if(stack.getSize() == CAPACITY){
			throw new FullStackException();
		}
		else{
		stack.insertPack(x);
		}
	}
	
	/**
	 * Removes the topmost package from the stack and returns it.
	 * @return returns the package at the top
	 * @throws EmptyStackException
	 */
	public Package pop() throws EmptyStackException{
		if(stack.getSize()==0){
			throw new EmptyStackException();
		}
		else{
			return stack.deletePack().getData();
		}
	}
	
	/**
	 * Returns the topmost Package from the stack without removing it. 
	 * The stack should be unchanged as a result of this method.
	 * @return returns the stack at the top
	 * @throws EmptyStackException
	 */
	public Package peek() throws EmptyStackException{
		if(stack.getSize()==0){
			throw new EmptyStackException();
		}
		else{
			return stack.getLast();
		}
	}
	
	/**
	 * Returns true if the stack is full, false otherwise.
	 * @return
	 */
	public boolean isFull(){
		if(stack.getSize() == CAPACITY){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Returns true if the stack is empty, false otherwise.
	 * @return
	 */
	public boolean isEmpty(){
		if(stack.getSize() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
