package asthethi.java.system.design.pattern.state;

import asthethi.java.system.design.pattern.strategy.PaymentContext;

public class InitiatedState implements TransactionState {
    @Override
    public void handle(PaymentContext paymentContext) {
        System.out.println("Transaction State : INITIATED");
        paymentContext.setState(new ProcessingState());
        paymentContext.processTransaction();
    }
}
