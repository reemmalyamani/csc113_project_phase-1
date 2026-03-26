public class Chocolate extends Cake{
  protected int layers;
  private boolean extra; 
  
  public Chocolate (String type, String size, int layers, boolean extra) {
    super (type, size);
    this.layers= layers;  //layers should be inherited ?
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

  public double CalculatePrice (){  //calculated prices based on size and added toppings
    price =0;
    if (size.equalsIgnoreCase("small")) {
            price = 25;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 35;
        } else if (size.equalsIgnoreCase("large")) {
            price = 45;
        }

        price += layers * 5;

        if (this.extra) {
            price += 8;
        }


        return price;
  }// close abstract Calculate price
 
  public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.println("Type: " + type+"--- Size:"+ size+"layers:"+layers+"\nOriginal Price: " + price+"---Discount:" + discount+"Final Price: " + finalPrice);

    
       
    }
}
