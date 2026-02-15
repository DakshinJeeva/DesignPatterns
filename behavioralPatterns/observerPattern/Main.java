import java.util.*;

class Main{
    public static void main(String[] args){
        Admin admin = new Admin();
        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        admin.addPerson(a);
        admin.addPerson(c);

        b.sendMsg("hi",admin);
    }
}

interface Observer{
    void sendMsg(String message,Subject admin);
    void receiveMsg(String message);
}

interface Subject{
    void addPerson(Observer p);
    void removePerson(Observer p);
    void notifyAll(String message);
}

class Person implements Observer{
    String name;
    Person(String name){
        this.name = name;
    }
    public void sendMsg(String message,Subject admin){
        admin.notifyAll(message);
    }

    public void receiveMsg(String message){
        System.out.println(name+" received the message & message is "+message);
    }
}

class Admin implements Subject{

    ArrayList<Observer> persons = new ArrayList<>();

    public void addPerson(Observer p){
        persons.add(p);
    }

    public void removePerson(Observer p){
        persons.remove(p);
    }

    public void notifyAll(String message){
        for(Observer person:persons){
            person.receiveMsg(message);
        }
    }

     
}