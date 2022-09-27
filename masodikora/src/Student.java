import java.io.Serializable;
import java.util.Date;
import java.text.*;
class Student implements Serializable{
    private String Name;
    private int Height;
    private Date Birthday;
    public Student (String n, int h, Date b) {
        Name = n;
        Height = h;
        Birthday = b;
    }
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String s= sdf.format(Birthday);
        return "Name: "+Name+" Height: "+Height+" B.day: "+s;
    }
}
