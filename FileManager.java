import java.io.*;
public class FileManager {
    
public static void SaveOrders(Order[]list) {

try {
    File F=new File("orders.dat");
    FileOutputStream out=new FileOutputStream(F);
    ObjectOutputStream saved = new ObjectOutputStream(out);
 saved.writeObject(list);
saved.close();
} catch (IOException  e) {
    System.out.println("Error ");
}
}

public static Order[] readOrders (){
  Order[] orders=new Order[0];//size is zero so the program doesn't crash if we used methods require length later
    try {
        File F2=new File("orders.dat");
        FileInputStream in=new FileInputStream(F2);
        ObjectInputStream obj2=new ObjectInputStream(in);

    orders=(Order[])obj2.readObject();
     obj2.close();
    }catch(ClassNotFoundException e){System.out.println("not found");}
catch(IOException e){System.out.println("error ..");}

return orders;
}





}
