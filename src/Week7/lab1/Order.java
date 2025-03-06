package Week7.lab1;

public class Order extends Fruit{
    private  String name;
    private double amount;

    public Order(int fruitId, String fruitName, String origin, int quantity, double price, String name,double amount) {
        super(fruitId, fruitName, origin, quantity, price);
        this.name = name;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
