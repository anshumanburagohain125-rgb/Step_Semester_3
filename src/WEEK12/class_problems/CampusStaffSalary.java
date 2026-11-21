import java.util.Locale;
import java.util.Scanner;

class Staff {
    private final String name;
    private final double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0.0;
    }

    String getType() {
        return getClass().getSimpleName();
    }

    double getTotalSalary() {
        return baseSalary + getBonus();
    }

    void printDetails() {
        System.out.printf(Locale.US, "%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                name, getType(), baseSalary, getBonus(), getTotalSalary());
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 5000.0;
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 2000.0;
    }
}

public class CampusStaffSalary {
    // Time: O(n) for n staff members.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Staff[] staff = new Staff[count];

        for (int i = 0; i < count; i++) {
            String type = input.next();
            String name = input.next();
            double baseSalary = input.nextDouble();

            if (type.equals("Teacher")) {
                staff[i] = new Teacher(name, baseSalary);
            } else if (type.equals("LabAssistant")) {
                staff[i] = new LabAssistant(name, baseSalary);
            } else {
                staff[i] = new Staff(name, baseSalary);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < staff.length; i++) {
            staff[i].printDetails();
            grandTotal += staff[i].getTotalSalary();
        }

        System.out.printf(Locale.US, "Grand Total Salary: %.1f%n", grandTotal);
    }
}
