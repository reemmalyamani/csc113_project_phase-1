public class Orders {

private int noOfCakes;
private Cake listCakes[];

public Orders(int size){
noOfCakes=0;
listCakes=new Cake[size];

}

public boolean addCake(Cake C){
if(noOfCakes==listCakes.length)
return false;

listCakes[noOfCakes++]=C;
return true;
}

public boolean removeCake(Cake C){
for (int i=0;i<noOfCakes;++i){
    if(listCakes[i].getType().equals(C.getType()) && listCakes[i].getSize().equals(C.getSize())){
        for(int j=i;j<noOfCakes-1;++j){
            listCakes[j]=listCakes[j+1];
        }
        noOfCakes--;
        return true;
    }
}
return false;

}

public void searchCake(String type){
for (int i = 0; i<noOfCakes;i++) 
    if(listCakes[i].getType().equals(type))
     System.out.print(listCakes[i].getName()+"\n");
    

}

public double cakeTotalPrice(){
    int sum=0;
    for(int i=0;i<noOfCakes;++i){
        sum+=listCakes[i].getPrice();
    }
return sum;
}

public void display(){

for(int i=0;i<noOfCakes;++i){
    listCakes[i].display();
}

}

}
