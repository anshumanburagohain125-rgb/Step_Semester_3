class Course {
    private final String code;
    private final String title;
    private final int credits;
    private final int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}

public class M3CourseCreditManagement {
    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}