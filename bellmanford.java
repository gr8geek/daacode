import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
class Node{
    int cost,val;
    Node(int cost,int val){
        this.val=val;
        this.cost=cost;
    }
}
class Graph{
    ArrayList<Node> adj[];
    Graph(int n)
    {
        int i;
        for(i=0;i<n;i++){
            adj[i]=new ArrayList<Node>();
        }
    }
    void addEdge(int u,int v,int cost){
        adj[u].add(new Node(cost,v));
    }
}

public class bellmanford{
    static String msg="";
    static int[][] A;
    static int n;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertics ");
        n=sc.nextInt();
        System.out.println("Enter the source vertex");
        int s=sc.nextInt();
        A=new int[n+1][n];
        for(int i=0;i<n+1;i++){
            if(i!=s){
                int[] t=A[i];
                for(int j=0;j<t.length;j++){
                    A[j]=Integer.MAX_VALUE;
                }
            }
        }//initializing the all vertics with +infinity except the source vertex
        //Accepting the value of edges and the cost and creating the adjency list
        Graph g=new Graph(n);
        while(true){
            System.out.println("Enter the value of u,v and cost(u,v)");
            System.out.println("Enter -1 to Exit");
            int u=sc.nextInt();
            if(u==-1){
                break;
            }
            int v=sc.nextInt();
            int cost=sc.nextInt();
            g.addEdge(u, v, cost);
        }
        int v=bellmanfordfun(g);
        
    }
    public static int bellmanfordfun(Graph g){
        boolean stable;
        for(int i=1;i<n+1;i++){
            stable=true;
                for(int v=0;v<n;v++){
                    int x=A[i-1][v];
                    int m=Integer.MAX_VALUE;
                    Node min_node=null;
                    //computing min A[i-1][w] + l(w,v) for all (w,v) belongs to set E
                    for(int j=0;j<n;j++){
                        ListIterator<Node> itr=g.adj[j].ListIterator();
                        while(itr.hasNext()){
                            Node nd=itr.next();
                            int val=nd.val;
                            int cost=nd.cost;
                            int tcost=A[i-1][val] + cost;
                            if(tcost<m){
                                m=tcost;
                            }

                        }
                    }
                    A[i][v]=(int)(Math.min(A[i-1][v],m));
                    if (A[i][v]!=A[i-1][v]){
                        stable=false;
                    }
                    if(stable==true){
                        return A[i-1][v];
                    }
                }
        }
        msg="Negative cycle";
        return 0;
    }
    
}