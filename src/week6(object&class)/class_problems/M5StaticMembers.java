class StudentCounter {
    private static int studentCount;

    StudentCounter() {
        studentCount++;
    }

    static int getStudentCount() {
        return studentCount;
    }
}

public class M5StaticMembers {
    public static void main(String[] args) {
        StudentCounter[] students = {
            new StudentCounter(),
            new StudentCounter(),
            new StudentCounter()
        };

        System.out.println("Students created: " + StudentCounter.getStudentCount()
                + " (array size: " + students.length + ")");
    }
}