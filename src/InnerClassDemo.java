class OuterClass{
    int i;
    public void show(){
        System.out.println("Outer Class show method");
    }
    class InnerOne{
        public void displayOne(){
            System.out.println("Inner One Class display One method");
        }
    }
    static class InnerTwo{
        public void displayTwo(){
            System.out.println("Inner Two Class display Two method");
        }
    }
}

public class InnerClassDemo {
    public static  void  main(String args[]){
        OuterClass outer = new OuterClass();
        outer.show();
        OuterClass.InnerOne innerOne = outer.new InnerOne();
        innerOne.displayOne();
        OuterClass.InnerTwo innerTwo = new OuterClass.InnerTwo();
        innerTwo.displayTwo();
    }
}
