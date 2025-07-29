package basicutils.encoder;

import basicutils.utils.InputReader;

public class EncoderMenu {
    public static void show() {
        while (true) {
            System.out.println("\nENCODER");
            System.out.println("Please choose an option: ");
            System.out.println("1. Encode a String to Base64");
            System.out.println("2. Decode a Base64 String");
            System.out.println("0. Return to main menu");

            int option = InputReader.readInt("Option: ");

            switch (option) {
                case 0 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                case 1 -> {
                    String input;
                    do {
                        input = InputReader.readLine("Enter the string to encode (cannot be empty): ");
                        if (input.isBlank()) {
                            System.out.println("Input cannot be empty. Please try again.");
                        }
                    } while (input.isBlank());

                    String encoded = EncoderService.encode(input);
                    System.out.println("Encoded String is: " + encoded);
                }
                case 2 -> {
                    String input;
                    do {
                        input = InputReader.readLine("Enter the Base64 string to decode (cannot be empty): ");
                        if (input.isBlank()) {
                            System.out.println("Input cannot be empty. Please try again.");
                        }
                    } while (input.isBlank());

                    String decoded = EncoderService.decode(input);
                    System.out.println("Decoded String is: " + decoded);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
