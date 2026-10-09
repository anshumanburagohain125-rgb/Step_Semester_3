import java.util.Scanner;

public class MovieTicketCounter {
    private abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20;
        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        int count() {
            return count;
        }

        abstract double pricePerTicket();
        abstract String seatType();

        final double amount() {
            return count * (pricePerTicket() + CONVENIENCE_FEE);
        }
    }

    private static class RegularTicket extends Ticket {
        RegularTicket(int count) { super(count); }
        @Override double pricePerTicket() { return 150; }
        @Override String seatType() { return "REGULAR"; }
    }

    private static class PremiumTicket extends Ticket {
        PremiumTicket(int count) { super(count); }
        @Override double pricePerTicket() { return 250; }
        @Override String seatType() { return "PREMIUM"; }
    }

    private static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) { super(count); }
        @Override double pricePerTicket() { return 400; }
        @Override String seatType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bookingCount = input.nextInt();
        Ticket[] tickets = new Ticket[bookingCount];

        for (int i = 0; i < bookingCount; i++) {
            String seat = input.next().toUpperCase();
            int count = input.nextInt();

            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;
        for (Ticket ticket : tickets) {
            double amount = ticket.amount();
            System.out.printf("%s: %.2f%n", ticket.seatType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
