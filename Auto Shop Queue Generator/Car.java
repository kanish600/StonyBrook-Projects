/**
 * Car class
 * @author Anish
 * Contains the make and owner of a car
 */
public class Car {

	private Make make;
	private String owner;
	/**
	 * This is the constructor for the car
	 * @param make The parameter is the enum
	 * @param owner The parameter is the owner in this constructor
	 */
	public Car(Make make, String owner){
		this.make=make;
		this.owner=owner;
	}
	/**
	 * This method is the getter for Make
	 * @return This returns the make
	 */
	public Make getMake() {
		return make;
	}
	/**
	 * This is the new make type
	 * @param make The parameter is the enum
	 */
	public void setMake(Make make) {
		this.make = make;
	}
	/**
	 * This method is the getter for the owner
	 * @return This returns the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * This sets the new owner
	 * @param owner The parameter is owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * This is the toString which returns a statement about the data for this
	 *  class
	 */
	@Override
	public String toString() {
		return "Make is" + make + ", owner is" + owner;
	}
	
	
}
