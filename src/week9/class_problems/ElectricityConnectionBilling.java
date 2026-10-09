import java.util.Scanner;

public class ElectricityConnectionBilling {
    private abstract static class Connection {
        private final int units;

        Connection(int units) {
            this.units = units;
        }

        int units() { return units; }
        abstract double bill();
        abstract String type();
    }

    private static class Home extends Connection {
        Home(int units) { super(units); }

        @Override
        double bill() {
            if (units() <= 100) {
                return units() * 5.0;
            }
            return 100 * 5.0 + (units() - 100) * 7.0;
        }

        @Override String type() { return "HOME"; }
    }

    private static class Shop extends Connection {
        Shop(int units) { super(units); }
        @Override double bill() { return units() * 8.0 + 100; }
        @Override String type() { return "SHOP"; }
    }

    private static class Factory extends Connection {
        Factory(int units) { super(units); }
        @Override double bill() { return Math.max(units() * 6.0, 1000); }
        @Override String type() { return "FACTORY"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Connection[] connections = new Connection[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            int units = input.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            } else {
                connections[i] = new Factory(units);
            }
        }

        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.bill();
            System.out.printf("%s: %.2f%n", connection.type(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
