
#include <iostream>
#include "Vec2D.hpp"
#include "Agent.hpp"

int main() {

    //Agent positions
	Vec2D p1(1, 1);
	Vec2D p2(10, 10);

    //Agents set-up
    Agent agent_1(&p1,"Agent 1", 70,4); //Agent 1 has energy 70 and radious 4
    Agent agent_2(&p2,"Agent 2", 20,2);  //Agent 2 has energy 20 and radious 2

    //Agents speed set
    agent_1.setSpeed(1);
    agent_2.setSpeed(5);

    //Agent 1 target set-up
    Vec2D target_1(10, 4);
    agent_1.setTarget(&target_1);


    std::cout << "Agent 1 position: ("<< agent_1.getPosition()->getX() << "," << agent_1.getPosition()->getY() <<"), and target: ("<<agent_1.getTarget()->getX() << "," << agent_1.getTarget()->getY()<<")\n";

    int simulationSteps = 5;
    for(int i = 1; i<=simulationSteps; i++){
        agent_1.update();
        std::cout << "Agent 1 position after "<< i <<" simulation steps: ("<< agent_1.getPosition()->getX() << "," << agent_1.getPosition()->getY() <<")\n";
    }
    std::cout <<"\n";

    //compareTo method test
    switch(agent_1.compareTo(&agent_2))  //agent_1.compareTo(&agent_2) = 1
    {
        case 1:
            std::cout <<agent_1.getName()<<" has more energy than "<<agent_2.getName()<<". \n";
            break;
        case -1:
            std::cout <<agent_1.getName()<<" has less energy than "<<agent_2.getName()<<". \n";
            break;
        case 0:
            std::cout <<agent_1.getName()<<" has the same energy than "<<agent_2.getName()<<". \n";
            break;
        default:
            break;
    }

    //isColliding method test
    if(agent_1.isColliding(&agent_2)){  //false
        std::cout <<agent_1.getName()<<" is colliding with "<<agent_2.getName()<<". \n";
    }else{
        std::cout <<agent_1.getName()<<" is not colliding with "<<agent_2.getName()<<". \n";
    }

    //targetReached method test
    if(agent_1.targetReached()){  //false
        std::cout <<agent_1.getName()<<" has reached the target. \n";
    }else{
        std::cout <<agent_1.getName()<<" has not reached the target. \n";
    }

    //Now we create two more agents colliding
    Vec2D p3(20, 20);
    Vec2D p4(22, 22);

    //Agents set-up
    Agent agent_3(&p3,"Agent 3", 30,3); //Agent 3 has energy 30 and radious 3
    Agent agent_4(&p4,"Agent 4", 100,6);  //Agent 4 has energy 100 and radious 6

    //again, isColliding method test
    if(agent_3.isColliding(&agent_4)){  //true right now
        std::cout <<agent_3.getName()<<" is colliding with "<<agent_4.getName()<<". \n";
    }else{
        std::cout <<agent_3.getName()<<" is not colliding with "<<agent_4.getName()<<". \n";
    }

    //We set agent 3 has reached his target
    Vec2D target_3(20, 20);
    agent_3.setTarget(&target_3);

    //again, targetReached method test
    if(agent_3.targetReached()){ //true right now
        std::cout <<agent_3.getName()<<" has reached the target. \n";
    }else{
        std::cout <<agent_3.getName()<<" has not reached the target. \n";
    }
}

