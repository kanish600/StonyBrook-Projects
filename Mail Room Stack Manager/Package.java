/**
 *  Package represents the mail packages that are being delivered 
 *  and picked up from from the mailroom.
 * @author Anish
 * Contains packages' values
 */
public class Package {

	private String recipient;
	private int arrivalDate;
	private double weight;
	
	/**
	 * Default constructor of the Package class
	 * postcond: This object has been initialized to a package 
	 * object with specified recipient, arrival date and weight.
	 * @param recipient recipient set to null
	 * @param arrivalDate date set to 0
	 * @param weight weight set to 0
	 */
	public Package(String recipient, int arrivalDate, double weight){
		recipient = "";
		arrivalDate = 0;
		weight = 0;
	}

	/**
	 * this method is the getter for the recipient
	 * @return returns name
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * this method is the setter for the name
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * this method is the getter for the arrival date
	 * @return returns date
	 */
	public int getArrivalDate() {
		return arrivalDate;
	}

	
	/**
	 * this method is the setter for the arrival date
	 * @param arrivalDate
	 */
	public void setArrivalDate(int arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * this method is the getter for the weight
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * this method is the setter for the weight
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
