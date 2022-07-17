package com.designpatterns.structural;
/*
PROXY DESIGN PATTERN - PROPERTIES

*Structural Design Pattern
*'used when you want to control access. i.i in databases, you would want to control the 'delete' query available only
for certain users like admin.

PROXY DESIGN PATTERN - IMPLEMENTATION

*IN GENERAL, WE'VE CLASS WHICH IS EXECUTING INTERFACE EXECUTER METHOD, WHICH IS EXECUTING ALL COMMANDS
*To control this, we add a proxy class, which implements the same interface & write the conditions for 'admin' user
before proceeding to actual executer.



*/

interface DatabaseExecuter{
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter{

    @Override
    public void executeDatabase(String query) throws Exception{
        System.out.println("Going to execute Query : "+query);
    }

}

class DatabaseExecuterProxy implements DatabaseExecuter{
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String name, String password){
        if(name.equals("Admin") && password.equals("Admin@123")){
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception{
        if(ifAdmin){
            dbExecuter.executeDatabase(query);
        }else{
            if(query.equals("DELETE"))
                throw new Exception("DETE not allowed for non-admin users");
            else
                dbExecuter.executeDatabase(query);
        }
    }
}
public class ProxyDesignPattenrn {
    public static void main(String[] args) throws Exception {
        /*DatabaseExecuterProxy dbproxy = new DatabaseExecuterProxy("Admin", "Admin@123");
        dbproxy.executeDatabase("DELETE");*/

        DatabaseExecuterProxy dbproxy = new DatabaseExecuterProxy("User", "Admin@123");
        dbproxy.executeDatabase("DELETE");
    }
}
