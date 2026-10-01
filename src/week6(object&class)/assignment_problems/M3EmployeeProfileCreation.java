class Employee {
    private final String empId;
    private final String empName;
    private final double salary;
    @SuppressWarnings("FieldMayBeFinal")
    private boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class M3EmployeeProfileCreation {
    public static void main(String[] args) {
        Employee permanentEmployee = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanentEmployee.printProfile();
        intern.printProfile();
    }
}