public class Chocolate {
  protected int layers;
  private boolean extra; 
  private double price;
  public Chocolate (String type, String size, int layers, boolean extra) {
    super (type, size);
    this.layers= layers;  //layers should be inherited ?
    this.extra = extra;
    this.extra = extra;
    this.price = 0;
    //i dont know what to do with cocoa
  }//close constructor
  public Chocolate (Chocolate c) {
    super (c.type, c.size);
    this.layers = c.layers;
    this.extra = c.extra;
    this.price = c.price;
  }
  public CalculatePrice (String size, boolean Extra){ //String or int?????
    price =0;
    if (size.equalsIgnoreCase("small")) {
            price = 25;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 35;
        } else if (size.equalsIgnoreCase("large")) {
            price = 45;
        }

        price += layers * 5;

        if (extra) {
            price += 8;
        }

        return price;
  }// close Calculate price
  public double getDiscount (double prec) {
    return price * 0.9;
  } //same as comment about names in class Vanilla
  @Override 
  public String toString (){
     return super.toString() +
    "\nLayers: " + layers +
               "\nExtra cocoa: " + extra +
               "\nPrice: " + price;
  }
}
