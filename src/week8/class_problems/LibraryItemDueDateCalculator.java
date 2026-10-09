import java.util.Scanner;

public class LibraryItemDueDateCalculator {
    private abstract static class LibraryItem {
        private final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        String title() {
            return title;
        }

        abstract int borrowingDays();

        String dueDate() {
            int year = 2023;
            int month = 10;
            int day = 26 + borrowingDays();
            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            while (day > daysInMonth[month - 1]) {
                day -= daysInMonth[month - 1];
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }

    private static class Book extends LibraryItem {
        Book(String title) { super(title); }
        @Override int borrowingDays() { return 14; }
    }

    private static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        @Override int borrowingDays() { return 7; }
    }

    private static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        @Override int borrowingDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        LibraryItem[] items = new LibraryItem[count];

        for (int i = 0; i < count; i++) {
            String line = input.nextLine().trim();
            int separator = line.indexOf(' ');
            String type = line.substring(0, separator);
            String title = line.substring(separator + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new Dvd(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}
