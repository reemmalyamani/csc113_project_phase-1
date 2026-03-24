public abstract class Cake {
  protected String type;
  protected double price;
  protected String size;

  public Cake (String type, String size) { 
    this.type= type;
    this.size = size;
  }
  public Cake (Cake c) {
    
  }//what is the purpose of this method?
  public CalculatePrice () {} //what is the return method here 
  public double getDiscount () {}
  public void displayinfo (){
    System.out.println (""); 
  } //close display
}//close cake
