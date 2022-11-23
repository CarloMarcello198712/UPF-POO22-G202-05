import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Headquarter {
   
    //atributes
    private String name;
    private String email;
    private LinkedList<Member> members;
    private Delegate head;
    private LinkedList<InfoAction> actionsParticipated;
    private Organization organization;
    private LinkedList<City> cities;

    //Contructor
    public Headquarter(String n, String e, Organization o){
        this.name = n;
        this.email = e;
        this.organization = o;
        this.actionsParticipated = new LinkedList<InfoAction>();
        this.members = new LinkedList<Member>();
        this.cities = new LinkedList<City>();
    }

    public void addMember(Member m){
        this.members.add(m);
    }

    public void addCity(City c){
        this.cities.add(c);
    }

    public Organization getOrganization(){
        return this.organization;

    }

    public Delegate getHead(){
        return this.head;
    }

    public void addAction(InfoAction a){
        this.actionsParticipated.add(a);
        this.organization.addAction(a.getAction());
    }

    public Action getAction(LocalDateTime d){
        Action action = null;
        for(InfoAction i_action: actionsParticipated){
            if(i_action.getAction().getSchedule().equals(d)){
                action = i_action.getAction();
            }
        }
        return action;
    }

    public void setHead(Delegate d){
        this.head = d;
    }

    public String toString(){
        return this.name;
    }


}

