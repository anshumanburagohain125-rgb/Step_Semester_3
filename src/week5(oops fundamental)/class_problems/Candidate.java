import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate() {
        this("Unknown", 0, 0);
    }

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] finalList = new Candidate[count];
        for (int i = 0; i < count; i++) {
            finalList[i] = shortlisted[i];
        }
        Arrays.sort(finalList);

        String result = "";
        for (int i = 0; i < finalList.length; i++) {
            result = result + (i + 1) + ". " + finalList[i].name + " ("
                    + finalList[i].getCompositeScore() + ")";
            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
