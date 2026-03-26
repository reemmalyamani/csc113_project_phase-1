public class redVelvet extends Chocolate {
  private String dye;
  public redVelvet(String type, String size, int layers, boolean extra, String dye) {
        super(type, size, layers, extra);
        this.dye = dye;
    }
  public redVelvet(redVelvet r) {
        super(r);  // calls Chocolate copy constructor
        this.dye = r.dye;
    }
  public double addDyeCost() {
        double extraCost = 0;

        if (dye.equalsIgnoreCase("premium")) {
            extraCost = 10;
        } else if (dye.equalsIgnoreCase("standard")) {
            extraCost = 5;
        } else {
            extraCost = 2;
        }

        return extraCost;
    }

    
    public double CalculatePrice() {
         this.price = super.CalculatePrice();
        this.price += addDyeCost();
        return price;
    }

     public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.println("Type: " + type+"--- Size:"+ size+"dye:"+dye+"\nOriginal Price: " + price+"---Discount:" + discount+"Final Price: " + finalPrice);

    
       
    }
}
//close red velvet
