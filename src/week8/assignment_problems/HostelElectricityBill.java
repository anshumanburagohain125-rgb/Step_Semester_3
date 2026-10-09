import java.util.Scanner;

public class HostelElectricityBill {
    private abstract static class Room {
        private final int units;

        Room(int units) {
            this.units = units;
        }

        int units() {
            return units;
        }

        abstract double bill();
        abstract String type();
    }

    private static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        @Override double bill() { return units() * 8.0; }
        @Override String type() { return "SINGLE"; }
    }

    private static class SharedRoom extends Room {
        private final int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override double bill() { return units() * 6.0 / occupants; }
        @Override String type() { return "SHARED"; }
    }

    private static class AcRoom extends Room {
        AcRoom(int units) { super(units); }
        @Override double bill() { return units() * 10.0 + 200; }
        @Override String type() { return "AC"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Room[] rooms = new Room[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            int units = input.nextInt();

            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = input.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else {
                rooms[i] = new AcRoom(units);
            }
        }

        double total = 0;
        for (Room room : rooms) {
            double bill = room.bill();
            System.out.printf("%s: %.2f%n", room.type(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
