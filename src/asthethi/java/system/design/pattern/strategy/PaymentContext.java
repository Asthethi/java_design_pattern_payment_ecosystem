package asthethi.java.system.design.pattern.strategy;

import asthethi.java.system.design.pattern.factory.Payment;
import asthethi.java.system.design.pattern.singleton.TransactionIdGenerator;

import java.sql.SQLOutput;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private Payment paymentMethod;

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void processPayment(double amount) {

        if (paymentMethod == null) {
            throw new IllegalStateException("Payment method not set!");
        }
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set!");
        }

        System.out.println("Applying " + this.paymentStrategy.getStrategyName());
        double finalAmount = this.paymentStrategy != null ? this.paymentStrategy.applyStrategy(amount) : amount;
        this.paymentMethod.pay(finalAmount);
    }
}
