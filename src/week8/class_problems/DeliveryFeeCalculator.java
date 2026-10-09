import java.util.Scanner;

public class DeliveryFeeCalculator {
    private abstract static class Delivery {
        private final double weight;
        private final double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        double weight() { return weight; }
        double distance() { return distance; }
        abstract double fee();
        abstract String type();
    }

    private static class Standard extends Delivery {
        Standard(double weight, double distance) { super(weight, distance); }
        @Override double fee() {
            return 5 + weight() * 0.50 + distance() * 0.10;
        }
        @Override String type() { return "STANDARD"; }
    }

    private static class Express extends Delivery {
        Express(double weight, double distance) { super(weight, distance); }
        @Override double fee() {
            return 15 + weight() + distance() * 0.20;
        }
        @Override String type() { return "EXPRESS"; }
    }

    private static class International extends Delivery {
        private final double customsFee;

        International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override double fee() {
            return 25 + weight() * 2 + distance() * 0.50 + customsFee;
        }
        @Override String type() { return "INTERNATIONAL"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Delivery[] deliveries = new Delivery[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double weight = input.nextDouble();
            double distance = input.nextDouble();

            if (type.equals("STANDARD")) {
                deliveries[i] = new Standard(weight, distance);
            } else if (type.equals("EXPRESS")) {
                deliveries[i] = new Express(weight, distance);
            } else {
                double customsFee = input.nextDouble();
                deliveries[i] = new International(weight, distance, customsFee);
            }
        }

        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.fee();
            System.out.printf("%s: %.2f%n", delivery.type(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
