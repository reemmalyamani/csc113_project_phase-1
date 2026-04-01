public class Vanilla extends Cake {
  private String topping;
 
  public Vanilla (String type, String size, int layers, String topping){
    super (type, size,layers);
    this.topping= topping;
   
  }
  public Vanilla (Vanilla v) {
    //recives object 
    super (v); // v instead of v.type, v.size  so it uses the copy construcrtor 
    this.topping= v.topping;
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
  
    public boolean isSame(Cake c){
          if(!(c instanceof Vanilla)) return false;
          Vanilla other= (Vanilla)c;
          return super.isSame(c) && this.topping.equalsIgnoreCase(other.topping);
          
      
    }
@Override
public void displayInfo() {
 

    super.displayInfo(); // print basic cake info (inherited)
      
    System.out.println("Topping: " + topping);
    
}

}

