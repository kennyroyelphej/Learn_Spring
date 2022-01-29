class Calculator{
    int num1;
    int num2;
    int result;
    // Constructor Overloading
    public Calculator(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        perform();
    }
    public Calculator(double num1,double num2){
        this.num1 = (int)num1;
        this.num2 = (int)num2;
        perform();
    }
    private void perform(){
        result = num1 + num2;
    }
}

class Casio{
    int result;
    //Method Overloading
    public void add(int num1, int num2){
        result = num1 + num2;
    }
    public void add(double num1, double num2){
        result = (int)num1 + (int)num2;
    }
}

public class ClassObjectDemo {
    public static void main(String args[]){
        Calculator calc1 = new Calculator(3,4);
        Calculator calc2 = new Calculator(3.5,3.5);
        System.out.println(calc1.result);
        System.out.println(calc2.result);
        Casio calc3 = new Casio();
        calc3.add(6,8);
        System.out.println(calc3.result);
        calc3.add(4.5,8.3);
        System.out.println(calc3.result);
    }
}
