package asthethi.java.system.design.pattern;

import asthethi.java.system.design.pattern.factory.PaymentMethods;
import asthethi.java.system.design.pattern.model.TransactionData;
import asthethi.java.system.design.pattern.transactionsimulator.Transaction;

public class Main {
    public static void main(String[] args) {

        Thread transaction1 =
                new Thread(new Transaction(new TransactionData("Credit Card Transaction", 1500.00, PaymentMethods.CREDIT)));

        Thread transaction2 =
                new Thread(new Transaction(new TransactionData("Debit Card Transaction", 1200.00, PaymentMethods.DEBIT)));

        Thread transaction3 = new Thread(new Transaction(TransactionData.builder().name("Credit Card Transaction").amount(1800.00).paymentMethods(PaymentMethods.CREDIT).build()));

        transaction1.start();
        transaction2.start();
        transaction3.start();
    }
}
