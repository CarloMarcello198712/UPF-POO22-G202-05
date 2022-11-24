import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class TestDelegate {

    //Atributes
    private LinkedList<Region> regions;
    private LinkedList<City> cities; //In our implementation we add cities atribute for an easily working of the class relations
    private LinkedList<Delegate> delegates;
    private Organization organization;


    public static void main(String args[]){

        TestDelegate myOrganization = new TestDelegate();


        //4. Increasing the organization structure

        System.out.println( "Head Delegates: "+ myOrganization.organization.getHeadDelegates());
        System.out.print("\n");


        //Now we are going to test if the Qr repartition has been successfully done. To make the checking we will simulate a regular 
        //member signup into their headquarter. So first we load the member qr from their path and then, as we have taken the qr for the
        //Clara Doménech department (first department), we will print the pertinent verification of such a member in an especific
        //headquarter wants to access to their department using his Qr code.

        QRLib q = new QRLib();
        Image image = new Image("QrRegularDataBase/QrRegular for Clara Domènech department.png");//Clara Domènech headquarter regular Qr code
        image.load();

        Delegate delegate = myOrganization.delegates.get(0); //Taking a headquarter delegate (Clara Domènech) to then take a member

        if(delegate.signUpRegular(delegate.getDependents().get(3), q, image)){ //(true)
            System.out.println("Welcome to "+ delegate.getHeadquarter().toString()+" headquarter!"); 
        }else{
            System.out.println("Access denied. Wrong Qr for "+delegate.getHeadquarter().toString()+" headquarter.");
        } 
        System.out.print("\n");

        
        //Currently, we are going to test the same algorythm but with other cases.

        image = new Image("QrRegularDataBase/QrRegular for Oriol Fernandez department.png");//Oriol Fernandez headquarter regular Qr code
        image.load();

        delegate = myOrganization.delegates.get(4); //Taking a headquarter delegate (Pau Muñoz) to then take a member

        if(delegate.signUpRegular(delegate.getDependents().get(3), q, image)){ //(false)
            System.out.println("Welcome to "+ delegate.getHeadquarter().toString()+" headquarter!"); 
        }else{
            System.out.println("Access denied. Wrong Qr for "+delegate.getHeadquarter().toString()+" headquarter.");
        } 
        System.out.print("\n");


        image = new Image("QrRegularDataBase/QrRegular for Lluís Clarà department.png");//Oriol Fernandez headquarter regular Qr code
        image.load();

        delegate = myOrganization.delegates.get(10); //Taking a headquarter delegate (Pau Muñoz) to then take a member

        if(delegate.signUpRegular(delegate.getDependents().get(2), q, image)){ //(true)
            System.out.println("Welcome to "+ delegate.getHeadquarter().toString()+" headquarter!"); 
        }else{
            System.out.println("Access denied. Wrong Qr for "+delegate.getHeadquarter().toString()+" headquarter.");
        } 
        System.out.print("\n");

        //5.Register actions

        myOrganization.organization.printActions();


    }

    private TestDelegate(){

        LinkedList<String[]> _regions = Utility.readXML( "region" );

        this.regions = new LinkedList<Region>();
        this.cities = new LinkedList<City>();


        for (String[] array : _regions){
            Region r = new Region(array[0]);

            LinkedList<City> cities_of_region = new LinkedList<City>();

            int phone_i = (array.length / 2)+1;

            for (int i = 1; i <= array.length/2; i++){
                int x = Integer.parseInt(array[phone_i]);
                City c = new City(array[i],x);
                this.cities.add(c);
                cities_of_region.add(c);
                phone_i++;
            }

            r.setCities(cities_of_region);

            this.regions.add(r);
        }


        //Initalize organitzation with their name, in our case 'Ayuditas'
        this.organization = new Organization("Ayuditas");
       
        //Headquarters initialitzation
        LinkedList<String[]> _headquarters = Utility.readXML( "headquarter");

        LinkedList<Headquarter> headquarters = new LinkedList<Headquarter>(); //new headquarters instance

        for (String[] array : _headquarters){
            Headquarter h = new Headquarter(array[0], array[1], this.organization);

            for(int i = 2; i < array.length; i++){
                City c = Utility.getObject(array[i], this.cities);
                c.addHQ(h); //The city added to the headquarter has this headquarter as atribute too
                h.addCity(c);
            }

            headquarters.add(h);
        }

        this.organization.setPlaces(headquarters); //Organization's headquarters set



        //Delegates inicialitzation

        LinkedList<String[]> _delegates = Utility.readXML( "head");

        this.delegates = new LinkedList<Delegate>();

        for(String[] array : _delegates){
            int x = Integer.parseInt(array[1]);
            Headquarter h = Utility.getObject(array[3], headquarters);
            Delegate d = new Delegate(array[0], x, array[2], h);

            LinkedList<String> days = new LinkedList<String>();
            LinkedList<Integer> hours = new LinkedList<Integer>();

            
            //Days and hours selection and implementation by '.split'
            for(int i = 0; i<=countElements(array[4]); i++){
                String day = array[4].split("\\.")[i]; 
                
                days.add(day);
            }


            for(int i = 0; i<=countElements(array[5]); i++){
                String hour_ = array[5].split("\\.")[i];
                int hour = Integer.parseInt(hour_); 
 
                hours.add(hour);
            }

            Availability availability = new Availability(days, hours);

            d.setAvailability(availability);

            d.getHeadquarter().setHead(d); //From headquarter set delegate as head
            this.delegates.add(d);
        }

        //To check the correct implementation of the Qr verification system we are going to create five members for each 
        //department. Then we will generate each member qr code.
        int i = 0;
        for(Delegate delegate: this.delegates){
            for(int j = 0; j < 5; j++){
                Regular r = new Regular("Member"+i+j, 977126300+(i*10)+j, "member"+i+j+"@ayuditas.cool",delegate.getHeadquarter(),delegate);
                delegate.addDependents(r);
                delegate.getHeadquarter().addMember(r); //Adding member to the headquarer too

                QRLib q = new QRLib();
                delegate.genRegularQR(q);
            }
            i++;
        }

        //Here we will initialize few actions for the actions classes checking. Imagine that ayuditas is an organization that sells school
        //material arround Catalonia.

        LocalDateTime schedule= LocalDateTime.of(2022, 11, 25, 8, 30);
        Action act1 = new Action("Storehouse control",schedule,2);

        schedule = LocalDateTime.of(2022, 11, 26, 11, 00);
        Action act2 = new Action("Stock on shop control",schedule,1);

        schedule = LocalDateTime.of(2022, 11, 27, 16, 15);
        Action act3 = new Action("purchase stock",schedule,1);

        //this.organization.addAction(act1);;
        //this.organization.addAction(act2);
        //this.organization.addAction(act3);

        this.organization.getHeadquarters().get(0).getHead().proposeAction(act1);
        this.organization.getHeadquarters().get(5).getHead().signUpAction(LocalDateTime.of(2022, 11, 25, 8, 30));
        this.organization.getHeadquarters().get(7).getHead().proposeAction(act2);
        this.organization.getHeadquarters().get(9).getHead().proposeAction(act3);

    }


    //Extra method to count days and hours of the XML
    private int countElements(String s){
        int ret = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '.') ret++;
        }
        return ret;
    }
}
