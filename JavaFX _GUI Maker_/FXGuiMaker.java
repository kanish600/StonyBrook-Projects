import java.util.Scanner;
/**
 * Takes in a text file, generates a FXComponentTree and provides
 * an interface for a user to manipulate the tree.
 * @author Anish
 *
 */
public class FXGuiMaker {

	
	/**
	 * The main method runs a menu driven application which first creates
	 *  an FXComponentTree based on the passed in file and then prompts the
	 *  user for a menu command selecting the operation. The required 
	 *  information is then requested from the user based on the selected 
	 *  operation. You can find the list of menu options in the UI required
	 *  functions section.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		FXComponentTree tree = new FXComponentTree();
		
		System.out.println("Welcome to counterfeit SceneBuilder.");
		System.out.println("Menu:");
		System.out.println("L) Load from file");
		System.out.println("P) Print tree");
		System.out.println("C) Move cursor to a child node");
		System.out.println("A) Add a child");
		System.out.println("U) Cursor up");
		System.out.println("E) Edit text of cursor");
		System.out.println("D) Delete child");
		System.out.println("R) Move cursor to root");
		System.out.println("S) Save to file");
		System.out.println("Q) Quit");
		System.out.println(" ");
		
		
		boolean run = true;
		while(run){
			
			System.out.println("Please select an option: ");
			String option = input.next();	
			
		switch(option){
		
		case "L":
		case "l":
			
			System.out.println("Please enter filename:");
			String fileName = input.next();
			
			tree = tree.readFromFile(fileName);
			break;
			
			
		case "P":
		case "p":
			
			tree.printTree();
			break;
			
			
		case "C":
		case "c":
			
			System.out.println("Please enter number of child (starting with 1):");
			int childNum = input.nextInt();
			
			tree.cursorToChild(childNum);
			break;
			
			
		case "R":
		case "r":
			
			tree.cursorToRoot();
			break;
			
			
		case "A":
		case "a":
			
			//tree.addChild(index, node);
			break;
			
		
		case "U":
		case "u":
			
			tree.cursorToParent();
			break;
			
			
		case "E":
		case "e":
			
			System.out.println("Please enter new text:");
			String newText = input.next();
			break;
			
			
		case "D":
		case "d":
			break;
			
			
		case "S":
		case "s":
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