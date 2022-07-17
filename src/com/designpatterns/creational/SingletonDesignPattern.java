package com.designpatterns.creational;

/* SINGLETON DESIGN PATTERN - IMPLEMENTATION

*Creational Design Pattern
*Constructor should be private
*Public method for returning instance
*Instance type - private static

Initialisation Type:

*Eager Initialisation
*Lazy Initialisation
*Thread Safe Method Initialisation
*Thread safe Block Initialisation

*/
class EagerInitialisation{
    private static EagerInitialisation instance = new EagerInitialisation();

    private EagerInitialisation(){};

    public static EagerInitialisation getInstance(){
        return instance;
    }
}

class LazyInitialisation{
    private static LazyInitialisation instance;

    private LazyInitialisation(){};

    public static LazyInitialisation getInstance(){
       if(instance == null)
           instance = new LazyInitialisation();
        return instance;
    }

}

class ThreadSafeMethodInitialisation{
    private static ThreadSafeMethodInitialisation instance;

    private ThreadSafeMethodInitialisation(){};

    public static synchronized ThreadSafeMethodInitialisation getInstance(){
        if(instance == null){
            instance = new ThreadSafeMethodInitialisation();
        }
        return instance;

    }
}

class ThreadSafeBlockInitialisation{
    private static ThreadSafeBlockInitialisation instance;

    private ThreadSafeBlockInitialisation(){};

    public static ThreadSafeBlockInitialisation getInstance(){
        if (instance == null){
            synchronized (ThreadSafeBlockInitialisation.class){
                instance = new ThreadSafeBlockInitialisation();
            }
        }
        return instance;
    }
}



public class SingletonDesignPattern {


    public static void main(String[] args){
   /* com.designpatterns.creational.EagerInitialisation instance = com.designpatterns.creational.EagerInitialisation.getInstance();
        System.out.println(instance);
    com.designpatterns.creational.EagerInitialisation instance2 =  com.designpatterns.creational.EagerInitialisation.getInstance();
        System.out.println(instance2);*/

     /*com.designpatterns.creational.LazyInitialisation instance = com.designpatterns.creational.LazyInitialisation.getInstance();
     System.out.println(instance);
     com.designpatterns.creational.LazyInitialisation instance2 = com.designpatterns.creational.LazyInitialisation.getInstance();
        System.out.println(instance2);*/

     /*com.designpatterns.creational.ThreadSafeBlockInitialisation instance = com.designpatterns.creational.ThreadSafeBlockInitialisation.getInstance();
     System.out.println(instance);
     com.designpatterns.creational.ThreadSafeBlockInitialisation instance2 = com.designpatterns.creational.ThreadSafeBlockInitialisation.getInstance();
     System.out.println(instance2);*/

        ThreadSafeMethodInitialisation instance = ThreadSafeMethodInitialisation.getInstance();
        System.out.println(instance);
        ThreadSafeMethodInitialisation instance2 = ThreadSafeMethodInitialisation.getInstance();
        System.out.println(instance2);


    }
}
