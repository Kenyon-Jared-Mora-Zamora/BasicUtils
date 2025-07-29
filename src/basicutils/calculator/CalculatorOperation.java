package basicutils.calculator;

@FunctionalInterface
public interface CalculatorOperation {
    double operate(double a, double b);
}
