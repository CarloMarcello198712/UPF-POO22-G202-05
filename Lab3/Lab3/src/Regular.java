import java.util.LinkedList;

public class Regular extends Member{

    //Atributes
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    //Constructor

    public Regular(String n, int p, String e, Headquarter h, Delegate r){
        super(n, p, e, h);
        this.responsible = r;
        this.vehicles = new LinkedList<Vehicle>();
    }

    public void addVehicle(Vehicle v){
        this.vehicles.add(v);
    }

    public Delegate getResponsible(){
        return this.responsible;
    }
    
}
