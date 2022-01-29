class SuperOverride{
    public void show(){System.out.println("SuperOverrided");}
}
class SubOverride extends SuperOverride{
    @Override
    public void show(){System.out.println("SubOverride");}
}
class SubOverrideDynamic extends SuperOverride{
    public void show(){System.out.println("DynamicOverride");}
}
public class OverrideMethodsDemo {
    public static void main(String args[]){
        SuperOverride override = new SubOverride(); //Runtime Polymorphism
        override.show();
        override = new SubOverrideDynamic();// Dynamic Method Dispatch
        override.show();
    }
}
