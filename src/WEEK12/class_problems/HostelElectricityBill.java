import java.util.Scanner;

public class HostelElectricityBill {
    // Time: O(n) for n rooms.
    private static long calculateBill(long units) {
        if (units <= 100) {
            return units * 3 + 50;
        } else if (units <= 200) {
            return 100 * 3 + (units - 100) * 5 + 50;
        }
        return 100 * 3 + 100 * 5 + (units - 200) * 8 + 50;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int roomCount = input.nextInt();
        int roomsBilled = 0;
        long total = 0;

        for (int i = 0; i < roomCount; i++) {
            String roomNumber = input.next();
            long units = input.nextLong();

            if (units < 0) {
                System.out.println(roomNumber + ": invalid reading");
            } else {
                long bill = calculateBill(units);
                System.out.println(roomNumber + ": " + units + " units, bill " + bill);
                roomsBilled++;
                total += bill;
            }
        }

        System.out.println("Rooms billed " + roomsBilled + ", total " + total);
    }
}
