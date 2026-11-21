import java.util.Scanner;

public class BookCopyFinder {
    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    private static Node build(String[] bookIds) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < bookIds.length; i++) {
            Node node = new Node(bookIds[i]);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    // Time: O(n), because a chain must be searched node by node.
    public static String find(Node head, String id) {
        int position = 0;
        int firstPosition = 0;
        int copies = 0;
        Node current = head;

        while (current != null) {
            position++;
            if (current.data.equals(id)) {
                if (copies == 0) {
                    firstPosition = position;
                }
                copies++;
            }
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        String[] bookIds = new String[count];

        for (int i = 0; i < count; i++) {
            bookIds[i] = input.next();
        }

        String target = input.next();
        System.out.println(find(build(bookIds), target));
    }
}
