import java.util.Scanner;
public class Pro2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("First Number:");
        int x = sc.nextInt();
        System.out.println("Second Number:");
        int y = sc.nextInt();
        System.out.println("Even Numbers between x and y are :");
        for (int i = x ; i<=y;i++){
            if (i%2==0){

                System.out.println(i);
            }
            else
                System.out.println(i);
        }
        sc.close();
    }
}