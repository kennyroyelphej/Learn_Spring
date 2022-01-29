class SuperCalculator{
    public int add(int i, int j){ return  i + j;}
    public int sub(int i, int j){ return  i - j;}
}
class SubCalculator extends SuperCalculator{
    public int multiply(int i, int j){ return  i / j;}
    public float divide(int i, int j){ return  i / j;}
}
class MultiCalculator extends SubCalculator{
    public int mod(int i, int j){ return  i % j;}
}
public class InheritanceDemo {
    public static void main(String args[]){
        MultiCalculator action = new MultiCalculator();
        System.out.println("Add: "+action.add(15,6));
        System.out.println("Sub: "+action.sub(15,6));
        System.out.println("Multiply: "+action.multiply(15,6));
        System.out.println("Divide: "+action.divide(15,6));
        System.out.println("Mod: "+action.mod(15,6));
    }
}
