import java.util.Scanner;

/**
 * Creates three instances of the CarList class and provides an interface for a user to manipulate the list by adding, and removing Cars.
 * @author Anish
 *
 */
public class OilChangeManager {

	/**
	 * The main method runs a menu driven application which first creates an 
	 * empty CarList and then prompts the user for a menu command selecting 
	 * the operation. The required information is then requested from the user
	 *  based on the selected operation.
	 * @param args Main Method
	 */
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		CarList joe = new CarList();
		CarList donny = new CarList();
		CarList list = null;
		
		System.out.println("Welcome to Tony's Discount Oil Change Computer"
				+ " Management System! It's way better than a rolodex, cork "
				+ "board, post-its, and pre-chewed bubblegum!");
		System.out.println("Menu:");
		System.out.println("L) Edit Job Lists for Joe or Donny");
		System.out.println("M) Merge Job Lists");
		System.out.println("P) Print Job Lists");
		System.out.println("F) Paste car to end of finished car list");
		System.out.println("Q) Quit");
		
		
		boolean run = true;
		while(run){
			
			System.out.println("Please select an option: ");
			String option = input.next();	
			
		switch(option){
		
		case "L":
		case "l":
			
			System.out.println("Please select a list - Joe (J) or Donny (D):");
			String listOption = input.next();
			
			String listName= "";
			
			if(listOption.equals("J")|| listOption.equals("j")){
				list = joe;
				listName.equals("Joe");
			}
			else{
				list = donny;
				listName.equals("Donny");
			}
			
			System.out.println("Options:");
			System.out.println("A) Add a car to the end of the list");
			System.out.println("F) Cursor Forward");
			System.out.println("H) Cursor to Head");
			System.out.println("T) Cursor to Tail");
			System.out.println("B) Cursor Backward");
			System.out.println("I) Insert car before cursor");
			System.out.println("X) Cut car at cursor");
			System.out.println("V) Paste before cursor");
			System.out.println("R) Remove cursor");
			System.out.println("Please select an option: ");
			String optionL = input.next();
			
			switch(optionL){
			
			case "A":
			case "a":
				System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
				String make = input.next();
				System.out.println("Please enter the owner: ");
				String owner = input.next();
				
				
				
				Make carType = Make.valueOf(make.toUpperCase());
				if (carType == null){
					throw new IllegalArgumentException();
				}
				else{
					Car newCar = new Car(carType,owner);
					
					list.appendToTail(newCar);
					
					System.out.println(owner+"'s "+make+" has been scheduled for an oil change with "+listName+" and has been added to his list.");
				}
				break;
				
			case "F":
			case "f":
				
				try {
					list.cursorForward();
				} catch (EndOfListException e) {
					System.out.println("Cursor is already at the end in "+listName+"'s List");
				}
				System.out.println("Cursor Moved Forward in "+listName+"'s List");
				break;
				
			case "H":
			case "h":
				
				list.resetCursorToHead();
				System.out.println("Cursor moved to the head in "+listName+"'s list");
				
				break;
				
			case "T":
			case "t":
				
				list.resetCursorToTail();
				System.out.println("Cursor moved to the tail in "+listName+"'s list");
				
				break;
				
			case "B":
			case "b":
				
				try {
					list.cursorBackward();
				} catch (EndOfListException e) {
					System.out.println("Cursor is already at the end in "+listName+"'s List");
				}
				System.out.println("Cursor Moved Backward in "+listName+"'s List");
				
				break;
				
			case "I":
			case "i":
				System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
				String makeI = input.next();
				System.out.println("Please enter the owner: ");
				String ownerI = input.next();
				
				
				
				Make carTypeI = Make.valueOf(makeI.toUpperCase());
				if (carTypeI == null){
					throw new IllegalArgumentException();
				}
				else{
					Car newCarI = new Car(carTypeI,ownerI);
					
					list.insertBeforeCursor(newCarI);
					
					System.out.println(ownerI+"'s "+makeI+" has been scheduled for an oil change with "+listName+" and has been added to his list before the cursor.");
				}
				break;
				
			case "X":
			case "x":
				break;
				
			case "V":
			case "v":
				break;
				
			case "R":
			case "r":
				
				try {
					list.removeCursor();
				} catch (EndOfListException e) {
					System.out.println("Cursor is empty");
				}
				System.out.println("Car removed at cursor");
				break;
			}
			
			
			break;//break for L
			
		case "M":
		case "m":
			System.out.println("Please select a destination list - Joe (J) "
					+ "or Donny (D): ");
			break;
			
		case "P":
		case "p":
			break;
			
		case "F":
		case "f":
			break;
			
		case "Q":
		case "q":
			System.out.println("Quitting...");
			run = false;
			break;
			
		}//switch
		}//while loop
	}
}
