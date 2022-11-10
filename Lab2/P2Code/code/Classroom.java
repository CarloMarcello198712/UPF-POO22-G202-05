import java.util.LinkedList;

public class Classroom {

    //atributes

    private String code;
    private LinkedList<Lecture> lectures;

    //Contructor

    public Classroom(String c){
        this.code = c;
        this.lectures = new LinkedList<Lecture>();
    }

    public void addLecture(Lecture l){
        this.lectures.add(l);
    }

    public String toString() {
        return this.code;
    }

    //Getters

    public LinkedList<String> getCourses(){
        LinkedList<String> courses = new LinkedList<>();
        for(Lecture l : this.lectures){
                courses.add(l.getCourse().toString());
        }
        return courses;
    }

    public LinkedList<Lecture> getLectures(){
        return this.lectures;
    }

}
