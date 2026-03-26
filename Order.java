public class Order {

private int noOfCakes;
private Cake listCakes[];

public Order(int size){
noOfCakes=0;
listCakes=new Cake[size];

}

public Order(Order o){
this.noOfCakes=o.noOfCakes;
this.listCakes=new Cake[o.listCakes.length];
for(int i=0;i<noOfCakes;++i){
if(o.listCakes[i] instanceof redVelvet)
    this.listCakes[i]=new redVelvet((redVelvet)o.listCakes[i]);

else if(o.listCakes[i]instanceof Chocolate)
    this.listCakes[i]=new Chocolate((Chocolate)o.listCakes[i]);

else if(o.listCakes[i]instanceof Vanilla)
    this.listCakes[i]=new Vanilla((Vanilla)o.listCakes[i]);


}



}
public boolean addCake(Cake c){
if(noOfCakes==listCakes.length)
return false;

listCakes[noOfCakes++]=c;
return true;
}

public boolean removeCake(Cake c){
for (int i=0;i<noOfCakes;++i){
    if(listCakes[i].getType().equals(c.getType()) && listCakes[i].getSize().equals(c.getSize())){
        for(int j=i;j<noOfCakes-1;++j){
            listCakes[j]=listCakes[j+1];
        }
        listCakes[noOfCakes-1]=null;
        noOfCakes--;
        return true;
    }
}
return false;

}

public boolean searchCake(String type) {
    for (int i = 0; i < noOfCakes; i++) {
        if (listCakes[i].getType().equalsIgnoreCase(type)) {
            System.out.println("Found");
            return true;
        }
    }
    System.out.println("Not found");
    return false;
}

public double cakeTotalPrice(int index) {
    if (index == noOfCakes)
        return 0;

    return listCakes[index].CalculatePrice() 
           + cakeTotalPrice(index + 1);
}//recursive method

    
public void display(){

for(int i=0;i<noOfCakes;++i){
    listCakes[i].displayInfo();
}

}

public int getnoOfCakes(){
    return noOfCakes;
}
}
