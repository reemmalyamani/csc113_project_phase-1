public class Customer {
private String name;
private String phoneNo;
private int loyalYears;
private int noOfOrders;
Orders listOrders[];


public Customer(String name,String phoneNo,int loyalYears){

this.name=name;
this.phoneNo=phoneNo;
this.loyalYears=loyalYears;
noOfOrders=0;
listOrders=new Orders[10];
}

public boolean addOrder(Orders o){
if(noOfOrders==listOrders.length)
return false;

listOrders[noOfOrders++]=new Orders(o);
return true;
}


public double getDiscount(){
    return loyalYears*0.5;
}


public String toString(){
    return name+" phoneNo: "+phoneNo+"\n number of orders is "+noOfOrders;
}

public String getName(){
    return name;
}


public void displayOrders(){
    
System.out.println("***************");
    for(int i=0;i<noOfOrders;++i){
         if(listOrders[i]!=null){
        System.out.println("order "+(i+1));
        listOrders[i].display();}
    }
    System.out.println("*********");
}


public double customerTotal(){
    double sumTotalOrders=0;
    for(int i=0;i<noOfOrders;++i){
       
        sumTotalOrders+=listOrders[i].cakeTotalPrice();
    }
   return sumTotalOrders;
 
}

public String getName(){
    return name;
}


}


