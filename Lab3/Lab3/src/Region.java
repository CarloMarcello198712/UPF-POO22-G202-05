import java.util.LinkedList;
  

public class Region{
    //Atributes
    private String name;
    private LinkedList<City> cities;

    //Constructor

    public Region(String n){
        this.name = n;
        this.cities = new LinkedList<City>();
    }

    public void setCities(LinkedList<City> c){
        this.cities = c;
    }
    
}