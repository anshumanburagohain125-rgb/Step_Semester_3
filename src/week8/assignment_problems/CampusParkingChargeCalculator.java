import java.util.Scanner;

public class CampusParkingChargeCalculator {
    private abstract static class Vehicle {
        private final int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        int hours() {
            return hours;
        }

        abstract double charge();
        abstract String type();
    }

    private static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        @Override double charge() { return hours() * 10.0; }
        @Override String type() { return "BIKE"; }
    }

    private static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        @Override double charge() { return 30 + (hours() - 1) * 20.0; }
        @Override String type() { return "CAR"; }
    }

    private static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        @Override double charge() { return Math.max(hours() * 50.0, 100); }
        @Override String type() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            int hours = input.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            System.out.printf("%s: %.2f%n", vehicle.type(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
