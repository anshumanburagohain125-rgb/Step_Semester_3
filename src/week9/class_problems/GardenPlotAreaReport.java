import java.util.Scanner;

public class GardenPlotAreaReport {
    private abstract static class Plot {
        private final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        String owner() {
            return owner;
        }

        abstract double area();
        abstract String shape();
    }

    private static class Circle extends Plot {
        private final double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override double area() { return Math.PI * radius * radius; }
        @Override String shape() { return "CIRCLE"; }
    }

    private static class Rectangle extends Plot {
        private final double length;
        private final double width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override double area() { return length * width; }
        @Override String shape() { return "RECTANGLE"; }
    }

    private static class Triangle extends Plot {
        private final double base;
        private final double height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override double area() { return 0.5 * base * height; }
        @Override String shape() { return "TRIANGLE"; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Plot[] plots = new Plot[count];

        for (int i = 0; i < count; i++) {
            String shape = input.next().toUpperCase();
            String owner = input.next();

            if (shape.equals("CIRCLE")) {
                plots[i] = new Circle(owner, input.nextDouble());
            } else if (shape.equals("RECTANGLE")) {
                plots[i] = new Rectangle(owner, input.nextDouble(), input.nextDouble());
            } else {
                plots[i] = new Triangle(owner, input.nextDouble(), input.nextDouble());
            }
        }

        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            System.out.printf("%s (%s): %.2f%n", plot.owner(), plot.shape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
