package asthethi.java.system.design.pattern.state;

import asthethi.java.system.design.pattern.strategy.PaymentContext;

public class ProcessingState implements TransactionState {
    @Override
    public void handle(PaymentContext paymentContext) {
        System.out.println("Transaction State : PROCESSING");

        if (paymentContext.getPaymentMethod() == null) {
            paymentContext.setState(new FailedState());
            throw new IllegalStateException("Payment method not set!");
        }
        if (paymentContext.getPaymentStrategy() == null) {
            paymentContext.setState(new FailedState());
            throw new IllegalStateException("Payment strategy not set!");
        }

        try {
            System.out.println("Applying " + paymentContext.getPaymentStrategy().getStrategyName());
            double finalAmount = paymentContext.getPaymentStrategy().applyStrategy(paymentContext.getTransactionData().getAmount());
            paymentContext.getPaymentMethod().pay(finalAmount);
            paymentContext.setState(new CompletedState());
            paymentContext.processTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            paymentContext.setState(new FailedState());
        }

    }
}
