import java.util.Scanner;

public class CityCabFareMeter {
    private interface NightService {
        double applyNightFare(double fare);
    }

    private abstract static class Cab {
        private final double distance;

        Cab(double distance) {
            this.distance = distance;
        }

        double distance() { return distance; }
        abstract double ratePerKm();
        abstract String type();

        final double dayFare() {
            return Math.max(distance() * ratePerKm(), 100);
        }
    }

    private static class Mini extends Cab {
        Mini(double distance) { super(distance); }
        @Override double ratePerKm() { return 10; }
        @Override String type() { return "MINI"; }
    }

    private static class Sedan extends Cab implements NightService {
        Sedan(double distance) { super(distance); }
        @Override double ratePerKm() { return 14; }
        @Override String type() { return "SEDAN"; }
        @Override public double applyNightFare(double fare) { return fare * 1.20; }
    }

    private static class Suv extends Cab implements NightService {
        Suv(double distance) { super(distance); }
        @Override double ratePerKm() { return 18; }
        @Override String type() { return "SUV"; }
        @Override public double applyNightFare(double fare) { return fare * 1.20; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Cab[] cabs = new Cab[count];
        boolean[] nightTrips = new boolean[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double distance = input.nextDouble();
            nightTrips[i] = input.next().equalsIgnoreCase("NIGHT");

            if (type.equals("MINI")) {
                cabs[i] = new Mini(distance);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new Sedan(distance);
            } else {
                cabs[i] = new Suv(distance);
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            Cab cab = cabs[i];
            if (nightTrips[i] && !(cab instanceof NightService)) {
                System.out.println(cab.type() + ": night service not available");
            } else {
                double fare = cab.dayFare();
                if (nightTrips[i]) {
                    fare = ((NightService) cab).applyNightFare(fare);
                }
                System.out.printf("%s: %.2f%n", cab.type(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
