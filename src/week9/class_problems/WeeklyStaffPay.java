import java.util.Scanner;

public class WeeklyStaffPay {
    private abstract static class Staff {
        private final String name;

        Staff(String name) {
            this.name = name;
        }

        String name() {
            return name;
        }

        abstract double pay();
    }

    private static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override double pay() { return weeklySalary; }
    }

    private static class HourlyStaff extends Staff {
        private final double hours;
        private final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double pay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    private static class Intern extends Staff {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Staff[] staffMembers = new Staff[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            String name = input.next();

            if (type.equals("FULLTIME")) {
                staffMembers[i] = new FullTimeStaff(name, input.nextDouble());
            } else if (type.equals("HOURLY")) {
                staffMembers[i] = new HourlyStaff(name, input.nextDouble(), input.nextDouble());
            } else {
                staffMembers[i] = new Intern(name, input.nextDouble());
            }
        }

        double totalPayroll = 0;
        for (Staff staff : staffMembers) {
            double pay = staff.pay();
            System.out.printf("%s: %.2f%n", staff.name(), pay);
            totalPayroll += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }
}
