package asthethi.java.system.design.pattern.state;

import asthethi.java.system.design.pattern.strategy.PaymentContext;

public class CompletedState implements TransactionState {
    @Override
    public void handle(PaymentContext paymentContext) {
        System.out.println("Transaction State : COMPLETED");
    }
}
