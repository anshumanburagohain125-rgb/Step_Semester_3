import java.util.Scanner;

public class PublicTransportFareCalculator {
    private abstract static class Journey {
        private final double distance;

        Journey(double distance) {
            this.distance = distance;
        }

        double distance() { return distance; }
        abstract double fare();
        abstract String type();
    }

    private static class Bus extends Journey {
        Bus(double distance) { super(distance); }
        @Override double fare() {
            return Math.min(2 + distance() * 0.10, 10);
        }
        @Override String type() { return "BUS"; }
    }

    private static class Train extends Journey {
        Train(double distance) { super(distance); }
        @Override double fare() {
            return 3 + distance() * 0.15;
        }
        @Override String type() { return "TRAIN"; }
    }

    private static class Metro extends Journey {
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override double fare() {
            return (1.50 + distance() * 0.20) * peakHourFactor;
        }
        @Override String type() { return "METRO"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Journey[] journeys = new Journey[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double distance = input.nextDouble();

            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else {
                double peakHourFactor = input.nextDouble();
                journeys[i] = new Metro(distance, peakHourFactor);
            }
        }

        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.fare();
            System.out.printf("%s: %.2f%n", journey.type(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
