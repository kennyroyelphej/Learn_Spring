public class WrapperClassDemo {
    public static void main(String args[]){
        int i = 5;
        Integer j = new Integer(5); //Boxing
        int k = j.intValue(); //UnBoxing
        Integer l = i; //Auto-Boxing
        int m = l; //Auto-Unboxing
        String n = "123";
        int o = Integer.parseInt(n);
    }
}
