public final class TrafficLight {
    private enum Color {
        RED,
        GREEN,
        YELLOW
    }

    private final String id;
    private Color color;

    public TrafficLight(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Traffic light ID cannot be empty");
        }
        this.id = id;
        color = Color.RED;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color.name();
    }

    public void next() {
        switch (color) {
            case RED -> color = Color.GREEN;
            case GREEN -> color = Color.YELLOW;
            case YELLOW -> color = Color.RED;
        }
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getColor());
        light.next();
        System.out.println(light.getColor());
        light.next();
        System.out.println(light.getColor());
        light.next();
        System.out.println(light.getColor());
    }
}