package asthethi.java.system.design.pattern.factory;

public class DebitCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment made using Debit Card , Amount Paid is "+amount);
    }
}
