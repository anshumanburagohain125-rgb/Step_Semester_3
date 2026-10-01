public final class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("Full name cannot be null");
        }

        String[] nameParts = fullName.split(" ", -1);
        if (nameParts.length != 2 || nameParts[0].isEmpty() || nameParts[1].isEmpty()) {
            throw new IllegalArgumentException("Full name must contain a first and last name");
        }

        firstName = nameParts[0];
        lastInitial = nameParts[1].substring(0, 1);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}