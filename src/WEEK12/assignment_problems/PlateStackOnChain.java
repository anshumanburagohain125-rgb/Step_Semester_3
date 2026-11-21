import java.util.Scanner;

public class PlateStackOnChain {
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    private static class PlateStack {
        private Node top;
        private int size;

        // O(1).
        void push(String plate) {
            Node node = new Node(plate);
            node.next = top;
            top = node;
            size++;
        }

        // O(1); returns null when empty.
        String pop() {
            if (isEmpty()) {
                return null;
            }

            String plate = top.data;
            top = top.next;
            size--;
            return plate;
        }

        // O(1); returns null when empty.
        String peek() {
            return isEmpty() ? null : top.data;
        }

        // O(1).
        boolean isEmpty() {
            return top == null;
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (input.hasNextLine()) {
            text.append(input.nextLine()).append('\n');
        }

        String[] operations = text.toString().split("[,\\r\\n]+");
        PlateStack stack = new PlateStack();

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i].trim();
            if (operation.length() == 0) {
                continue;
            }

            if (operation.startsWith("push(") && operation.endsWith(")")) {
                String plate = operation.substring(5, operation.length() - 1).trim();
                stack.push(plate);
                System.out.println("push " + plate + " -> top " + stack.peek()
                        + ", size " + stack.size());
            } else if (operation.equals("peek()")) {
                String plate = stack.peek();
                System.out.println(plate == null ? "peek -> stack is empty" : "peek -> " + plate);
            } else if (operation.equals("pop()")) {
                String plate = stack.pop();
                if (plate == null) {
                    System.out.println("pop -> stack is empty");
                } else {
                    System.out.println("pop -> " + plate + ", size " + stack.size());
                }
            } else if (operation.equals("isEmpty()")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            } else {
                System.out.println("invalid operation");
            }
        }
    }
}
