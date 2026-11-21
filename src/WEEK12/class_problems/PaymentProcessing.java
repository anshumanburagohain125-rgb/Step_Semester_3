import java.util.Locale;
import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);

    double getFee(double amount);

    String getModeName();
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0.0;
    }

    public String getModeName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public double getFee(double amount) {
        return amount * 0.02;
    }

    public String getModeName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0.0;
    }

    public String getModeName() {
        return "UPI";
    }
}

public class PaymentProcessing {
    // Time: O(n) for n payments.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        PaymentMode[] payments = new PaymentMode[count];
        double[] amounts = new double[count];

        for (int i = 0; i < count; i++) {
            String mode = input.next();
            amounts[i] = input.nextDouble();

            if (mode.equals("Cash")) {
                payments[i] = new CashPayment();
            } else if (mode.equals("Card")) {
                payments[i] = new CardPayment();
            } else {
                payments[i] = new UpiPayment();
            }
        }

        double totalProcessed = 0.0;
        for (int i = 0; i < payments.length; i++) {
            double processed = payments[i].processPayment(amounts[i]);
            double fee = payments[i].getFee(amounts[i]);

            System.out.printf(Locale.US, "%s: amount %.1f, fee %.1f, processed %.1f%n",
                    payments[i].getModeName(), amounts[i], fee, processed);
            totalProcessed += processed;
        }

        System.out.printf(Locale.US, "Total Amount Processed: %.1f%n", totalProcessed);
    }
}
