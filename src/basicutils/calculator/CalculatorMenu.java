package basicutils.calculator;

import basicutils.utils.InputReader;

public class CalculatorMenu {
    public static void show() {
        while (true) {
            System.out.println("\nPlease choose an option: ");
            System.out.println("1. Sum (a + b)");
            System.out.println("2. Subtract (a - b)");
            System.out.println("3. Multiply (a * b)");
            System.out.println("4. Divide (a / b)");
            System.out.println("0. Return to main menu");

            int option = InputReader.readInt("Option: ");

            if (option == 0) {
                return;
            }

            if (option < 1 || option > 4) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            double a = InputReader.readDouble("Enter the value for a: ");
            double b;

            if (option == 4) {
                //Repeat until b is not equal to zero
                while (true) {
                    b = InputReader.readDouble("Enter value for b(non-zero): ");
                    if (b != 0) break;
                    System.out.println("Error: Division by zero is not allowed. Please enter a different value.");
                }
            } else {
                b = InputReader.readDouble("Enter value for b: ");
            }

            CalculatorOperation op = switch (option) {
                case 1 -> Double::sum;
                case 2 -> (x, y) -> x - y;
                case 3 -> (x, y) -> x * y;
                case 4 -> (x, y) -> x / y;
                default -> null;
            };

            double result = CalculatorService.executeOperation(a, b, op);
            System.out.println("The result is: " + result);
        }
    }
}
