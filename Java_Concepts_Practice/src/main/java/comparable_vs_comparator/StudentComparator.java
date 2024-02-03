package comparable_vs_comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentComparable> {

	//by marks
	public int compare(StudentComparable o1, StudentComparable o2) {
		//or use name or id
		return (int)(o1.getMarks() - o2.getMarks());
	}

}
