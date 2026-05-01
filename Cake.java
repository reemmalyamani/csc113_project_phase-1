

import java.io.*;
public abstract class Cake implements Discount,Serializable{
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
      return this.type.equalsIgnoreCase(c.type) && this.size.equalsIgnoreCase(c.size)&& this.layers==c.layers;}

    // Display info
    public void displayInfo() {
        double discount = getDiscount();
        double finalPrice = price - discount;

        System.out.printf("Type: %s Size: %s  layers: %d %nOriginal Price: %.2f  Discount: %.2f Final Price: %.2f%n ", type,size,layers,price,discount,finalPrice );

    
       
    }
 //get info method to use with file
 public String getInfo(){
 double discount = getDiscount();
 double finalPrice = price - discount;
 String str="";
 str+="\nType: "+ type+"\nSize: "+size+"\nlayers:"+layers+"\noriginal price: "+price+"\nDiscount: "+discount+"\nfinal price: "+finalPrice;
 return str;
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
}
