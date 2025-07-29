package basicutils.calculator;

public class CalculatorService {
    public static double executeOperation(double a, double b, CalculatorOperation operation) {
        return operation.operate(a, b);
    }
}
