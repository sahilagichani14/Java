package streams_lamdas_methodreference;

import java.util.Map;

public class Student {
    private String firstname;
    private String subject;
    private Map<String, Integer> grades;

    public Student(String firstname, String subject, Map<String, Integer> grades) {
        this.firstname = firstname;
        this.subject = subject;
        this.grades = grades;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }
}
