public class M5EmployeeCompanyInformationManagement {
    static class Employee {
        private static final String COMPANY_NAME = "Bright Horizon Technologies";
        private static int employeeCount;

        private final String empName;
        private final double salary;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(COMPANY_NAME);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Divya", 65000),
            new Employee("Arjun", 0),
            new Employee("Priya", 72000)
        };

        for (Employee employee : employees) {
            if (employee.empName == null || employee.salary < 0) {
                throw new IllegalStateException("Invalid employee profile");
            }
        }

        Employee.printCompanyInfo();
    }
}