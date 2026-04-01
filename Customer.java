public class Customer implements Discount{
private String name;
private String phoneNo;
private int loyalYears;
private int noOfOrders;
private Order listOrders[];


public Customer(String name,String phoneNo,int loyalYears){

this.name=name;
this.phoneNo=phoneNo;
this.loyalYears=loyalYears;
noOfOrders=0;
listOrders=new Order[10];
}

public boolean addOrder(Order o){
if(noOfOrders==listOrders.length)
return false;

listOrders[noOfOrders++]=new Order(o);
return true;
}


public double getDiscount(){
    if(loyalYears>5)
    return customerTotal()*0.25;
return 0;
}


public String toString(){
    return "customer name:"+name+ " Phone Number: "+phoneNo+"\nnumber of orders is "+noOfOrders;
}

public String getName(){
    return name;
}


public void displayOrders(){
    
System.out.println("***************");
    for(int i=0;i<noOfOrders;++i){
        
        System.out.println("Order "+(i+1));
        listOrders[i].display();
        System.out.println("");
    }
    System.out.println("*********");
}


public double customerTotal(){
    double sumTotalOrders=0;
    for(int i=0;i<noOfOrders;++i){
       
        sumTotalOrders+=listOrders[i].cakeTotalPrice(0);
    }
   return sumTotalOrders;
 
}


}
