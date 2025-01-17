/**
 * Courses will be associated with the Students that are taking them. Each 
 * course will have a designated department (Ex. �CSE�), a three-digit course
 *  number (Ex. 214), and a semester associated with it (Ex. �F2017�). As 
 *  always, each data field must have getters and setters.
 * @author Anish
 *
 */

public class Course {
	
	private String department;
	private int number;
	private String semester;
	
	public Course(String department, int number, String semester){
		this.department=department;
		this.number=number;
		this.semester=semester;
	}
	
	public String getDepartment() {
		return department;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public String getSemester() {
		return semester;
	}
	
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
}
