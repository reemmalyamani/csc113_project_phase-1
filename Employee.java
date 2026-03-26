
public class Employee {
   

private String name;
private double workHrs;
private double salary;

public Employee(String name,double workHrs,double salary){
this.name=name;
this.salary=salary;
this.workHrs=workHrs;
}

public void calculateBill(Customer C){
System.out.println(C.getName());

C.displayOrders();

System.out.println("\nTotal Price: "+ C.customerTotal()+"SR");
System.out.println("Total price after customer discount:"+(C.customerTotal()-C.getDiscount()));
System.out.println("thank you for ordering ");

}
}

