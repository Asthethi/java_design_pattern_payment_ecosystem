package asthethi.java.system.design.pattern.factory;

public class PaymentFactory {
    public static Payment getPaymentMethod(PaymentMethods paymentMethod) {
        switch (paymentMethod) {
            case DEBIT:
                return new DebitCardPayment();
            case CREDIT:
                return new CreditCardPayment();
            default:
                System.err.println("Invalid Payment Method!");
                throw new IllegalArgumentException("Invalid Payment Method!");
        }
    }
}
