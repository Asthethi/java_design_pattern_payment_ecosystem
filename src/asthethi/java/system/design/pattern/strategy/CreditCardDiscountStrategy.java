package asthethi.java.system.design.pattern.strategy;

public class CreditCardDiscountStrategy implements PaymentStrategy {
    @Override
    public double applyStrategy(double amount) {
        return amount * 0.9;
    }

    @Override
    public String getStrategyName() {
        return "Credit Card Discount Strategy";
    }
}
