import java.util.LinkedList;

public class Assignment {
    //atributes

    private LinkedList<String> groups;
    private Teacher teacher;
    private Course course;

    //Contructor

    public Assignment(LinkedList<String> g){
        this.groups = g;
    }

    public void addTeacher(Teacher t){
        this.teacher = t;
    }
    public void addCourse(Course c){
        this.course = c;       
    }

    //Getters

    public Teacher getTeacher(){
        return this.teacher;
    }

    public LinkedList<String> getGroups(){
        return this.groups;
    }
}
