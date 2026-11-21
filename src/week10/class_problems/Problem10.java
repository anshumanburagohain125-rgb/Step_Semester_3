import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }

        return (double) total / marks.length;
    }

    char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.next();
        int[] marks = new int[3];

        for (int i = 0; i < marks.length; i++) {
            marks[i] = input.nextInt();
        }

        Student student = new Student(name, marks);
        double average = student.calculateAverage();
        char grade = student.calculateGrade(average);

        System.out.printf("%s: Average %.1f, Grade %c%n",
                student.name.toUpperCase(), average, grade);
    }
}
