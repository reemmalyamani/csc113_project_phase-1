public class redVelvet extends Chocolate {
  private String dye;
  public RedVelvet(String type, String size, int layers, boolean extra, String dye) {
        super(type, size, layers, extra);
        this.dye = dye;
    }
  public RedVelvet(RedVelvet r) {
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

    @Override
    public double calculatePrice() {
        double basePrice = super.calculatePrice();
        basePrice += addDyeCost();
        return basePrice;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nDye: " + dye; }
}//close red velvet
