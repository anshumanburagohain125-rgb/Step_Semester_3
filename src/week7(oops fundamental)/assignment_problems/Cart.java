public final class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        if (cartId == null || cartId.isBlank()) {
            throw new IllegalArgumentException("Cart ID cannot be empty");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.cartId = cartId;
        itemPrices = new double[capacity];
    }

    public boolean addItem(double price) {
        if (!Double.isFinite(price) || price < 0 || itemCount == itemPrices.length) {
            return false;
        }
        itemPrices[itemCount++] = price;
        return true;
    }

    public double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) {
            total += itemPrices[index];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.printf("Total: %.0f%n", cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}