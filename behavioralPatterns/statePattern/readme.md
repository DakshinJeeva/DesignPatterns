📦 State Pattern – Low Level Design (LLD)
📌 What is State Pattern?

The State Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes.

Instead of using large if-else or switch statements to manage state-based behavior, the State Pattern:

Encapsulates each state into a separate class

Delegates behavior to the current state object

Allows dynamic behavior change at runtime

In short:
The object behaves differently depending on its current state.

🎯 Why Use State Pattern?

Without State Pattern:

if(state == CREATED) { ... }
else if(state == PAID) { ... }
else if(state == SHIPPED) { ... }


Problems:

Hard to maintain

Violates Open/Closed Principle

Becomes messy as states grow

Difficult to extend

With State Pattern:

No conditionals

Clean separation of logic

Easy to add new states

Better maintainability

🧠 When Should You Use It?

Use State Pattern when:

✅ An object’s behavior changes based on its internal state
✅ There are multiple well-defined states
✅ State transitions follow business rules
✅ You want to eliminate large conditional blocks

🚚 Example: Cargo Lifecycle

States:

Created

Paid

Shipped

Delivered

Cancelled

The cargo changes behavior as it moves through these states.

🏗 Structure of the Pattern

There are three main components:

State Interface

Concrete State Classes

Context Class

1️⃣ State Interface
interface CargoState {
    CargoState next();
    void show();
}

Purpose:

Defines common behavior for all states.

Ensures all states implement the same methods.

Methods:

next() → Defines transition to next state.

show() → Displays current state behavior.

This enables polymorphism.

2️⃣ Concrete State Classes

Each state represents a specific phase of the cargo lifecycle.

🟢 Created State
class Created implements CargoState {
    public CargoState next(){
        return new Paid();
    }

    public void show(){
        System.out.println("The Cargo is Created");
    }
}

Role:

Initial state.

Transitions to Paid.

💳 Paid State
class Paid implements CargoState {
    public CargoState next(){
        return new Shipped();
    }

    public void show(){
        System.out.println("The Cargo is Paid");
    }
}

Role:

Indicates payment completed.

Transitions to Shipped.

🚛 Shipped State
class Shipped implements CargoState {
    public CargoState next(){
        return new Delivered();
    }

    public void show(){
        System.out.println("The Cargo is Shipped");
    }
}

Role:

Cargo is in transit.

Transitions to Delivered.

📦 Delivered State
class Delivered implements CargoState {
    public CargoState next(){
        System.out.println("The Cargo is already Delivered");
        return this;
    }

    public void show(){
        System.out.println("The Cargo is Delivered");
    }
}

Role:

Final successful state.

Cannot transition further.

Returns this to stay in same state.

❌ Cancelled State
class Cancelled implements CargoState {

    public CargoState next() {
        System.out.println("The Cargo is already Cancelled");
        return this;
    }

    public void show() {
        System.out.println("The Cargo is Cancelled");
    }
}

Role:

Represents terminated state.

No further transitions allowed.

3️⃣ Context Class
class CargoConext {

    CargoState state = new Created();

    void next(){
        this.state = state.next();
    }

    void cancel(){
        this.state = new Cancelled();
    }

    void show(){
        state.show();
    }
}

Purpose:

Maintains current state.

Delegates behavior to state object.

Does NOT use if-else.

Updates state dynamically.

🔄 How It Works

Context starts with Created.

Calling next() moves it to Paid.

Each state decides what the next state should be.

Behavior changes automatically depending on current state.

Example:

CargoConext context = new CargoConext();

context.show();  // Created
context.next();
context.show();  // Paid
context.next();
context.show();  // Shipped
