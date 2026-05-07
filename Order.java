import java.io.*;

public class Order implements Serializable{

private int noOfCakes;
private NodeCake headCake; 

public Order(){
noOfCakes=0;
headCake=null;

}

//copy constructor
public Order(Order o){
noOfCakes=o.noOfCakes;
headCake=null;
NodeCake current= o.headCake;
while(current!=null){

    Cake copy=null;
    if(current.getData() instanceof redVelvet)
        copy=new redVelvet((redVelvet)current.getData());
    else if(current.getData() instanceof Chocolate)
           copy=new Chocolate((Chocolate)current.getData());

  else if(current.getData() instanceof Vanilla)
           copy=new Vanilla((Vanilla)current.getData());

NodeCake newnode= new NodeCake(copy);

newnode.setNext(headCake);
headCake=newnode;
current=current.getNext();

}
}

public boolean addCake(Cake c){
NodeCake newNode= new NodeCake(c);
newNode.setNext(headCake);
headCake=newNode;

noOfCakes++;
return true;}


public boolean removeCake(Cake c){

if(headCake==null)
    return false;
if(headCake.getData().isSame(c)){
headCake=headCake.getNext();
noOfCakes--;
return true;}

NodeCake prev=headCake;
NodeCake current=headCake.getNext();

while(current!=null){

if(current.getData().isSame(c)){

prev.setNext (current.getNext());
noOfCakes--;
return true;


}
prev=current;
current=current.getNext();

}

return false;

}

public boolean searchCake(Cake C) {
   NodeCake current=headCake;
   while(current!=null){

    if(current.getData().isSame(C))
        return true;
    current=current.getNext();
   }

   return false;
}

//recursive method
   public double cakeTotalPrice() {
        return cakeTotalPrice(headCake);
    }
    private double cakeTotalPrice(NodeCake current) {
if(current == null)
return 0;

 return current.getData().CalculatePrice()+ cakeTotalPrice(current.getNext());
    }

    
public void display(){

NodeCake current= headCake;
while(current!=null){

current.getData().displayInfo();
current=current.getNext();

}

}

//get info for file 
public String  InfoFile(){
String str="";
NodeCake current=headCake;
while(current!=null){
    current.getData().CalculatePrice();
str+=current.getData().InfoFile();
current=current.getNext();
}

return str;
}

public int getnoOfCakes(){
    return noOfCakes;
}

}
