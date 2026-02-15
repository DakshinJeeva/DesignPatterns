📌 Observer Pattern – README
📖 What is the Observer Pattern?

The Observer Pattern is a behavioral design pattern where:

A Subject maintains a list of dependents (Observers)

Whenever the Subject’s state changes, it notifies all registered Observers automatically

It defines a one-to-many dependency between objects.

One Subject → Many Observers

🎯 Purpose

The Observer Pattern is used to:

Achieve loose coupling

Automatically notify multiple objects about state changes

Implement event-driven systems

Build subscription-based systems

🧠 When to Use Observer Pattern

Use it when:

Multiple objects need to be notified about changes in another object

You want to implement event listeners

You want to reduce tight coupling between classes

You are building:

Notification systems

Chat applications

Stock price trackers

GUI event handling

Real-time data updates

🏗 Structure of Observer Pattern

It consists of four main components:

Observer (Interface)

Subject (Interface)

Concrete Observer

Concrete Subject

🔎 Code Explanation

Below is a breakdown of your implementation.

1️⃣ Main Class
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

What Happens Here?

Admin object is created → Acts as Subject

Three Person objects are created → Act as Observers

A and C subscribe to Admin

B sends a message via Admin

Admin notifies all subscribed persons (A and C)

A and C receive the message

👉 Output:

A received the message & message is hi
C received the message & message is hi

2️⃣ Observer Interface
interface Observer{
    void sendMsg(String message,Subject admin);
    void receiveMsg(String message);
}

Responsibility:

Defines methods that every Observer must implement.

Methods:

sendMsg() → Used to send a message through the Subject

receiveMsg() → Called when the Subject notifies the Observer

3️⃣ Subject Interface
interface Subject{
    void addPerson(Observer p);
    void removePerson(Observer p);
    void notifyAll(String message);
}

Responsibility:

Defines how Observers are managed.

Methods:

addPerson() → Subscribe

removePerson() → Unsubscribe

notifyAll() → Notify all observers

4️⃣ Concrete Observer – Person
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

Responsibilities:

Implements Observer interface

Can send messages via Subject

Receives notifications

Important Concept:

Person does NOT know who else is subscribed.

It only communicates through the Subject.

👉 This ensures loose coupling

5️⃣ Concrete Subject – Admin
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

Responsibilities:

Maintains list of Observers

Registers & removes observers

Sends updates to all observers

Key Point:

Admin does not know implementation details of Person.

It only interacts using the Observer interface.

👉 This follows Dependency Inversion Principle

🔄 How the Flow Works
Person B → calls sendMsg()
         → Admin.notifyAll()
         → Loop through observers
         → Each Observer.receiveMsg()

🧩 Design Principles Used

✅ Loose Coupling

✅ Open/Closed Principle

✅ Dependency Inversion

✅ Single Responsibility

⚖ Advantages

Easy to add new observers

Promotes separation of concerns

Supports broadcast communication

Good for event-driven systems

❌ Disadvantages

Can cause unexpected updates

Debugging can be harder

Memory leaks if observers are not removed

📌 Real-World Analogy

Think of:

YouTube Channel → Subject

Subscribers → Observers

When a new video is uploaded → All subscribers are notified