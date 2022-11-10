import java.util.LinkedList;

public class Enrollment {
    //atributes
    private String seminarGroup;
    private Student student;
    private Course course;

    //constructor

    public Enrollment(String sg){
        this.seminarGroup = sg;
    }
    public void addStudent(Student s){
        this.student = s;
    }
    public void addCourse(Course c){
        this.course = c;       
    }

    //Getters

    public Course getCourse(){
        return this.course;
    }

    public String getGroup(){
        return seminarGroup;
    }
    
}
