public class VariableDemo {
    public static void main(String args[]){
        long l = 5000000l;
        int i = 5;
        short s = 5;
        byte b = 5;
        float f = 5.5f;
        double d = 5.5;
        char c = 'A';
        c = 66; //American standard code for information interchange
        System.out.println(c); //B
        double d1 = 5; //Implicit conversion
        System.out.println(d1); //5.0
        int k = (int)5.6; //Typecasting //Explicit conversion
        System.out.println(k); //5
    }
}
