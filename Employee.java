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
System.out.println("\nCustomer Bill");
System.out.println(C.toString());

C.displayOrders();

System.out.println("\nTotal Price: "+ C.customerTotal()+"SR");
System.out.println("Total price after customer discount: "+(C.customerTotal()-C.getDiscount()));
System.out.println("\nthank you for ordering ");
System.out.println(toString());
}

public String toString(){
return "responsible employee:"+name;
}


}
