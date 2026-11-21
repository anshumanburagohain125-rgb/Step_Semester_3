import java.util.Scanner;

public class LateComersInLine {
    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    // Time: O(1).
    public static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    // Time: O(n), because the chain must be walked to its end.
    public static Node addLast(Node head, String name) {
        Node node = new Node(name);
        if (head == null) {
            return node;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return head;
    }

    private static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startingCount = input.nextInt();
        Node head = null;

        for (int i = 0; i < startingCount; i++) {
            head = addLast(head, input.next());
        }

        int operationCount = input.nextInt();
        for (int i = 0; i < operationCount; i++) {
            String operation = input.next();
            String name = input.next();

            if (operation.equals("addFirst")) {
                head = addFirst(head, name);
            } else if (operation.equals("addLast")) {
                head = addLast(head, name);
            }
        }

        printLine(head);
    }
}
