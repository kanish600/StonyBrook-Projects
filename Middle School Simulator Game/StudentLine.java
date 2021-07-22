import java.util.Arrays;

public class StudentLine {

	private Student[] students;
	private int studentCount;
	final int Capacity = 20;
	
	public StudentLine(){
		students = new Student[20];
		studentCount = 0;
	}
	
	public int numStudents(){
		int counter = 0;
		for (int i = 0; i < students.length; i ++){
		    if (students[i] != null){
		        counter ++;}
		}
		return counter;
	}
	
	public Student getStudent(int index){
		Student s = new Student();
		s = students[index];
		return s;
	}
	
	public Student removeStudent(int index){
		students[index]=null;
		
		for(int i=students.length; i<0;i++){
			if(students[i]==null){
				students[i]=students[i-1];
			}
		}
		return students;
	}
	
	public void addStudent(int index, Student student){
		
	}
	
	public void swapStudents(int index1, int index2){
		
	}
	
	public StudentLine clone(){
		StudentLine other = new StudentLine();
		other.studentCount=studentCount;
		other.students=students;
		return other;
	}
	
	public boolean equals(Object o){
		Student[] s2 = new Student[Capacity];
		boolean copy = true;
		for(int i=0; i < students.length; i++){
			if(s2[i].getMoney()!=students[i].getMoney()){
				copy=false;}
			if(!s2[i].getName().equals(students[i].getName())){
				copy=false;}
			else{
				copy = true;
			}
		}
		return copy;
	}

	@Override
	public String toString() {
		return "students=" + Arrays.toString(students) + ", studentCount=" + studentCount + ", Capacity="
				+ Capacity;
	}
	
	
}
