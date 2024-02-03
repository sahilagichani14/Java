package comparable_vs_comparator;

public class StudentComparable implements Comparable<StudentComparable>{

	private int rollno;
	private String name;
	private double marks;
	
	// Implement Comparable interface & override compareTo class to give any 1 field for comparision 
	public int compareTo(StudentComparable o) {
		//return this.name - o.name;
		//return this.marks - o.marks;
		return this.rollno - o.rollno;
	}
	
	//checks by seeing if reference match
	@Override
	public boolean equals(Object obj) {
		
		StudentComparable st = (StudentComparable) obj;
		//this will compare objects & return true if objects have rollno same not reference
		return st.rollno == this.rollno;
	}

	
	public StudentComparable(int rollno, String name, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}


	public int getRollno() {
		return rollno;
	}


	public void setRollno(int rollno) {
		this.rollno = rollno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMarks() {
		return marks;
	}


	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentComparable [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
