public class LibraryBookShelf {
    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int position = i;

            while (position > 0 && books[position - 1] > newBook) {
                books[position] = books[position - 1];
                position--;
            }

            books[position] = newBook;
            System.out.print("After placing " + newBook + ": ");
            printArray(books);
        }
    }

    private static void printArray(int[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("Sample:");
        shelf(new int[] { 30, 10, 40, 20 });

        System.out.println("Additional test:");
        shelf(new int[] { 9, 3, 7, 1 });
    }
}
