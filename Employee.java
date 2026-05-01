
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Employee {
   
private String name;
private double workHrs;
private double salary;

public Employee(String name,double workHrs,double salary){
this.name=name;
this.salary=salary;
this.workHrs=workHrs;
}


//this method to print the bill on a txt file

public void billprint(Customer C,Order[]list){
try{
    File F=new File("bill.txt");
    FileOutputStream out=new FileOutputStream(F);
    PrintWriter p=new PrintWriter(out);


     p.println("-----Customer Bill----");
     p.println(C.toString());
    double totalPrice=0;
    for(int i=0;i<list.length;++i){
        totalPrice+=list[i].cakeTotalPrice(0);
p.println("***************");
p.println("Order "+(i+1));
p.println(list[i].getInfo());

    }
    //because we want the discount to be implemented on the givin array
     double discount = 0;
        if (C.getLoyalYears() > 5) {
            discount = totalPrice * 0.25;
        }

    p.println("***************");
    p.println(("Total Price for orders: "+totalPrice));
    p.println("Total price after customer discount: "+(totalPrice - discount));
    p.println("Thank you for ordering !!");
    p.println(toString());
p.close();
}catch(IOException e){System.out.println("error with bill ");}

}





//this to print in screen
public void calculateBill(Customer C){
System.out.println("\nCustomer Bill");
System.out.println(C.toString());

C.displayOrders();

System.out.println("\nTotal Price: "+ C.customerTotal()+"SR");
System.out.println("Total price after customer discount: "+(C.customerTotal()-C.getDiscount()));
System.out.println("\nThank you for ordering !!");
System.out.println(toString());
}

public String toString(){
return "Responsible employee: "+name;
}


}
