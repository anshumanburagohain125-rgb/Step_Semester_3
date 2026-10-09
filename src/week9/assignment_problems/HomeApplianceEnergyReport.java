import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private interface SaverMode {
        double reduceUnits(double units);
    }

    private abstract static class Appliance {
        private final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        double hours() { return hours; }
        abstract double powerWatts();
        abstract String type();

        double units() {
            return powerWatts() * hours() / 1000;
        }

        double saverUnits() {
            if (this instanceof SaverMode) {
                return ((SaverMode) this).reduceUnits(units());
            }
            return units();
        }

        final double cost(double units) {
            return units * 8;
        }
    }

    private static class Fridge extends Appliance {
        Fridge(double hours) { super(hours); }
        @Override double powerWatts() { return 150; }
        @Override String type() { return "FRIDGE"; }
    }

    private static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) { super(hours); }
        @Override double powerWatts() { return 1500; }
        @Override String type() { return "AC"; }
        @Override public double reduceUnits(double units) { return units * 0.75; }
    }

    private static class Television extends Appliance {
        Television(double hours) { super(hours); }
        @Override double powerWatts() { return 100; }
        @Override String type() { return "TV"; }
    }

    private static class Washer extends Appliance implements SaverMode {
        Washer(double hours) { super(hours); }
        @Override double powerWatts() { return 500; }
        @Override String type() { return "WASHER"; }
        @Override public double reduceUnits(double units) { return units * 0.75; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Appliance[] appliances = new Appliance[count];
        boolean[] saverRequested = new boolean[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double hours = input.nextDouble();
            saverRequested[i] = input.hasNext("SAVER");
            if (saverRequested[i]) {
                input.next();
            }

            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliances[i] = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliances[i] = new Television(hours);
            } else {
                appliances[i] = new Washer(hours);
            }
        }

        double totalCost = 0;
        for (int i = 0; i < count; i++) {
            Appliance appliance = appliances[i];
            if (saverRequested[i] && !(appliance instanceof SaverMode)) {
                System.out.println(appliance.type() + ": saver mode not supported");
            } else {
                double units = saverRequested[i] ? appliance.saverUnits() : appliance.units();
                double cost = appliance.cost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                        appliance.type(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
