package basicutils.encoder;

import java.util.Base64;

public class EncoderService {
    public static String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String decode(String input) {
        try {
            return new String(Base64.getDecoder().decode(input));
        } catch (IllegalArgumentException e) {
            return "Error: Inout is not a valid Base64 encoded string.";
        }
    }
}
