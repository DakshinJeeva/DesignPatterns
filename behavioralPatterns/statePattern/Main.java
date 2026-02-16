interface CargoState{
    CargoState next();
    void show();
}

class Created implements CargoState{
    public CargoState next(){
        return new Paid();
    }
    public void show(){
        System.out.println("The Cargo is Created");
    }
}

class Paid implements CargoState{
    public CargoState next(){
        return new Shipped();
    }
    public void show(){
        System.out.println("The Cargo is Paid");
    }
}

class Shipped implements CargoState{
    public CargoState next(){
        return new Delivered();
    }
    public void show(){
        System.out.println("The Cargo is Shipped");
    }
}

class Delivered implements CargoState{
    public CargoState next(){
        System.out.println("The Cargo is already Delivered");
        return this;
    }
    public void show(){
        System.out.println("The Cargo is Delivered");
    }
}


class Cancelled implements CargoState {

    public CargoState next() {
        System.out.println("The Cargo is already Cancelled");
        return this;
    }

    public void show() {
        System.out.println("The Cargo is Cancelled");
    }
}


class CargoConext{
    CargoState state = new Created();

    void next(){
        this.state = state.next();
    }

    void cancel(){
        this.state =  new Cancelled();
    }

    void show(){
        state.show();
    }
}

class Main{
    public static void main(String args[]){
        CargoConext context = new CargoConext();
        Cancel cancel = new Cancel();
        
        context.show();
        context.next();
        context.show();
        context.next();
        context.show();
        context.next();
        context.show();
        context.next();
        context.show();
        context.next();
        
        context.cancel();

        context.show();
        context.next();


    }
}
