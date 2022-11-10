import java.util.LinkedList;

public class Teacher {
    //Atributes

    private String name;
    private LinkedList<Assignment> assignments;

    //Contructor

    public Teacher(String n){
        this.name = n;
        this.assignments = new LinkedList<Assignment>();
    }

    public void addAssignment(Assignment a){
        this.assignments.add(a);
    }

    public String toString() {
        return this.name;
    }

    //Getters

    public LinkedList<Assignment> getAssignments(){
        return this.assignments;
    }

}
