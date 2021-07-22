/**
 * Write a fully-documented class named Student that will serve as the stored
 *  element of the Lunar System database. Each Student object includes a webID
 *   and a list of courses the student has taken, and getters and setters for
 *    each. Must implement the Serializable interface.
 * @author Anish
 *
 */
public class Student {

	private String webID;
	private List courses;
	
	public Student(){
		
	}
	
	public Student(String webID, List course){
		this.webID=webID;
		this.courses=courses;
	}
	
	public List getCourses() {
		return courses;
	}
	
	
	public void setCourses(List courses) {
		this.courses = courses;
	}
	
	
	public String getWebID() {
		return webID;
	}
	
	
	public void setWebID(String webID) {
		this.webID = webID;
	}
}
