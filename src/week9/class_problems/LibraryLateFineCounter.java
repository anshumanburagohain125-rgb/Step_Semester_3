import java.util.Scanner;

public class LibraryLateFineCounter {
    private abstract static class LibraryItem {
        private final String title;
        private final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        String title() { return title; }
        int daysLate() { return daysLate; }
        abstract double fine();
    }

    private static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        @Override double fine() { return daysLate() * 2.0; }
    }

    private static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) { super(title, daysLate); }
        @Override double fine() { return Math.min(daysLate() * 5.0, 50); }
    }

    private static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        @Override double fine() { return daysLate(); }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        LibraryItem[] items = new LibraryItem[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            String title = input.next();
            int daysLate = input.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title, daysLate);
            } else {
                items[i] = new Magazine(title, daysLate);
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            System.out.printf("%s: %.2f%n", item.title(), fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
