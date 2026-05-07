import java.util.*;
import java.io.*;
public class TestClass {
public static void main (String [] args ) {

    int choice;
    Order O=null;


  Scanner input = new Scanner (System.in);
  //Bakery components//
Bakery b1 = new Bakery("Cakes and more", "Riyadh", 4) ;
Employee e1 = new Employee ("Hatoon" , 80, 4000);
Employee e2 = new Employee ("Sara" , 40, 2200);
b1.addEmployee(e1);
b1.addEmployee(e2);
Cake c1 = new Chocolate("Chocolate", "Small", 2, true);
Cake c2 = new Vanilla("Vanilla", "Medium", 1, "Caramel");
Cake c3 = new redVelvet("Red Velvet", "Large", 3, false, "premium");
Cake c4 = new Vanilla("Vanilla", "Small", 2, "Strawberry");
Cake c5 = new Chocolate("Chocolate", "Large", 4, false);
b1.addCake(c1);
b1.addCake(c2);
b1.addCake(c3);
b1.addCake(c4);
b1.addCake(c5);





//customer //

  b1.welcoming ();

System.out.println("Enter your name: ");
String name=input.nextLine();
System.out.println("Enter your phone number:");
String phone=input.next();
System.out.println("How many years you have been a customer for our bakery?");
int loyalyears=input.nextInt();
Customer C1=new  Customer(name,phone,loyalyears);

do { 
 
System.out.println("Choose from list:");
System.out.println("1-Make an order");
System.out.println("2-Done ordering ");
choice=input.nextInt();

//new do while to create order
switch (choice){

case 1: 
System.out.println("How many cakes you want to add?");
int nuOfcakes=input.nextInt();
 O=new Order(nuOfcakes);
 int x=0;
int n;
do{
  System.out.println("Choose from menu:");
                        System.out.println("1-Customize order");
                        System.out.println("2-Choose a cake from bakery");
                        System.out.println("3-Remove a cake from order");
                        System.out.println("0-Exit");
                        n = input.nextInt();

Cake c=null;

//to choose cake

switch(n){

    case 1:
      System.out.println("Choose type (Chocolate/Vanilla/Redvelvet) ");
     
      String ctype= input.next();
      System.out.println("Enter size (Small/Medium/Large): ");
        String cSize = input.next();

        System.out.println("Enter number of layers: ");
        int cLayers = input.nextInt();
        
    //chocolate 
        if(ctype.equalsIgnoreCase("Chocolate")){
          System.out.println("Extra chocolate? (Y/N): ");
        boolean extra = false;
        char ch0 = input.next().charAt(0);
          if (ch0 =='y'||ch0=='Y') 
            extra=true; 
          else if(ch0=='n'||ch0=='N') 
            extra=false; 
          else System.out.println ("Invalid input");

        c = new Chocolate("Chocolate", cSize, cLayers, extra); }  

    //vanilla
        else if(ctype.equalsIgnoreCase("Vanilla")){
         System.out.println("Enter topping (Caramel/Strawberry/Chocolate): ");
            try{ String topping=input.next();
         c=new Vanilla("Vanilla",cSize,cLayers ,topping);}}

       //Redvelvet
         else if(ctype.equalsIgnoreCase("Redvelvet")){
          System.out.println("Extra chocolate? (Y/N): ");
          boolean rExtra=false;
          char ch = input.next().charAt(0);
          if (ch =='y'||ch=='Y') 
            rExtra=true; 
          else if(ch=='n'||ch=='N') 
            rExtra=false; 
          else System.out.println ("Invalid input");

        System.out.println("Enter dye type (premium/standard/other): ");
        String dye = input.next();
         c = new redVelvet("Red Velvet", cSize, cLayers, rExtra, dye);

         }
         else System.out.println("Invalid type ");
 if (c != null) 
    x=handleCake(c,O,x); //method to do the rebated command


        break;

    case 2:
        System.out.println("Choose from available cakes");
        System.out.println("1-Chocolate cake,size small,2 layers,extra coco");
        System.out.println("2-Vanilla cake, size medium, one layer with caramel topping");
        System.out.println("3-Red Velvet cake, size Large, 3 layers without extra coco premium dye");
        System.out.println("4-Vanilla cake, size small, 2 layer with Strawberry topping");
        System.out.println("5-Chocolate cake , size Large,4 layers without extra coco");
        int Ava= input.nextInt();
        if(Ava==1){
            x=handleCake(c1,O,x);
                        }
        else if(Ava==2){
            x=handleCake(c2,O,x);
        }
          else if(Ava==3){
            x=handleCake(c3,O,x);
        }
          else if(Ava==4){
            x=handleCake(c4,O,x);
        }
         else if(Ava==5){
            x=handleCake(c5,O,x);
        }
        else  System.out.println("invalid");
        break;
// If user wants to remove cake
    case 3:
      if(O!=null && x>0){
       System.out.println("Choose which cake you want to remove");
        System.out.println("1-Chocolate cake,size small,2 layers,extra coco");
        System.out.println("2-Vanilla cake, size medium, one layer with caramel topping");
        System.out.println("3-Red Velvet cake, size Large, 3 layers without extra coco premium dye");
        System.out.println("4-Vanilla cake, size small, 2 layer with Strawberry topping");
        System.out.println("5-Chocolate cake , size Large,4 layers without extra coco");
        int remove= input.nextInt();
        if(remove==1){
            x=removeCake(c1,O,x);
                        }
        else if(remove==2){
            x=removeCake(c2,O,x);
        }
          else if(remove==3){
            x=removeCake(c3,O,x);
        }
          else if(remove==4){
            x=removeCake(c4,O,x);
        }
         else if(remove==5){
            x=removeCake(c5,O,x);
        }
        else  System.out.println("Invalid");}
        else System.out.println("No cakes in order to remove ");
        break;

    case 0:
        System.out.println("Exiting..");

        break;
    
        default:
            System.out.println("Invalid choice");



}
if(x==nuOfcakes) System.out.println("You have reached the maximum number of cakes you chosen for this order do another order if you want more");
}while(n!=0 && x<nuOfcakes);
if (x > 0) {  C1.addOrder(O);
                    } else {
                        System.out.println("No cakes were added. Order was canceled.");
                    }
break;

case 2: System.out.println("Thank you for choosing us! ");

        break;

        default:System.err.println("Invalid");

}} while (choice!=2);
FileManager.SaveOrders(C1.getOrders());
e1.billprint(C1, FileManager.readOrders());
e1.calculateBill(C1);
while (true)
    try {
    System.out.println ("Enter a rating from 1 to 5" );
        int review = input.nextInext();
        if (review < 0 ||  review >5 ){
            throw new RuntimeException(); }
        break;
}
catch (RuntimeException ) {
   System.out.println ("The review you entered is invaid, please enter it again"); 
    review = input.nextInext(); 
    input.nextLine(); //cleaning garbage line
}

}



public static int handleCake(Cake C,Order O,int x){
  double price = C.CalculatePrice();  
                            System.out.println("\nFinal Price based on choices: " + price);

                             if (O.searchCake(C)) {  
                              
        System.out.println("This cake is already in your order.");}

                  else{ if (O.addCake(C)) {
                                x++;
                                /*C.displayInfo();*/
                            } else {
                                System.out.println("Cannot add more cakes, order is full.");
                            }}
                       return x; }

public static int removeCake(Cake C,Order O,int x)
{
if(O.removeCake(C)) {
  System.out.println("Cake removed successfully");
  x--;
}
else  System.out.println("Nothing to  remove");

return x;
}

}
