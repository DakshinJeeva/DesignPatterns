Strategy Design Pattern
📌 Overview

The Strategy Pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one, and make them interchangeable at runtime.

Instead of using large if-else or switch statements, Strategy Pattern delegates the behavior to separate classes.

It follows:

✅ Open/Closed Principle

✅ Single Responsibility Principle

✅ Runtime behavior switching

🎯 What Problem Does It Solve?

When:

You have multiple ways to perform the same task

You want to avoid large conditional statements

You want to change behavior at runtime

You want cleaner, more maintainable code

Instead of this:

if(type.equals("UPI")) { ... }
else if(type.equals("CreditCard")) { ... }
else if(type.equals("PayPal")) { ... }


We encapsulate each behavior into separate classes.

🧠 When To Use Strategy Pattern

Use Strategy Pattern when:

Multiple algorithms exist for the same operation

Behavior must change dynamically at runtime

You want to follow Open/Closed Principle

You want to remove conditional complexity

You want loosely coupled design

🏗 Structure of Strategy Pattern

Strategy Pattern consists of:

Strategy Interface

Concrete Strategy Classes

Context Class

Client Code

💻 Implementation Explanation

Below is the implementation:

interface Pay{
    void pay();
}

class CreditCard implements Pay{
    public void pay(){
        System.out.println("Payment is Done using Credit Card");
    }
}

class UPI implements Pay{
    public void pay(){
        System.out.println("Payment is Done using UPI");
    }
}

class PayPal implements Pay{
    public void pay(){
        System.out.println("Payment is Done using PayPal");
    }
}

class Context{
    private Pay pay;

    Context(Pay pay){
        this.pay = pay;
    }

    void processPayment(){
        pay.pay();
    }
}

class Main{
    public static void main(String[] args){
        Context context = new Context(new UPI());
        context.processPayment();
        context = new Context(new PayPal());
        context.processPayment();
        context = new Context(new CreditCard());
        context.processPayment();
    }
}

🔎 Component Breakdown
1️⃣ Strategy Interface
interface Pay{
    void pay();
}


Defines the common behavior

All payment methods must implement pay()

Ensures uniform contract

This allows polymorphism.

2️⃣ Concrete Strategy Classes
class CreditCard implements Pay
class UPI implements Pay
class PayPal implements Pay


Each class:

Implements the Pay interface

Encapsulates its own payment logic

Can be added or modified independently

If we add:

class Bitcoin implements Pay


No existing code needs modification.

This follows Open/Closed Principle.

3️⃣ Context Class
class Context{
    private Pay pay;

    Context(Pay pay){
        this.pay = pay;
    }

    void processPayment(){
        pay.pay();
    }
}


Responsibilities:

Holds reference to a Pay strategy

Delegates execution to the strategy

Does not know how payment works internally

This is called delegation.

The context controls workflow, but behavior is delegated.

4️⃣ Main Class (Client)
Context context = new Context(new UPI());
context.processPayment();


Responsibilities:

Chooses which strategy to use

Injects strategy into Context

Can switch strategies at runtime

This demonstrates dynamic behavior switching.

🔄 How Runtime Switching Works
context = new Context(new PayPal());
context.processPayment();


At runtime:

Context changes its strategy

Behavior changes without modifying existing classes

No conditional statements needed

📈 Advantages

Removes large if-else blocks

Promotes clean architecture

Makes system extensible

Encourages loose coupling

Easy to test each strategy independently

❌ When Not To Use

When only one algorithm exists

When behavior will never change

For very small/simple logic (may over-engineer)

🧠 Key Concepts Used

Polymorphism

Encapsulation

Delegation

Open/Closed Principle

Loose Coupling

🚀 Output
Payment is Done using UPI
Payment is Done using PayPal
Payment is Done using Credit Card