import java.util.Scanner;

public class CanteenBillingCounter {
    private abstract static class Bill {
        private final double amount;

        Bill(double amount) {
            this.amount = amount;
        }

        double amount() {
            return amount;
        }

        abstract double finalAmount();
        abstract String type();
    }

    private static class StudentBill extends Bill {
        StudentBill(double amount) { super(amount); }
        @Override double finalAmount() { return amount() * 0.90; }
        @Override String type() { return "STUDENT"; }
    }

    private static class StaffBill extends Bill {
        StaffBill(double amount) { super(amount); }
        @Override double finalAmount() { return amount() * 0.95; }
        @Override String type() { return "STAFF"; }
    }

    private static class GuestBill extends Bill {
        GuestBill(double amount) { super(amount); }
        @Override double finalAmount() { return amount() + 10; }
        @Override String type() { return "GUEST"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Bill[] bills = new Bill[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double amount = input.nextDouble();

            if (type.equals("STUDENT")) {
                bills[i] = new StudentBill(amount);
            } else if (type.equals("STAFF")) {
                bills[i] = new StaffBill(amount);
            } else {
                bills[i] = new GuestBill(amount);
            }
        }

        double total = 0;
        for (Bill bill : bills) {
            double finalAmount = bill.finalAmount();
            System.out.printf("%s: %.2f%n", bill.type(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
