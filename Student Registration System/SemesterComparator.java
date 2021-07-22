import java.io.Serializable;
import java.util.Comparator;

/**
 * Write a fully-documented class named Semester that allows us to compare two
 *  courses based on the semester they were offered. The SemesterComparator
 *   class should implement the Comparator interface and override the 
 *   compare method.
 * @author Anish
 *
 */

public class SemesterComparator implements Comparator, Serializable {
	@Override
	public int compare(Object o1, Object o2) {	
		
		Course left = (Course) o1;
		Course right = (Course) o2;
		
		
		return left.getSemester().compareTo(right.getSemester());
	}


}
