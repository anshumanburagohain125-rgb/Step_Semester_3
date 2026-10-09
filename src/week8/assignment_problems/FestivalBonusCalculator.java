import java.util.Scanner;

public class FestivalBonusCalculator {
    private abstract static class Employee {
        private final String name;
        private final double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        String name() { return name; }
        double salary() { return salary; }
        abstract double bonus();
    }

    private static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }
        @Override double bonus() { return salary() * 0.10; }
    }

    private static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }
        @Override double bonus() { return salary() * 0.05; }
    }

    private static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        @Override double bonus() { return 2000; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            String name = input.next();
            double salary = input.nextDouble();

            if (type.equals("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else {
                employees[i] = new Intern(name, salary);
            }
        }

        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            System.out.printf("%s: %.2f%n", employee.name(), bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
