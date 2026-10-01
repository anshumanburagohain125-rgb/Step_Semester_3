public final class Scorecard {
    private final boolean[] answers;
    private int recordedCount;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative");
        }
        answers = new boolean[questionCount];
    }

    public boolean recordAnswer(boolean correct) {
        if (recordedCount == answers.length) {
            return false;
        }
        answers[recordedCount++] = correct;
        return true;
    }

    public int getScore() {
        int score = 0;
        for (int index = 0; index < recordedCount; index++) {
            if (answers[index]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);
        System.out.println("Score: " + scorecard.getScore());
    }
}