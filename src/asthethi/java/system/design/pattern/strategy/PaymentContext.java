package asthethi.java.system.design.pattern.strategy;

import asthethi.java.system.design.pattern.factory.Payment;
import asthethi.java.system.design.pattern.model.TransactionData;
import asthethi.java.system.design.pattern.singleton.TransactionIdGenerator;
import asthethi.java.system.design.pattern.state.InitiatedState;
import asthethi.java.system.design.pattern.state.TransactionState;

import java.sql.SQLOutput;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private Payment paymentMethod;
    private TransactionState state;

    private TransactionData transactionData;

    public PaymentContext() {
        this.state = new InitiatedState();
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public TransactionState getState() {
        return state;
    }

    public TransactionData getTransactionData() {
        return transactionData;
    }

    public void processTransaction() {
        this.state.handle(this);
    }
}
