import java.util.*;
public class TestClass {
public static void main (String [] args ) {
  Scanner input = new Scanner (System.in);
Bakery b1 = new Bakery ;
  b1.welcoming ();
  do{
    System.out.println ("choose bla bla bla "); // Write menu here
  
int choice = input.nextInt();
  Cake c = null; //declare because Cake is abstract so you can't create objects the same way we usually do!
    switch (choice ) {
    case 3: //Chocolate
      System.out.println("Enter size (Small/Medium/Large): ");
        String cSize = input.next();

        System.out.println("Enter number of layers: ");
        int layers = input.nextInt();

        System.out.println("Extra chocolate? (true/false): ");
        boolean extra = input.nextBoolean();
//Calculate price method goes here
        c = new Chocolate("Chocolate", cSize, layers, extra);
        break;
    case 4: //Red Velvet
         System.out.println("Enter size (Small/Medium/Large): ");
        String rSize = input.next();

        System.out.println("Enter number of layers: ");
        int rLayers = input.nextInt();

        System.out.println("Extra chocolate? (true/false): ");
        boolean rExtra = input.nextBoolean();

        System.out.println("Enter dye color: ");
        String dye = input.next();
         c = new RedVelvet("Red Velvet", rSize, rLayers, rExtra, dye);
        // Calculate price method goes here 
        break;
    case 0 :
        System.out.println ("Exiting...");
          break;
    default:
    System.out.println ("Invalid choice"); } // close switch
  }//close do while
    while (choice !=0) 
// create employee object
    Employee e1 = new Employee ("Hatoon" , 80, 4000);
    Employee e2 = new Employee ("Sara" , 40, 2200);
} //close main 
}//close test class 
