//
// Created by Adria Soria Molina on 1/12/22.
//
#include <string>
#include "Vec2D.hpp"
#include "Nameable.hpp"
#include "Comparable.hpp"

#ifndef LAB5_ENTITY_HPP
#define LAB5_ENTITY_HPP

class Entity: public Comparable<Entity>, Nameable {
    private:
        Vec2D * pos;
        std::string name;
        int energy;

    public:
        Entity(Vec2D * p, std::string n, int e) : pos(p), name(n), energy(e){}

        // getters
        std::string getName() { return name; }

        Vec2D * getPosition() {return pos;}

        int getEnergy() {return energy;}

        //setters
        void setPosition(Vec2D * p){
          pos = p;
        }
        void setName(std::string n) {name = n; }

        int compareTo(Entity * e){
          if(e->getEnergy() < energy){
            return 1;
          }else if(e->getEnergy() > energy){
            return -1;
          }
          return 0;
        }

        virtual void update() = 0;
};

#endif //LAB5_ENTITY_HPP
