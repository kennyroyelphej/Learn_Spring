abstract class Human{    //Abstract Class
    public abstract void eat();    //Abstract Method
    public void walk(){
        System.out.println("Started to walk");
    }
}
class Man extends Human{
    @Override
    public void eat() {
        System.out.println("Started to eat");
    }
}
public class AbstractionDemo {
    public static void main(String args[]){
        Human obj = new Man();
        obj.eat();
        obj.walk();
    }
}
