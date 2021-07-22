import java.io.Serializable;
import java.util.Comparator;


/**
 * Write a fully-documented class named CourseNameComparator that allows
 *  us to compare two course names with the following priority: department 
 *  and then number. The CourseNameComparator class should implement the
 *   Comparator interface and override the compare method.
 * @author Anish
 *
 */

public class CourseNameComparator implements Comparator, Serializable {
	@Override
	public int compare(Object o1, Object o2) {	
		
		Course left = (Course) o1;
		Course right = (Course) o2;
		
		if(left.getDepartment().equals(right.getDepartment())){
			
			if(left.getNumber() > right.getNumber()){
			return 1;
			}
			else if(left.getNumber() < right.getNumber()){
				return -1;
			}
			else{
				return 0;
			}
		}
		return left.getDepartment().compareTo(right.getDepartment());
	}


}
