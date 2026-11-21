import java.util.Locale;
import java.util.Scanner;

class Student {
    private final String name;
    private int mark1;
    private int mark2;
    private int mark3;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
            return false;
        }

        mark1 = a;
        mark2 = b;
        mark3 = c;
        return true;
    }

    int getTotal() {
        return mark1 + mark2 + mark3;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    char getGrade() {
        double average = getAverage();
        if (average >= 80) {
            return 'A';
        } else if (average >= 70) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        }
        return 'F';
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class ClassReportCard {
    // Bubble sort: best case O(n), worst case O(n^2).
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Student[] students = new Student[count];
        int acceptedCount = 0;

        for (int i = 0; i < count; i++) {
            String name = input.next();
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            Student student = new Student(name);
            if (student.setMarks(a, b, c)) {
                students[acceptedCount] = student;
                acceptedCount++;
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;
        for (int pass = 0; pass < acceptedCount - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < acceptedCount - pass - 1; i++) {
                if (students[i].getTotal() < students[i + 1].getTotal()) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    swapped = true;
                }
            }

            passes++;
            if (!swapped) {
                break;
            }
        }

        for (int i = 0; i < acceptedCount; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
    }
}
