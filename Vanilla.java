import java.util.Scanner;
public class Vanilla extends Cake {
  private String topping;
  Scanner input = new Scanner (System.in);
  public Vanilla (String type, String size, int layers, String topping)   {
    super (type, size,layers);
    while (true)
      try{
      if ( (topping.equalsIgnoreCase("chocolate")) ||(topping.equalsIgnoreCase("strawberry")) ||(topping.equalsIgnoreCase("caramel"))  ) {
      this.topping= topping;
      break;
      } 
      }
   catch (InvalidToppingException e ) {
      System.out.println ("The cake you typed in is invalid, please try again");
     topping= input.next();
     
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
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.printf("Type: %s Size: %s  layers: %d topping: %s %nOriginal Price: %.2f  Discount: %.2f Final Price: %.2f%n ", type,size,layers,topping,price,discount,finalPrice );

    
       
}
//override to use in file
     public String getInfo(){
 double discount = getDiscount();
 double finalPrice = price - discount;
 String str="";
 str+="\nType: "+ type+"\nSize: "+size+"\nlayers:"+layers+"\ntopping: "+topping+"\noriginal price: "+price+"\nDiscount: "+discount+"\nfinal price: "+finalPrice;
 return str;
 }
}

