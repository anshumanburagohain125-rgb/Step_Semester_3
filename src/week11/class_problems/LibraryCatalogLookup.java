public class LibraryCatalogLookup {
    // Binary search: O(log n) per query, O(1) additional space.
    // Keeping the catalog sorted makes repeated queries much faster than scanning it.
    public static String findBook(String[][] catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = catalog[middle][0].compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog[middle][1];
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            { "0001112223", "Introduction to Algebra" },
            { "0002223334", "Beginning Python" },
            { "0003334445", "Classic Mythology" },
            { "0004445556", "Data and Society" },
            { "0005556667", "European History" }
        };

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
