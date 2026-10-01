public final class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be positive");
        }
        this.maxHealth = maxHealth;
        health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        long updatedHealth = (long) health - amount;
        health = (int) Math.max(0, updatedHealth);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        long updatedHealth = (long) health + amount;
        health = (int) Math.min(maxHealth, updatedHealth);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("Health after damage: " + character.getHealth());
        character.heal(50);
        System.out.println("Health after healing: " + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health after heavy damage: " + character.getHealth());
    }
}