
public class Student {

	private String name;
	private double money;
	
	public Student(){
		name="";
		money=0;
	}
	
	public Student(String name, double money){
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public String toString() {
		return name+" "+money;
	}
	
	public boolean equals(Object o){
		Student otherStudent = (Student) o;
		
		if(otherStudent.money!=money)
			return false;
		if(!otherStudent.name.equals(name))
			return false;
		return true;
	}
	
	
}