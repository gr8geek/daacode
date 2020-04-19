import java.util.Scanner;
public class bellmanford{
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertics ");
        int n=sc.nextInt();
        System.out.println("Enter the source vertex");
        int s=sc.nextInt();
        int[][] A=new int[n+1][n];
        for(int i=0;i<n+1;i++){
            if(i!=s){
                int[] t=A[i];
                for(int j=0;j<t.length;j++){
                    A[j]=Integer.MAX_VALUE;
                }
            }
        }
        boolean stable=true;
        for(int i=1;i<n+1;i++){

        }
        
        
    }
}