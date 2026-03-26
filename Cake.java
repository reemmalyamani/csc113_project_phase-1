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
   public double getDiscount() {
        if (this.size.equalsIgnoreCase("Large")) {
            return price * 0.10; // 10% discount
        }
        return 0;
    }//overide interface method


    // Display info
    public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.println("Type: " + type+"--- Size:"+ size+"\nOriginal Price: " + price+"---Discount:" + discount+"Final Price: " + finalPrice);

    
       
    }
}
