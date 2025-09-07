package asthethi.java.system.design.pattern.state;

import asthethi.java.system.design.pattern.strategy.PaymentContext;

public interface TransactionState {
    void handle(PaymentContext paymentContext);
}
