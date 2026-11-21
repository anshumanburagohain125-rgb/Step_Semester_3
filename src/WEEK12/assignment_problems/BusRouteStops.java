import java.util.Scanner;

public class BusRouteStops {
    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    // Time: O(n) to build the route.
    public static Node build(String[] stops) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < stops.length; i++) {
            Node node = new Node(stops[i]);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }

    // Time: O(n) to print the route.
    public static void printRoute(Node head) {
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
        String[] stops = new String[count];

        for (int i = 0; i < count; i++) {
            stops[i] = input.next();
        }

        Node head = build(stops);
        printRoute(head);

        int stopCount = 0;
        String first = head == null ? "None" : head.data;
        String last = first;
        Node current = head;

        while (current != null) {
            stopCount++;
            last = current.data;
            current = current.next;
        }

        System.out.println("Stops: " + stopCount + ", First: " + first + ", Last: " + last);
    }
}
