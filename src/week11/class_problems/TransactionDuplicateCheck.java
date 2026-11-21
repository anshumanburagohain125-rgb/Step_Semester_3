import java.util.HashSet;

public class TransactionDuplicateCheck {
    // Average time: O(n); additional space: O(n).
    // A nested-loop alternative uses O(1) extra space but takes O(n^2) time.
    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<String>();

        for (int i = 0; i < transactionIds.length; i++) {
            if (seen.contains(transactionIds[i])) {
                return true;
            }
            seen.add(transactionIds[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] first = { "TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004" };
        String[] second = { "TXN2001", "TXN2002", "TXN2003" };

        System.out.println(hasDuplicate(first));
        System.out.println(hasDuplicate(second));
    }
}
