package asthethi.java.system.design.pattern;

import asthethi.java.system.design.pattern.factory.PaymentMethods;
import asthethi.java.system.design.pattern.model.TransactionData;
import asthethi.java.system.design.pattern.transactionsimulator.Transaction;

public class Main {
    public static void main(String[] args) {

        System.out.println("Performing Payment with Credit Card .... ");
        Thread transaction1 =
                new Thread(new Transaction(new TransactionData("Credit Card Transaction", 1500.00, PaymentMethods.CREDIT)));

        System.out.println("Performing Payment with Debit Card .... ");
        Thread transaction2 =
                new Thread(new Transaction(new TransactionData("Debit Card Transaction", 1200.00, PaymentMethods.DEBIT)));

        transaction1.start();
        transaction2.start();
    }
}
