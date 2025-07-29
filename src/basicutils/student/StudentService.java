package basicutils.student;

import java.util.Map;

public class StudentService {
    public static double calculateAverage(Map<String, Double> subjects) {
        return subjects
                    .values()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
    }

    public static String getStatus(double average) {
        if (average >= 9) return "Passed with excellence.";
        if (average >= 7) return "Passed with good level.";
        if (average >= 6) return "Passed.";
        return "Failed.";
    }

    public static void printReport(Student student) {
        double average = calculateAverage(student.subjects());
        String status = getStatus(average);

        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.printf("Student name: %-50s Grade: %s%n", student.name(), student.grade());
        System.out.println("---------------------------------------------------------------------------------------");

        student.subjects().forEach((subject, score) ->
            System.out.printf("Subject: %-60s Score: %.2f%n", subject, score)
        );

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("Final average: %.2f\t\tStatus: %s%n", average, status);
    }
}
