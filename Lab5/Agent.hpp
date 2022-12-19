//
// Created by Adria Soria Molina on 1/12/22.
//
#include <string>
#include "Vec2D.hpp"
#include "Entity.hpp"

#ifndef LAB5_AGENT_HPP
#define LAB5_AGENT_HPP
class Agent: public Entity {

    private:
        double radious;
        Vec2D direction = Vec2D(0, 0);
        Vec2D * target;
        double speed;

    public:
        //Constructor
        Agent(Vec2D * p, std::string n, int e, float r) : Entity(p, n, e), radious(r){

        }

        //getters
        double getRadious() { return radious; }

        Vec2D * getTarget() {
            return target;
        }

        //setters
        void setDirection(Vec2D v){
          direction = v;
        }

        void setTarget(Vec2D * v) {
          target = v;
          Vec2D aux(target->getX(),target->getY());
          aux.subtract(getPosition());
          aux.normalize();
          setDirection(aux);
        }

        void setSpeed(double s) { speed = s; }

        void update(){
          Vec2D product(direction.getX() * speed, direction.getY() * speed);
          Vec2D * aux(getPosition());
          aux->add(&product);
          setPosition(aux);
        }

        bool targetReached() {
            //To check if target is reached it is important to take account of the spheres radious
            Vec2D vec(target->getX() - getPosition()->getX(), target->getY() -getPosition()->getY());

            if (vec.length() < radious) {
                return true;
            }
            return false;
        }

        bool isColliding(Agent *a) {
            //Difference between positions
            Vec2D d(a->getPosition()->getX() - getPosition()->getX(), a->getPosition()->getY() - getPosition()->getY());

            //Again, to check if two agents are colliding it is important to take account of the spheres radious
            double sum = a->getRadious() + radious;

            //Checking
            if (sum >= d.length()) {
                return true;
            }
            return false;
        }
};

#endif //LAB5_AGENT_HPP