import java.util.Scanner;
public class dynamicconnect{
    static int id[];
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of points you would like to simulate");
        int n=sc.nextInt();
        id=new int[n];
        for(int i=0;i<n;i++){
           id[i]=i; 
        }
        System.out.println("ID Array initilaized:)");
        System.out.println("Options: \n1.Union\n2Connected\n0 to Exit");
        while(ch){
            switch(ch){
                case 1:
                System.out.println("Enter 2 numbers");
                int a=sc.nextInt();
                int b=sc.nextInt();
                union(a,b);
                case 2:
                System.out.println("Enter 2 numbers");
                int a=sc.nextInt();
                int b=sc.nextInt();
                System.out.println("connected("+a+","+b+")"+"="+connected(a,b));
                break;
                
            }
            ch=sc.nextInt();
        }

    }
    static int root(int a){
        int i;
        i=a;
        while(id[i]!=i){
            i=id[i];
        }
        return i;
    }
    static int union(int a,int b){
        //calculates the weighted union for dynamic connectivity problem
    }
}