public final class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Piggy bank ID cannot be empty");
        }
        this.id = id;
        savings = 0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }
        savings += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public static void main(String[] args) {
        PiggyBank piggyBank = new PiggyBank("PB-1");
        piggyBank.deposit(100);
        System.out.println("Savings after deposit: " + piggyBank.getSavings());
        piggyBank.withdraw(30);
        System.out.println("Savings after withdrawal: " + piggyBank.getSavings());

        boolean withdrawalAccepted = piggyBank.withdraw(500);
        System.out.println("Large withdrawal accepted: " + withdrawalAccepted);
        System.out.println("Final savings: " + piggyBank.getSavings());
    }
}public final class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Piggy bank ID cannot be empty");
        }
        this.id = id;
        savings = 0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }
        savings += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public static void main(String[] args) {
        PiggyBank piggyBank = new PiggyBank("PB-1");
        piggyBank.deposit(100);
        System.out.println("Savings after deposit: " + piggyBank.getSavings());
        piggyBank.withdraw(30);
        System.out.println("Savings after withdrawal: " + piggyBank.getSavings());

        boolean withdrawalAccepted = piggyBank.withdraw(500);
        System.out.println("Large withdrawal accepted: " + withdrawalAccepted);
        System.out.println("Final savings: " + piggyBank.getSavings());
    }
}