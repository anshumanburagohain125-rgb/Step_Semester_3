import java.util.Scanner;

public class ParcelShippingDesk {
    private interface Insurable {
        double insuranceAmount();
    }

    private abstract static class Parcel {
        private final double weight;
        private final double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        double weight() { return weight; }
        double declaredValue() { return declaredValue; }
        abstract double shippingCharge();
        abstract String type();

        double insurance() {
            if (this instanceof Insurable) {
                return ((Insurable) this).insuranceAmount();
            }
            return 0;
        }

        final double totalCharge() {
            return shippingCharge() + insurance();
        }
    }

    private static class StandardParcel extends Parcel {
        StandardParcel(double weight, double value) { super(weight, value); }
        @Override double shippingCharge() { return 40 + weight() * 10; }
        @Override String type() { return "STANDARD"; }
    }

    private static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weight, double value) { super(weight, value); }
        @Override double shippingCharge() { return 80 + weight() * 15; }
        @Override public double insuranceAmount() { return declaredValue() * 0.02; }
        @Override String type() { return "EXPRESS"; }
    }

    private static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double weight, double value) { super(weight, value); }
        @Override double shippingCharge() { return 40 + weight() * 10 + 50; }
        @Override public double insuranceAmount() { return declaredValue() * 0.02; }
        @Override String type() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Parcel[] parcels = new Parcel[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            double weight = input.nextDouble();
            double value = input.nextDouble();

            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, value);
            } else {
                parcels[i] = new FragileParcel(weight, value);
            }
        }

        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.shippingCharge();
            double insurance = parcel.insurance();
            double total = parcel.totalCharge();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
