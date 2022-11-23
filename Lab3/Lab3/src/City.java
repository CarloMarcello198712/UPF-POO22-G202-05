import java.util.LinkedList;

public class City {
    
    //Atributes
    private String name;
    private Integer population;
    private LinkedList<Headquarter> hqs;

    //Constructor

    public City(String n, Integer p){
        this.name = n;
        this.population = p;
        this.hqs = new LinkedList<Headquarter>();
    }

    public void addHQ(Headquarter h){
        this.hqs.add(h);
    }

    public String toString(){
        return this.name;
    }
    
}
