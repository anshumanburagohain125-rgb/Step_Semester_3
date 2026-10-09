import java.util.Locale;
import java.util.Scanner;

public class ExaminationQuestionGrader {
    private abstract static class Question {
        private final String questionText;
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        Question(String questionText, String correctAnswer, String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        String correctAnswer() { return correctAnswer; }
        String studentAnswer() { return studentAnswer; }
        double points() { return points; }
        abstract double score();
        abstract String type();
    }

    private static class Mcq extends Question {
        Mcq(String text, String correct, String answer, double points) {
            super(text, correct, answer, points);
        }
        @Override double score() {
            return studentAnswer().equals(correctAnswer()) ? points() : 0;
        }
        @Override String type() { return "MCQ"; }
    }

    private static class TrueFalse extends Question {
        TrueFalse(String text, String correct, String answer, double points) {
            super(text, correct, answer, points);
        }
        @Override double score() {
            return studentAnswer().equals(correctAnswer()) ? points() : 0;
        }
        @Override String type() { return "TF"; }
    }

    private static class Essay extends Question {
        Essay(String text, String correct, String answer, double points) {
            super(text, correct, answer, points);
        }

        @Override double score() {
            String[] keywords = correctAnswer().split(",");
            String answer = studentAnswer().toLowerCase(Locale.ROOT);
            int matches = 0;

            for (String keyword : keywords) {
                String word = keyword.trim().toLowerCase(Locale.ROOT);
                if (!word.isEmpty() && answer.contains(word)) {
                    matches++;
                }
            }
            if (matches >= 2) return points() * 0.75;
            if (matches == 1) return points() * 0.50;
            return 0;
        }

        @Override String type() { return "ESSAY"; }
    }

    private static String[] readQuotedFields(String line) {
        String[] fields = new String[5];
        int field = 0;
        int position = 0;

        while (position < line.length() && field < fields.length) {
            while (position < line.length() && Character.isWhitespace(line.charAt(position))) {
                position++;
            }

            if (line.charAt(position) == '"') {
                int start = ++position;
                while (position < line.length() && line.charAt(position) != '"') {
                    position++;
                }
                fields[field++] = line.substring(start, position);
                position++;
            } else {
                int start = position;
                while (position < line.length() && !Character.isWhitespace(line.charAt(position))) {
                    position++;
                }
                fields[field++] = line.substring(start, position);
            }
        }
        return fields;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        Question[] questions = new Question[count];

        for (int i = 0; i < count; i++) {
            String[] fields = readQuotedFields(input.nextLine());
            String type = fields[0].toUpperCase(Locale.ROOT);
            String text = fields[1];
            String correct = fields[2];
            String answer = fields[3];
            double points = Double.parseDouble(fields[4]);

            if (type.equals("MCQ")) {
                questions[i] = new Mcq(text, correct, answer, points);
            } else if (type.equals("TF")) {
                questions[i] = new TrueFalse(text, correct, answer, points);
            } else {
                questions[i] = new Essay(text, correct, answer, points);
            }
        }

        double total = 0;
        for (Question question : questions) {
            double score = question.score();
            System.out.printf(Locale.US, "%s: %.2f%n", question.type(), score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
