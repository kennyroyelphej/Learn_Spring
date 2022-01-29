class Employee{
    int employeeID;
    int salary;
    static String ceo;

    static {
        ceo = "Elphej";
    }

    public void getInfo(){
        System.out.println("EmployeeID: "+employeeID+" Salary: "+salary+" CEO: "+ceo);
    }
}

public class StaticDemo {
    static int i;
    public static void main(String args[]){
        Employee kenny = new Employee();
        kenny.employeeID = 1;
        kenny.salary = 80000;
        kenny.getInfo();
        Employee elena = new Employee();
        elena.employeeID = 2;
        elena.salary = 45000;
//        Employee.ceo = "Aquna";
        elena.getInfo();
        i = 9;
    }
}
