package basicutils.student;

import java.util.Map;

public record Student(String name, String grade, Map<String, Double> subjects) {
}
