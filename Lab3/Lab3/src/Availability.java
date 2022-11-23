import java.util.LinkedList;

public class Availability {
    
    //Atributes
    private LinkedList<String> days;
    private LinkedList<Integer> hours;

    //Constructor

    public Availability(LinkedList<String> d, LinkedList<Integer> h){
        this.days = d;
        this.hours = h;
    }
    
}
