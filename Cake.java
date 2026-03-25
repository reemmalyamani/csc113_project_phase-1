public abstract class Cake implements Discount{
    protected String type;
    protected double price;
    protected String size;

    // Constructor
    public Cake(String type, String size) {
        this.type = type;
        this.size = size;
    }

    // Copy Constructor
    public Cake(Cake c) {
        this.type = c.type;
        this.size = c.size;
        this.price = c.price;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method then subclasses MUST implement
    public abstract double CalculatePrice();

    // Discount method
    public double getDiscount(int loyalYears) {
        if (loyalYears >= 5) {
            return price * 0.10; // 10% discount
        }
        return 0;
    }

    // Display info
    public void displayInfo(int loyalYears) {
        double discount = getDiscount(loyalYears);
        double finalPrice = price - discount;

        System.out.println("Type: " + type);
        System.out.println("Size: " + size);
        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }
}
