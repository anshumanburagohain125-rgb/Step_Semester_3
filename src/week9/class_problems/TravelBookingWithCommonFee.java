import java.util.Scanner;

public class TravelBookingWithCommonFee {
    private interface BookingFee {
        double BOOKING_FEE = 50;
    }

    private abstract static class Booking implements BookingFee {
        private final double distance;

        Booking(double distance) {
            this.distance = distance;
        }

        double distance() { return distance; }
        abstract double baseFare();
        abstract String mode();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }
    }

    private static class Bus extends Booking {
        Bus(double distance) { super(distance); }
        @Override double baseFare() { return distance() * 2; }
        @Override String mode() { return "BUS"; }
    }

    private static class Train extends Booking {
        Train(double distance) { super(distance); }
        @Override double baseFare() { return distance() * 1.5; }
        @Override String mode() { return "TRAIN"; }
    }

    private static class Flight extends Booking {
        Flight(double distance) { super(distance); }
        @Override double baseFare() { return 2500 + distance() * 4; }
        @Override String mode() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Booking[] bookings = new Booking[count];

        for (int i = 0; i < count; i++) {
            String mode = input.next().toUpperCase();
            double distance = input.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new Train(distance);
            } else {
                bookings[i] = new Flight(distance);
            }
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.mode(), booking.totalFare());
        }
    }
}
