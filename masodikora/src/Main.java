import java.io.*;
import java.util.Date;
import java.text.*;
import java.io.Serializable;
public class Main {
    private static Student st;
    private static int db = 3;
    private static Student[] stA = new Student[10];
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    static Date d0=null, d1=null, d2=null;
    public static void main(String[] args) {
        try {
            d0 = sdf.parse("1999.12.21");
            d1 = sdf.parse("1995.04.09");
            d2 = sdf.parse("1998.07.14");
        } catch (ParseException pe) {System.out.println("Hiba: "+pe);}
        stA[0] = new Student("Béla", 188, d0);
        stA[1] = new Student("Enikő", 166, d1);
        stA[2] = new Student("Ödön", 179, d2);
        Kiir(stA);
        Beolvas();
    }







    public static void Beolvas() {
        try {
            FileInputStream fis =
                    new FileInputStream("Students.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int db = ois.readInt();
            Object o = null;
            System.out.println("Data from file:");
            for (int i = 0; i < db; i++) {
                o = ois.readObject();
                Student st = (Student)o;
                System.out.println(st);
            }
            ois.close(); fis.close();
        } catch (Exception e) {
            System.out.println("File read exception: "+e);
        }
    }


    public static void Kiir(Student[] stA) {
        try {
            FileOutputStream fos =
                    new FileOutputStream("Students.dat");
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);
            int x = stA.length;
            oos.writeInt(x);
            for (int i = 0; i < x; i++) {

                if(stA[i] != null)
                oos.writeObject(stA[i]);

            }
            oos.close();
            fos.close();
            System.out.println("Data is written to file!");
        } catch (IOException ioe) {
            System.out.println("File write exception: "+ioe);
        }
    }
}

