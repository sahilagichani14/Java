package parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentDB {

    public static List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        for(int i=0; i<1000;i++){
            students.add(new Student(i, "student"+i, "A", Double.valueOf(new Random().nextInt(1000*100))));
        }
        return students;
    }
}
