import java.util.LinkedList;

public class Student {
    //atributes

    private String name;
    private int nia;
    private LinkedList<Enrollment> enrollments;

    //Contructor


    public Student(String n, int num){
        this.name = n;
        this.nia = num;
        this.enrollments = new LinkedList<Enrollment>();
    }

    public void addEnrollment(Enrollment e){
        this.enrollments.add(e);
    }

    public String toString() {
        return this.name;
    }

    //Getters

    public LinkedList<String> getCourses(){

        LinkedList<String> courses = new LinkedList<>();
        for(Enrollment e : this.enrollments){
            courses.add(e.getCourse().toString());
        }
        return courses;
    }


}
