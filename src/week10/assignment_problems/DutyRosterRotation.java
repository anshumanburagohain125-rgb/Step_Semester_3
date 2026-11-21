public class DutyRosterRotation {
    // Time: O(n); additional space: O(n) for the returned roster.
    public static String[] rotateRoster(String[] names, int k) {
        int size = names.length;
        int shift = k % size;
        String[] rotated = new String[size];

        for (int i = 0; i < size; i++) {
            int newIndex = (i + shift) % size;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = { "A", "B", "C", "D", "E" };
        String[] result = rotateRoster(names, 7);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
