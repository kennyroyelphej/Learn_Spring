class Student{
    private int rollno;
    private String name;
    public int getRollno() { return rollno; }
    public void setRollno(int rollno) { this.rollno = rollno; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

public class EncapsulationDemo {
    public static void main(String args[]){
        Student first = new Student();
        first.setRollno(1);
        first.setName("Kenny");
        System.out.println(first.getRollno()+" : "+first.getName());
    }
}
