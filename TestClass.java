import java.util.*;
public class TestClass {
public static void main (String [] args ) {

    int choice;
    Order O=null;


  Scanner input = new Scanner (System.in);
  Bakery b1 = new Bakery("Cakes and more", "Riyadh", 4) ;
  b1.welcoming ();

System.out.println("write your name");
String name=input.next();
System.out.println("your phone number:");
String phone=input.next();
System.out.println("How many years you have been a customer for our bakery?");
int loyalyears=input.nextInt();
Customer C1=new  Customer(name,phone,loyalyears);

do { 
 
System.out.println("Choose from list:");
System.out.println("1-make an order\n 2-done");
choice=input.nextInt();

//new do while to create order
switch (choice){

case 1: 
System.out.println("how many Cakes you want to add?");
int nuOfcakes=input.nextInt();
 O=new Order(nuOfcakes);
int x=0;
int n;
do{
  System.out.println("Choose from menu:");
                        System.out.println("1 - Chocolate cake");
                        System.out.println("2 - Vanilla cake");
                        System.out.println("3 - Red velvet cake");
                        System.out.println("0 - Done");
                        n = input.nextInt();

Cake c=null;

//to choose cake

switch(n){

    case 1://chocolate 
      System.out.println("Enter size (Small/Medium/Large): ");
        String cSize = input.next();

        System.out.println("Enter number of layers: ");
        int clayers = input.nextInt();
        input.nextLine();

        System.out.println("Extra chocolate? (true/false): ");
        boolean extra = input.nextBoolean();
//Calculate price method goes here
        c = new Chocolate("Chocolate", cSize, clayers, extra); 
       double fprice = c.CalculatePrice(); // capture return value
        System.out.println("Final Price based on choices: " + fprice);
          /*  if( O.addCake(c))
              { x++;
         c.displayInfo();}  COMMENT HERE: instead of doing this in each method
         else {
    System.out.println("Cannot add more cakes, order is full."); */ 
} 
        break;

    case 2:// vanilla
        System.out.println("Enter size (Small/Medium/Large): ");
        String vSize = input.next();

        System.out.println("Enter number of layers: ");
        int vLayers = input.nextInt();
        input.nextLine();

         System.out.println("Enter topping (Caramel/strawberry/Chocolate): ");
         String topping=input.next();

         c=new Vanilla("Vanilla",vSize,vLayers,topping);
         double vPrice=c.CalculatePrice();
         System.out.println("Final Price based on choices: " + vPrice);
     /*   if( O.addCake(c))
              { x++;
         c.displayInfo();}
         else {
    System.out.println("Cannot add more cakes, order is full."); 
} */

        break;


    case 3://red velvet
        System.out.println("Enter size (Small/Medium/Large): ");
        String rSize = input.next();

        System.out.println("Enter number of layers: ");
        int rLayers = input.nextInt();

        System.out.println("Extra chocolate? (true/false): ");
        boolean rExtra = input.nextBoolean();

        System.out.println("Enter dye type (premium/standard/other): ");
    String dye = input.next();
         c = new redVelvet("Red Velvet", rSize, rLayers, rExtra, dye);
      
        double rprice = c.CalculatePrice(); 
        System.out.println("Final Price based on choices: " + rprice);
       /*     if( O.addCake(c))
              { x++;
         c.displayInfo();}
         else {
    System.out.println("Cannot add more cakes, order is full.");
} */
  
        break;

    case 0:
        System.out.println("Exiting..");

        break;
    
        default:
            System.out.println("invalid choice");



} // Close first switch
    if (c != null) {
                            double price = c.CalculatePrice();  //@!!!!!!!!!!!!!!!!!
                            System.out.println("Final Price based on choices: " + price);

                            if (O.addCake(c)) {
                                x++;
                                c.displayInfo();
                            } else {
                                System.out.println("Cannot add more cakes, order is full.");
                            }
                        }



}while(n!=0 && x<nuOfcakes);
if (x > 0) {  C1.addOrder(O);
                    } else {
                        System.out.println("No cakes were added. Order was cancelled.");
                    }
break;

case 2: System.out.println("done ");

        break;

        default:System.err.println("invalid");

}} while (choise!=2);

Employee e1 = new Employee ("Hatoon" , 80, 4000);
 Employee e2 = new Employee ("Sara" , 40, 2200);
b1.addEmployee(e1);
b1.addEmployee(e2);
e1.calculateBill(C1);
}
}
