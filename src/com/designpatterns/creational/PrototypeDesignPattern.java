package com.designpatterns.creational;
/*PROTOTYPE DESIGN PATTERN - PROPERTIES

*Creational Design Pattern
*Used when you want to avoid multiple object creation of same instance;
instead you copy the object to new object & then we can modify as per our need.

PROTOTYPE DESIGN PATTERN - IMPLEMENTATION
*Object which we're copying should provide copying feature by implementing cloneable interface.
*We can override clone() method to implement as per our need.

*/

import java.util.ArrayList;
import java.util.List;

class PdpVehicle implements Cloneable{
    private List<String> vehicleList;

    public PdpVehicle(){
        this.vehicleList = new ArrayList<String>();
    }

    public PdpVehicle(List<String> list){
        this.vehicleList = list;
    }

    public void insertData(){
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }
    public List<String> getVehicleList(){
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList()){
            tempList.add(s);
        }

        return new PdpVehicle(tempList);
    }

}
public class PrototypeDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException{
        PdpVehicle v = new PdpVehicle();
        v.insertData();

        PdpVehicle v1 = (PdpVehicle)v.clone();
        List<String> list = v1.getVehicleList();

        list.add("Ducati Veron");

        System.out.println(v.getVehicleList());
        System.out.println(v1.getVehicleList());
        System.out.println("After modifying the list in first object");
        v.getVehicleList().remove("Hyundai Creta");
        System.out.println(v.getVehicleList());
        System.out.println(v1.getVehicleList());

    }

}
