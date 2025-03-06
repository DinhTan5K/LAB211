package Week7.lab1;

public class Fruit {
    private int fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(int fruitId, String fruitName, String origin, int quantity, double price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-10s | %-10d | %-10.2f | %-10s",
                fruitId,fruitName, quantity, price, origin);
    }

}
