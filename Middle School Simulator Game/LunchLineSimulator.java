import java.util.Scanner;
public class LunchLineSimulator {

	public static void main(String[] args) {
		
		Student student = new Student();
		StudentLine studentLine = new StudentLine();
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Menu:");
		System.out.println("A) Add a student to the line at the end");
		System.out.println("C) Have a new student cut a friend");
		System.out.println("T) Have two students trade places");
		System.out.println("B) Have the bully remove a student");
		System.out.println("U) Update a student's money amount");
		System.out.println("S) Serve a student");
		System.out.println("P) Print the current reality's lunch line");
		System.out.println("O) Switch to the other reality");
		System.out.println("E) Check if the realities are equal");
		System.out.println("D) Duplicate this reality into the other reality");
		System.out.println("Q) Quit middle school and move on to real life.");
		System.out.println("Please select an option: ");
		
		String option=input.next();
		
		switch(option){
		
		case "A":
			System.out.println("Please enter student name: ");
			break;
			
		case "C":
			break;
			
		case "T":
			break;
		
		case "B":
			break;
		
		case "U":
			break;
		
		case "S":
			break;
			
		case "P":
			break;
			
		case "O":
			break;
			
		case "E":
			break;
			
		case "D":
			break;
			
		case "Q":
			System.exit(0);
			break;
		
	}

}
}