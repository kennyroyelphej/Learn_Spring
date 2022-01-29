public class ArrayDemo {
    public static void main(String args[]){
        int a[] = new int[4];
        int b[] = {1,2,3,4};
        int c[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int d[][] = {{1,2},{3,4,5,6},{7,8}};
        System.out.println("One Dimensional Array");
        for(int i=0;i<4;i++){
            System.out.print(" "+b[i]);
        }
        System.out.println("\nTwo Dimensional Array");
        for(int j=0;j<3;j++){
            for(int k=0;k<3;k++){
                System.out.print(" "+c[j][k]);
            }
            System.out.println();
        }
        System.out.println("Jagged Array with forEach");
        for(int l[] : d){
            for(int m : l){
                System.out.print(" "+ m );
            }
            System.out.println();
        }
    }
}
