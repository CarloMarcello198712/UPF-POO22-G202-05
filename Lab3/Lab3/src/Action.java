import java.lang.ProcessHandle.Info;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.xml.crypto.Data;

public class Action{
    //Atributes

    private String purpose;
    private LocalDateTime start;
    private int duration;
    private LinkedList<InfoAction> developedAction;

    //Constructor

    public Action(String p, LocalDateTime s, int d){
        this.purpose = p;
        this.start = s;
        this.duration = d;
        this.developedAction = new LinkedList<InfoAction>();
    }

    public LocalDateTime getSchedule(){
        return this.start;
    }

    public String getPurpose(){
        return this.purpose;
    }

    public LocalDateTime getStart(){
        return this.start;
    }

    public int getDuration(){
        return this.duration;
    }
    
    public void addDevelopedAction(InfoAction dA){
        this.developedAction.add(dA);
    }

    


}
