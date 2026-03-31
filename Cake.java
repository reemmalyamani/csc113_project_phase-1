public abstract class Cake implements Discount{
    protected String type;
    protected double price;
    protected String size;
    protected int layers;

    // Constructor
    public Cake(String type, String size,int layers) {
        this.type = type;
        this.size = size;
        this.layers=layers;
    }

    // Copy Constructor
    public Cake(Cake c) {
        this.type = c.type;
        this.size = c.size;
        this.price = c.price;
        this.layers=c.layers;
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
    @Override
   public double getDiscount() {
        if (this.size.equalsIgnoreCase("Large")) {
            return price * 0.10; // 10% discount
        }
        return 0;
    }//override interface method

    public boolean isSame(Cake c){
      return this.type.equalsIgnoreCase(c.type) && this.size.equalsIgnoreCase(c.size)&& this.layers==layers;}

    // Display info
    public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.print("Type: " + type+"  Size:"+ size+"\nOriginal Price: " + price+"  Discount:" + discount+"  Final Price: " + finalPrice);

    
       
    }
}
