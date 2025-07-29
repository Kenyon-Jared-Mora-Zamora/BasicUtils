package basicutils.main;

import basicutils.calculator.CalculatorMenu;
import basicutils.encoder.EncoderMenu;
import basicutils.student.StudentMenu;
import basicutils.utils.InputReader;

public class BasicUtilsApp {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPlease choose an option");
            System.out.println("1. Basic Calculator");
            System.out.println("2. Encoder");
            System.out.println("3. Student Average Calculator");
            System.out.println("0. Exit");

            int choice = InputReader.readInt("Option: ");

            switch (choice) {
                case 1 -> CalculatorMenu.show();
                case 2 -> EncoderMenu.show();
                case 3 -> StudentMenu.show();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}
