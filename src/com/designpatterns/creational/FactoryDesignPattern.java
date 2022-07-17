package com.designpatterns.creational;

/* FACTORY DESIGN PATTERN- PROPERTIES

*Creational Design Pattern
*Used when we have multiple sub-classes of Super class & based on input
 we want to return one class instance.
*It provides abstraction between implementation & client classes
*Remove the instantiation of client class from client code

FACTORY DESIGN PATTERN- IMPLEMENTATION

*Super class can be interface or abstract class or basic class
*Factory class has a static method which returns the instance of
 sub-class based on input.

*/
abstract class vehicle{
public abstract int getWheel();

public String toString(){
    return "Wheel :"+this.getWheel();
}
}

class Car extends vehicle{
    int wheel;

    Car(int wheel){
        this.wheel = wheel;
    }
    public int getWheel(){
        return this.wheel;
    }
}

class Bike extends vehicle{
    int wheel;

    Bike(int wheel){
        this.wheel = wheel;
    }
    public int getWheel(){
        return this.wheel;
    }
}

class VehicleFactory{
    public static vehicle getInstance(int wheel, String type){
        if(type=="car"){
            return new Car(wheel);
        }else if(type=="bike"){
            return new Bike(wheel);
        }

        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args){
        vehicle car = VehicleFactory.getInstance(4,"car");
        System.out.println(car.toString());
        vehicle bike = VehicleFactory.getInstance(2, "bike");
        System.out.println(bike.toString());
    }
}
