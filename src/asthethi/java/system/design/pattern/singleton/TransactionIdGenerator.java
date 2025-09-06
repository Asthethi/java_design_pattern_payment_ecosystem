package asthethi.java.system.design.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class TransactionIdGenerator {

    private AtomicLong transactionId = new AtomicLong(100);
    private TransactionIdGenerator() {}

    private static class Holder {
        private static final TransactionIdGenerator INSTANCE = new TransactionIdGenerator();
    }

    public static TransactionIdGenerator getInstance() {
        return Holder.INSTANCE;
    }

    public long getNextTransactionId() {
        return transactionId.incrementAndGet();
    }
}
