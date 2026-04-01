public class Chocolate extends Cake{

  private boolean extra; 
  
  public Chocolate (String type, String size, int layers, boolean extra) {
    super (type, size,layers);
    
    this.extra = extra;
    this.price = 0;
    
  }//close constructor
  public Chocolate (Chocolate c) {
    super (c.type, c.size,c.layers);
   
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
 

    public boolean isSame(Cake c){
          if(!(c instanceof Chocolate)) return false;
          Chocolate other= (Chocolate)c;
          return super.isSame(c) && this.extra== other.extra;
          
      
    }

 
         public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.printf("Type: %s Size: %s  layers: %d Extra coco: %b%nOriginal Price: %.2f  Discount: %.2f Final Price: %.2f%n ", type,size,layers,exta,price,discount,finalPrice );

    
  
    }
}
