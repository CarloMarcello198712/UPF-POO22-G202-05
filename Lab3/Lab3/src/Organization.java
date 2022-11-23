import java.time.LocalDateTime;
import java.util.LinkedList;

//import javax.swing.Action;

public class Organization {
    //atributes
    private String name;
    private LinkedList<Headquarter> places;
    private LinkedList<Action> actions;
    
        
        
    //Contructor
    public Organization(String n){
        this.name = n;
        this.places = new LinkedList<Headquarter>();
        this.actions = new LinkedList<Action>();

    }

    public void setPlaces(LinkedList<Headquarter> hs){
        this.places = hs;
    }

    public void addAction(Action a){
        this.actions.add(a);
    }

    public LinkedList<String> getHeadDelegates(){

        LinkedList<String> heads = new LinkedList<String>();

        for (Headquarter headquarter : this.places){
            String d = headquarter.getHead().getName();
            heads.add(d);
        }

        return heads;
    }

    public LinkedList<Headquarter> getHeadquarters(){
        return this.places;
    }

    public Action getAction(LocalDateTime d){

        Action action = null;
        for(Action a: this.actions){
            if(a.getSchedule().equals(d)){
            action = a;
            }
        }
        return action;
    }

    public void printActions(){
        System.out.print("Organization actions are:\n");
        for(Action a: this.actions){
            System.out.print("Purpose: "+a.getPurpose()+"\n");
            System.out.print("Start: "+a.getStart()+"\n");
            System.out.print("Duration: "+a.getDuration()+"\n");
            System.out.print("\n");
        }
    }

}

