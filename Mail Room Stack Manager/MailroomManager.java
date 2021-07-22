import java.util.Scanner;

/**
 * MailroomManager which contains 6 package stacks for storing mail. Packages
 *  can be added to stacks, removed from stacks, and moved from one stack to 
 *  another. Mail will be stored according to the following criteria: Packages 
 *  whose recipient’s name begins with A-G will be stored in the first stack,
 *   H-J in second, K-M in the third, N-R in the fourth, and S-Z in the fifth.
 *    The sixth stack will serve as the Floor stack, which is used when 
 *    moving packages of a specific recipient.
 * @author Anish
 *
 */
public class MailroomManager {

	/**
	 * The main method runs a menu driven application which allows the user
	 *  to create six instances of the PackageStack class and then prompts
	 *   the user for a menu command selecting the operation. The required
	 *    information is then requested from the user based on the selected
	 *     operation.
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		
		PackageStack firstAG = new PackageStack();
		PackageStack secHJ = new PackageStack();
		PackageStack thirdKM = new PackageStack();
		PackageStack fourthNR = new PackageStack();
		PackageStack fifthSZ = new PackageStack();
		PackageStack floor = new PackageStack();
		PackageStack stack = null;
		
		int stackNum;
		
		int count = 0;
		char firstLet;
		String name = "";
		int ascii;
		
		System.out.println("Welcome to the Irving Mailroom Manager. You can try"
				+ " to make it better, but the odds are stacked against you. "
				+ "It is day 0.");
		System.out.println("Menu:");
		System.out.println("D) Deliver a package");
		System.out.println("G) Get someone's package");
		System.out.println("T) Make it tomorrow");
		System.out.println("P) Print the stacks");
		System.out.println("M) Move a package from one stack to another");
		System.out.println("F) Find packages in the wrong stack and move to "
				+ "floor");
		System.out.println("L) List all packages awaiting a user");
		System.out.println("E) Empty the floor.");
		System.out.println("Q) Quit");
		
		boolean run = true;
		while(run){
			
			System.out.println("Please select an option: ");
			String option = input.next();	
			
		switch(option){
		
		case "D":
		case "d":
			
			System.out.println("Please enter the recipient name: ");
			name = input.next();
			
			firstLet = name.charAt(0);
			
			ascii = firstLet;
			
			if(ascii >= 71){
				stack = firstAG;
			}
			else if(ascii <= 72 && ascii >=74){
				stack = secHJ;
			}
			else if(ascii <= 75 && ascii >=77){
				stack = thirdKM;
			}
			else if(ascii <= 78 && ascii >=82){
				stack = fourthNR;
			}
			else{
				stack = fifthSZ;
			}
			
			System.out.println("Please enter the weight (lbs): ");
			double weight = input.nextDouble();
			
			
			Package newPack = new Package(name,0,weight);
			try {
				stack.push(newPack);
			} catch (FullStackException e) {
				e.printStackTrace();
			}
			
			System.out.println("A "+weight+" lb package is awaiting pickup "
					+ "by"+name);
			break;
			
		case "G":
		case "g":
			
			System.out.println("Please enter the recipient name:");
			name = input.next();
			
			firstLet = name.charAt(0);
			
			ascii = firstLet;
			
			if(ascii >= 71){
				stack = firstAG;
				stackNum = 1;
			}
			else if(ascii <= 72 && ascii >=74){
				stack = secHJ;
				stackNum = 2;
			}
			else if(ascii <= 75 && ascii >=77){
				stack = thirdKM;
				stackNum = 3;
			}
			else if(ascii <= 78 && ascii >=82){
				stack = fourthNR;
				stackNum = 4;
			}
			else{
				stack = fifthSZ;
				stackNum = 5;
			}
			
			Package top = null;
			try {
				top = stack.pop();
			} catch (EmptyStackException e) {
				// TODO Auto-generated catch block
				System.out.println("The stack is empty");
				e.printStackTrace();
				break;
			}
			
			while(!top.getRecipient().equals(name)){
				try {
					floor.push(top);
				} catch (FullStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
			}
			
			System.out.println("Move "+count+" packages from Stack "
					+ ""+stackNum+" to floor");
			
			System.out.println("Give "+name+" "+top.getWeight()+" lb "
					+ "package delivered on day "+top.getArrivalDate());
			
			System.out.println("Return "+count+" packages to Stack "
			+stackNum+" from floor");
			
			while(count!=0){
				try {
					stack.push(floor.pop());
				} catch (FullStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmptyStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
			
		case "T":
		case "t":
			break;
			
		case "P":
		case "p":
			
			
			
			break;
			
		case "M":
		case "m":
			break;
			
		case "F":
		case "f":
			break;
			
		case "L":
		case "l":
			break;
			
		case "E":
		case "e":
			
			while(!floor.isEmpty()){
				try {
					floor.pop();
				} catch (EmptyStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
			
		case "Q":
		case "q":
			System.out.println("Quitting...");
			run = false;
			break;
	}//switch

}//while
}//main
}//class
