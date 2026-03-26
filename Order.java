public class Orders {

private int noOfCakes;
private Cake listCakes[];

public Orders(int size){
noOfCakes=0;
listCakes=new Cake[size];

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

public boolean searchCake(String type){
for (int i = 0; i<noOfCakes;i++) 
    if(listCakes[i].getType().equals(type)){
     System.out.print("\nfound");
    return true;}
System.out.println("not found");
    return false;
}

public double cakeTotalPrice(){
    int sum=0;
    for(int i=0;i<noOfCakes;++i){
        sum+=listCakes[i].CalculatePrice(0);
    }
return sum;
}

public void display(){

for(int i=0;i<noOfCakes;++i){
    listCakes[i].display();
}

}

}
