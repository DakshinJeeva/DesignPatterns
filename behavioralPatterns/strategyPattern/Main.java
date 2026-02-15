
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