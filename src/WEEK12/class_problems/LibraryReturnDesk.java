import java.util.Scanner;

class BookPile {
    private final String[] books = new String[3];
    private int top = -1;

    String add(String book) {
        if (top == books.length - 1) {
            return book + " rejected: pile is full";
        }

        top++;
        books[top] = book;
        return book + " placed on pile";
    }

    String remove() {
        if (top == -1) {
            return "pile is empty";
        }

        String book = books[top];
        books[top] = null;
        top--;
        return "shelved " + book;
    }
}

class StudentLine {
    private final String[] students = new String[3];
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    String add(String student) {
        if (size == students.length) {
            return student + " rejected: line is full";
        }

        students[rear] = student;
        rear = (rear + 1) % students.length;
        size++;
        return student + " joined the line";
    }

    String remove() {
        if (size == 0) {
            return "no one waiting";
        }

        String student = students[front];
        students[front] = null;
        front = (front + 1) % students.length;
        size--;
        return "served " + student;
    }
}

public class LibraryReturnDesk {
    // Each stack and queue operation takes O(1) time.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder commandsText = new StringBuilder();

        while (input.hasNextLine()) {
            commandsText.append(input.nextLine()).append('\n');
        }

        String[] commands = commandsText.toString().split("[,\\r\\n]+");
        BookPile pile = new BookPile();
        StudentLine line = new StudentLine();

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i].trim();
            if (command.length() == 0) {
                continue;
            }

            String[] parts = command.split("\\s+");
            String result;
            if (parts[0].equals("RETURN") && parts.length > 1) {
                result = pile.add(parts[1]);
            } else if (parts[0].equals("SHELVE")) {
                result = pile.remove();
            } else if (parts[0].equals("WAIT") && parts.length > 1) {
                result = line.add(parts[1]);
            } else if (parts[0].equals("SERVE")) {
                result = line.remove();
            } else {
                result = "invalid command";
            }

            System.out.println(result);
        }
    }
}
