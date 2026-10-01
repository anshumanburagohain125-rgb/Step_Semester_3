public final class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        presentStudents = new String[capacity];
    }

    public boolean markPresent(String studentName) {
        if (studentName == null || studentName.isEmpty() || isPresent(studentName)
                || presentCount == presentStudents.length) {
            return false;
        }
        presentStudents[presentCount++] = studentName;
        return true;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) {
            return false;
        }
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}