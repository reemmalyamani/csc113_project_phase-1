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
    super (v.type, v.size);
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
  public String toString () {
   return "\nTopping: " + topping +
               "\nLayers: " + layers +
               "\nPrice: " + price;
  }//close to string
}
