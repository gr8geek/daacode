import java.util.Scanner;
import java.util.HashSet;
public class prims2{
    public static void main(String args[]){
        int V = 5;
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },  
        { 2, 0, 3, 8, 5 },  
        { 0, 3, 0, 0, 7 },  
        { 6, 8, 0, 0, 9 },  
        { 0, 5, 7, 9, 0 } };  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the source vertex");
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer[]> set2 =new HashSet<Integer[]>();
        int min;

        for(;set.size()!=V;){
            int A[]=graph[n];
            min=Integer.MAX_VALUE;
            for(int i=0;i<V;i++){
                if(A[i]<=min && !set.contains(i)){
                    min = i;
                    }
                }
                Integer ar[]=new Integer[2];
                ar[0]=n;
                ar[1]=min;
                set.add(min);
                n = min;
                set2.add(ar);            
        }
        System.out.println("Edge   Weight");
        for(Integer ar[]:set2){
            System.out.println(ar[0]+","+ar[1]+"  "+graph[ar[0]][ar[1]]);
        }
    }

}