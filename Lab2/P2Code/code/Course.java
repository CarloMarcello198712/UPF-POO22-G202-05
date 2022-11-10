import java.util.LinkedList;

public class Course {

        //atributes

        private String  name;
        private LinkedList<Enrollment> enrollments;
        private LinkedList<Assignment> assignments;
        private LinkedList<Lecture> lectures;


        //Contructor

        public Course(String n){
                this.name = n;
                this.enrollments = new LinkedList<Enrollment>();
                this.assignments = new LinkedList<Assignment>();
                this.lectures = new LinkedList<Lecture>();
        }

        public void addEnrollment(Enrollment e){
                this.enrollments.add(e);
        }

        public void addAssignment(Assignment a){
                this.assignments.add(a);
        }

        public void addLecture(Lecture l){
                this.lectures.add(l);
        }

        public String toString() {
                return this.name;
        }

        //Getters

        public LinkedList<String> getTeachers(){
                LinkedList<String> teachers = new LinkedList<>();
                for(Assignment a : this.assignments){
                        teachers.add(a.getTeacher().toString());
                }
                return teachers;
        }

}
