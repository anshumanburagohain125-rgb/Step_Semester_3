class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance; starting at 0.0");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be positive");
        } else if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class M2MessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}