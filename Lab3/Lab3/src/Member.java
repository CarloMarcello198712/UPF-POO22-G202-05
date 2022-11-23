public class Member {

    //Atributes
    private String name;
    private int phone;
    private String email;
    private Availability available;
    private Headquarter headquarter;

    //Constructor

    public Member(String n, int p, String e, Headquarter h){
        this.name = n;
        this.phone = p;
        this.email = e;
        this.headquarter = h;
    }

    //Setter

    public void setAvailability(Availability a){
        this.available = a;
    }

    //Getter

    public Headquarter getHeadquarter(){
        return this.headquarter;
    }

    public String getName(){
        return this.name;
    }
    
}
