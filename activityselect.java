import java.util.Scanner;
public class activityselect
{
    public static void main(String args[]){
        int i,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of activity:");
        int n = sc.nextInt();
        activity A[] = new activity[n];
        for( i = 0;i < n; i++ ){
            System.out.println("Enter the activity with sorted finish Time:");
            A[i] = new activity(sc.nextInt(),sc.nextInt());
        }
        j = 0;
        System.out.println(j);
        for(i = 1;i < n;i++){
            if(A[i].s >= A[j].f){
                System.out.println(i);
                j = i;
            }
        }

        sc.close();
    }
    
}
class activity{
    int s,f;
    activity(int s,int f){
        this.s = s;
        this.f = f;
    }
}