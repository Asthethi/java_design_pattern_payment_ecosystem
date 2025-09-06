package asthethi.java.system.design.pattern.strategy;

public class DebitCardDiscountStrategy implements PaymentStrategy {
    @Override
    public double applyStrategy(double amount) {
        return amount * 0.95;
    }

    @Override
    public String getStrategyName() {
        return "Debit Card Discount Strategy";
    }
}
