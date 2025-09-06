package asthethi.java.system.design.pattern.transactionsimulator;

import asthethi.java.system.design.pattern.factory.Payment;
import asthethi.java.system.design.pattern.factory.PaymentFactory;
import asthethi.java.system.design.pattern.factory.PaymentMethods;
import asthethi.java.system.design.pattern.model.TransactionData;
import asthethi.java.system.design.pattern.singleton.TransactionIdGenerator;
import asthethi.java.system.design.pattern.strategy.CreditCardDiscountStrategy;
import asthethi.java.system.design.pattern.strategy.DebitCardDiscountStrategy;
import asthethi.java.system.design.pattern.strategy.PaymentContext;

public class Transaction implements Runnable {

    private TransactionData data;

    public Transaction(TransactionData transactionData) {
        this.data = transactionData;
    }

    @Override
    public void run() {
        TransactionIdGenerator transactionIdGenerator = TransactionIdGenerator.getInstance();
        long transactionId = transactionIdGenerator.getNextTransactionId();
        System.out.println("Initiating Transaction " + this.data.getName() + " with transaction-id " + transactionId);
        Payment payment = PaymentFactory.getPaymentMethod(this.data.getPaymentMethodsType());
        PaymentContext paymentContext = new PaymentContext();
        System.out.println("[" +this.data.getName()+"]" + " Setting payment method to "+this.data.getPaymentMethodsType());
        paymentContext.setPaymentMethod(payment);
        System.out.println("[" +this.data.getName()+"]" + " Applying strategy");
        paymentContext.setPaymentStrategy(this.data.getPaymentMethodsType() == PaymentMethods.CREDIT ? new CreditCardDiscountStrategy()
                : new DebitCardDiscountStrategy());
        System.out.println("[" +this.data.getName()+"]" + " Finalizing Transaction");
        paymentContext.processPayment(this.data.getAmount());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println("Error occurred");
            ex.printStackTrace();
        }

    }
}
