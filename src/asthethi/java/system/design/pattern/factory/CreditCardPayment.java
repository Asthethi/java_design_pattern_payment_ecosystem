package asthethi.java.system.design.pattern.factory;

public class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment made using Credit Card , Amount Paid is "+amount);
    }
}
