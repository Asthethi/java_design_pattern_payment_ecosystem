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

    public TransactionData(Builder builder) {
        this.name = builder.name;
        this.amount = builder.amount;
        this.paymentMethodsType = builder.paymentMethodsType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private double amount;
        private PaymentMethods paymentMethodsType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentMethods(PaymentMethods paymentMethodsType) {
            this.paymentMethodsType = paymentMethodsType;
            return this;
        }

        public TransactionData build() {
            return new TransactionData(this);
        }

    }

}
