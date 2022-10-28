import java.awt.*;

public class Agent {

    //Atributes
    private Vec2D position;
    private double radious;
    private Vec2D direction;
    private Vec2D target;
    private float speed;

    //Constructors
	public Agent(Vec2D initPos, double initRad) { 
        position = initPos; 
        radious = initRad; 
    }

    //Setter
    public void setTarget(Vec2D targ) {
        target = targ;
        direction = new Vec2D(target);
        direction.subtract(position);
        direction.normalize();
    }

    public void setSpeed(float s){
        speed = s;
    }
    //End of setters

    public void updatePosition(){
        //Acceleration = 0, so MRU rules to implement updatePosition
        Vec2D product = new Vec2D(direction.getX() * speed, direction.getY() * speed);
        position.add(product);
    }

    public boolean targetReached(){
        //To check if target is reached it is important to take account of the spheres radious
        Vec2D vec = new Vec2D(target.getX()-position.getX(),target.getY()-position.getY());
        
        if(vec.length() < radious){
            return true;
        }
        return false;
    }

    public void paint(Graphics g) {
		int x = (int)(position.getX() - radious);
		int y = (int)(position.getY() - radious);

        int d = (int)(2*radious);

        g.setColor(Color.RED);
        g.fillOval(x, y, d, d);
	}

    public boolean isColliding(Agent a){
        //Difference between positions
        Vec2D d = new Vec2D(a.position.getX()-position.getX(),a.position.getY()-position.getY());

        //Again, to check if two agents are colliding it is important to take account of the spheres radious
        double sum = a.radious + radious;

        //Checking
        if(sum >= d.length()){
            return true;
        }
        return false;
    }
    
}

