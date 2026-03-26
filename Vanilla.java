public class Vanilla extends Cake {
  private String topping;
  private int layers;
  public Vanilla (String type, String size, int layers, String topping){
    super (type, size);
    this.topping= topping;
    this.layers = layers;
  }
  public Vanilla (Vanilla v) {
    //recives object 
    super (v); // v instead of v.type, v.size  so it uses the copy construcrtor 
    this.topping= v.topping;
    this.layers = v.layers;
    this.price = v.price;
  }
 @Override
    public double CalculatePrice() {
        if (size.equalsIgnoreCase("small")) {
            price = 20;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 30;
        } else if (size.equalsIgnoreCase("large")) {
            price = 40;
        } else {
            price = 0;
        }

        if (topping.equalsIgnoreCase("chocolate")) {
            price += 5;
        } else if (topping.equalsIgnoreCase("strawberry")) {
            price += 7;
        } else if (topping.equalsIgnoreCase("caramel")) {
            price += 6;
        }

        price += layers * 4;

        return price;
    }
  
@Override
public void displayInfo() {
    super.displayInfo(); // print basic cake info (inherited)

    System.out.println("Topping: " + topping);
    System.out.println("Layers: " + layers);
}

}
