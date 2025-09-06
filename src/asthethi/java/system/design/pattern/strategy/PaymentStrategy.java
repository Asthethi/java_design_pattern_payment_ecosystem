package asthethi.java.system.design.pattern.strategy;

public interface PaymentStrategy {
    double applyStrategy(double amount);
    String getStrategyName();
}
