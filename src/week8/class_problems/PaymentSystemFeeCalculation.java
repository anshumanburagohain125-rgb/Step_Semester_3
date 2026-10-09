import java.util.Scanner;

public class PaymentSystemFeeCalculation {
    private abstract static class Payment {
        private final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        double amount() {
            return amount;
        }

        abstract double finalAmount();
        abstract String type();
    }

    private static class Card extends Payment {
        Card(double amount) { super(amount); }
        @Override double finalAmount() { return amount() * 1.02; }
        @Override String type() { return "CARD"; }
    }

    private static class Wallet extends Payment {
        Wallet(double amount) { super(amount); }
        @Override double finalAmount() { return amount() * 1.01; }
        @Override String type() { return "WALLET"; }
    }

    private static class BankTransfer extends Payment {
        BankTransfer(double amount) { super(amount); }
        @Override double finalAmount() { return amount(); }
        @Override String type() { return "BANKTRANSFER"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Payment[] payments = new Payment[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double amount = input.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new Card(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new Wallet(amount);
            } else {
                payments[i] = new BankTransfer(amount);
            }
        }

        double total = 0;
        for (Payment payment : payments) {
            double adjustedAmount = payment.finalAmount();
            System.out.printf("%s: %.2f%n", payment.type(), adjustedAmount);
            total += adjustedAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
