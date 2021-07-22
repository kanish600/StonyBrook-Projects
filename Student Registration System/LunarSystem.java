import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Write a full-documented class named LunarSystem that will allow the user
 *  to interact with a database of Students. Provide the user with a 
 *  menu-based interface that allows them to add, remove, and edit Students,
 *   as well as their courses. You will need to be able to serialize (save)
 *    the database at the end of the program and deserialize (load) the 
 *    database if a file containing the database already exists. The database
 *     will have a Student’s netID as the key and the associated Student 
 *     object as the value.
 *     
 *     
 * On startup, the LunarSystem should check to see if the file Lunar.ser exists
 *  in the current directory. If it does, then the file should be loaded and
 *   deserialized into the database instance. If the file does not exist, a 
 *   new HashMap should be created and used instead. In either case, the user
 *    should be allowed to fully interact with the LunarSystem without issues.
 * @author Anish
 *
 */

public class LunarSystem {

	private HashMap<String, Student> database;
	
	static HashMap<String, Student> map = new HashMap<String, Student>();
	
	public static void main(String[] args) throws EndOfListException {
		Scanner input=new Scanner(System.in);
		
		System.out.println("Welcome to the Lunar System, a second place course"
				+ " registration system for second rate courses at a second "
				+ "class school.");
		System.out.println("Menu:");
		System.out.println("L)Login");
		System.out.println("X)Save state and quit");
		System.out.println("Q)Quit without saving state.");
		System.out.println(" ");
		
		String webid = "";
		
		boolean run = true;
		while(run){
			
			System.out.println("Please select an option: ");
			String option = input.next();	
			
		switch(option){
		
		case "L":
		case "l":
			
			System.out.println("Please enter webid: ");
			webid = input.next();
			
			if(webid.equalsIgnoreCase("registrar")){
				System.out.println("Welcome Registrar.");
				System.out.println(" ");
				System.out.println("Options: ");
				System.out.println("R) Register a student");
				System.out.println("D) De-register a student");
				System.out.println("E) View course enrollment");
				System.out.println("L) Logout");
				
				boolean runReg = true;
				while(runReg){
					
					System.out.println("Please select an option: ");
					String optionReg = input.next();	
					
				switch(optionReg){
				
				case "R":
				case "r":
					
					System.out.println("Please enter a webid for the new student: ");
					webid=input.next();
					
					Student newStudent = new Student();
					newStudent.setWebID(webid);
					map.put(webid,newStudent);
					
					System.out.println(webid+ " registered.");
					break;
					
				case "D":
				case "d":
					
					System.out.println("Please enter a webid for the student to be deregistered: ");
					webid = input.next();
					map.remove(webid);
					
					System.out.println(webid+ " deregistered.");
					break;
					
				case "E":
				case "e":
					break;
					
				case "L":
				case "l":
					
					System.out.println("Registrar logged out.");
					runReg = false;
					break;
				
				}//switch optionReg
			}//while Registrar	
			}//if registrar
			
			else{
				
				System.out.println("Welcome "+webid);
				
				System.out.println("Options: ");
				System.out.println("A)Add a class");
				System.out.println("D)Drop a class");
				System.out.println("C)View your classes sorted by course name/department");
				System.out.println("S)View your courses sorted by semester");
				System.out.println("L)Logout");
				
				
				boolean runLog = true;
				while(runLog){
					
					System.out.println("Please select an option: ");
					String optionLog = input.next();	
					
				switch(optionLog){
				
				case "A":
				case "a":
					System.out.println("Please enter course name: ");
					String courseName = input.next();
					
					String courseDept = courseName.substring(0, 3);
					String courseNumber = courseName.substring(4, 7);
					int courseNum = Integer.parseInt(courseNumber);
					
					System.out.print("Please select a semester: ");
					String semester = input.next();
					
					
					Course newCourse = new Course(courseDept, courseNum, semester);
					
					map.get(webid).getCourses().appendToTail(newCourse);
					
					System.out.println(courseName+ " added in "+semester);
					break;
					
				case "D":
				case "d":
					
					System.out.println("Please enter course name: ");
					courseName = input.next();
					
					courseDept = courseName.substring(0, 3);
					courseNumber = courseName.substring(4, 7);
					courseNum = Integer.parseInt(courseNumber);
					
					for(int i=0; i<map.get(webid).getCourses().numCourses(); i++){		
						
						if(map.get(webid).getCourses().getCursor().getDepartment().equals(courseDept) && map.get(webid).getCourses().getCursor().getNumber() == courseNum){
							map.get(webid).getCourses().removeCursor();
							map.get(webid).getCourses().resetCursorToHead();
							break;
						}
						else{
							map.get(webid).getCourses().cursorForward();
						}
						
					}
					
					System.out.print(courseName+" dropped.");
					break;
					
				case "l":
				case "L":
					
					System.out.println(webid+ " logged out.");
					runLog = false;
					break;
					
				case "C":
				case "c":
					
					break;
				
			}//switch optionLog
			}//while optionLog
			}//else
			break;//for login
			
			
		}//switch option
		}//while
	}//main
}//class
