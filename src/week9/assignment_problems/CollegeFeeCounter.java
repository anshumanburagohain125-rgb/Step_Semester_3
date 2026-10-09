import java.util.Scanner;

public class CollegeFeeCounter {
    private interface BusUser {
        double transportFee();
    }

    private abstract static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }

        String name() { return name; }
        abstract double tuitionFee();

        double fee() {
            double total = tuitionFee();
            if (this instanceof BusUser) {
                total += ((BusUser) this).transportFee();
            }
            return total;
        }
    }

    private static class DayScholar extends Student implements BusUser {
        DayScholar(String name) { super(name); }
        @Override double tuitionFee() { return 40000; }
        @Override public double transportFee() { return 12000; }
    }

    private static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        @Override double tuitionFee() { return 40000 + 60000; }
    }

    private static class Scholar extends Student implements BusUser {
        Scholar(String name) { super(name); }
        @Override double tuitionFee() { return 20000; }
        @Override public double transportFee() { return 12000; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            String name = input.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else {
                students[i] = new Scholar(name);
            }
        }

        double total = 0;
        for (Student student : students) {
            double fee = student.fee();
            System.out.printf("%s: %.2f%n", student.name(), fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
