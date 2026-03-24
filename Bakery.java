public class Bakery {
   
  private String name;
  private String location;
  private int nOfEmployee;
  private int nOfCake;
  private Employee listEmp[];
private Cake listCake[];

public Bakery (String name, String location, int sizeEmp){
  this.name = name;
  this.location = location;
  this.nOfEmployee = 0;
  this.nOfCake = 0;
  this.listEmp=new Employee [sizeEmp];
  this.listCake =new Cake[200];

} //close constructor 

  public boolean addCake (Cake c) {
if(nOfCake==listCake.length)
    return false;
listCake[nOfCake++]=new Cake(c);
return true;
  }


  public boolean  addEmployee (Employee p){
if(nOfEmployee==listEmp.length)
    return false;
listEmp[nOfEmployee++]=p;
return true;

  }

  public boolean isAvailable (Cake c) {
for(int i=0;i<nOfCake;++i){
if(listCake[i].getType().equals(c.getType()) && listCake[i].getSize().equals(c.getSize()))
return true;
}
return false;
  }

  public void welcoming() {
    System.out.println ("welcom to "+name+" bakery in "+location+"\n");
  }// close display method
}// close bakery class 
