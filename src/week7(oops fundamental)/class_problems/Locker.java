public final class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        if (combinationCode == null || combinationCode.isEmpty()) {
            throw new IllegalArgumentException("Combination code cannot be empty");
        }
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!combinationCode.equals(currentCode) || newCode == null || newCode.isEmpty()) {
            return false;
        }
        combinationCode = newCode;
        return true;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("Correct code accepted: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong code accepted: " + locker.changeCode("0000", "9999"));
    }
}