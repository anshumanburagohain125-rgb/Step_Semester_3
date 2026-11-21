import java.util.Scanner;

public class CancelBooking {
    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    private static Node build(String[] bookings) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < bookings.length; i++) {
            Node node = new Node(bookings[i]);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    // O(1) if the booking is at the head; O(n) if it is at the end or absent.
    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            return null;
        }
        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(booking)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }

    private static boolean contains(Node head, String booking) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(booking)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static void printBookings(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        String[] bookings = new String[count];

        for (int i = 0; i < count; i++) {
            bookings[i] = input.next();
        }

        String bookingToCancel = input.next();
        Node head = build(bookings);

        if (!contains(head, bookingToCancel)) {
            System.out.println(bookingToCancel + " not found");
        } else {
            head = removeFirst(head, bookingToCancel);
        }
        printBookings(head);
    }
}
