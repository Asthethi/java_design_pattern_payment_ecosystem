package asthethi.java.system.design.pattern.model;

import asthethi.java.system.design.pattern.factory.PaymentMethods;

public class TransactionData {
    private String name;
    private double amount;
    private PaymentMethods paymentMethodsType;

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethods getPaymentMethodsType() {
        return paymentMethodsType;
    }

    public TransactionData(String name, double amount, PaymentMethods paymentMethodsType) {
        this.name = name;
        this.amount = amount;
        this.paymentMethodsType = paymentMethodsType;
    }
}
