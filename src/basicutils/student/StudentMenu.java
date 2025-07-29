package basicutils.student;

import basicutils.utils.InputReader;

import java.util.HashMap;
import java.util.Map;

public class StudentMenu {
    public static void show() {
        String name;
        do {
            name = InputReader.readLine("Please enter your name: ");
            if (name.isBlank()) {
                System.out.println("Name cannot be empty. Try again.");
            }
        } while (name.isBlank());

        String grade;
        do {
            grade = InputReader.readLine("Please enter your grade: ");
            if (grade.isBlank()) {
                System.out.println("Grade cannot be empty. Try again.");
            }
        } while (grade.isBlank());

        int numSubjects;
        do {
            numSubjects = InputReader.readInt("Please enter the number of subjects to enroll (minimum 1): ");
            if (numSubjects < 1) {
                System.out.println("You must enroll at least one subject.");
            }
        } while (numSubjects < 1);

        Map<String, Double> subjects = new HashMap<>();

        for (int i = 1; i <= numSubjects; i++) {
            String subjectName;
            do {
                subjectName = InputReader.readLine("Enter name of subject " +i+ ": ");
                if (subjectName.isBlank()) {
                    System.out.println("Subject Name cannot be empty. Try again.");
                }
            } while (subjectName.isBlank());

            //Double score; Type may be primitive: since score is never null and this has slightly better performance
            double score;  // <-------> This is the primitive
            while (true) {
                score = InputReader.readDouble("Enter score for " +subjectName+ " (0 - 10): ");
                if (score >= 0 && score <= 10) {
                    break;
                } else {
                    System.out.println("Invalid score. Please enter a value between 0 and 10.");
                }
            }

            subjects.put(subjectName, score);
        }

        Student student = new Student(name, grade, subjects);
        StudentService.printReport(student);
    }
}
