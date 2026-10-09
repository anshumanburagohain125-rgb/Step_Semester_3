import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    private abstract static class Plan {
        private final String name;
        private final LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        String name() { return name; }
        LocalDate startDate() { return startDate; }
        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate().plusDays(validityDays());
        }
    }

    private static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override int validityDays() { return 30; }
    }

    private static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override int validityDays() { return 90; }
    }

    private static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Plan[] plans = new Plan[count];

        for (int i = 0; i < count; i++) {
            String type = input.next().toUpperCase();
            String name = input.next();
            LocalDate startDate = LocalDate.parse(input.next());

            if (type.equals("BASIC")) {
                plans[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plans[i] = new StandardPlan(name, startDate);
            } else {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (Plan plan : plans) {
            System.out.println(plan.name() + ": " + plan.renewalDate());
        }
    }
}
