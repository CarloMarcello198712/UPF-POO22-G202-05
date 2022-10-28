import java.awt.*;
import java.lang.annotation.Target;

public class World {
    
    //Atributes
    private int width;
    private int height;
    private Agent[] agents;
    private int numAgents;
    private int margin;

    //Constructor
    public World(int w, int h){
        width = w;
        height = h;
        margin = 30;
        numAgents = 10;
        agents = new Agent[numAgents];

        //Agent initialisation using 'for'
        for(int i = 0; i < numAgents; i++){
            agents[i] = new Agent(randomPos(),randomRadius());
            agents[i].setTarget(randomPos());
            agents[i].setSpeed(1);
        }
    }

    private Vec2D randomPos(){
        double x = margin + Math.random()*(width - 2 * margin );
        double y = margin + Math.random()*(height - 2 * margin );
        return new Vec2D ( x , y ) ;
    }

    private double randomRadius(){
        return 5 + Math.random()*(margin - 5);
    }

    //Simulation step method
    public void simulationStep(){

        for(int i = 0; i < numAgents; i++){
            
            //Target reached check
            if(agents[i].targetReached() == true){
                agents[i].setTarget(randomPos());
            } else {
                //Collision management by 'for'
                for(int j = 0; j < numAgents; j++){
                    if(j != i){
                        if(agents[i].isColliding(agents[j])){
                            agents[i].setTarget(randomPos());
                        }
                    }
                }
                //Otherwise target is not reached, position update
                agents[i].updatePosition();
            }
        }
    }

    public void paint(Graphics g){
        for(int i = 0; i < numAgents; i++){
            agents[i].paint(g);
        }    
    }

}
