import java.util.Comparator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Graph{
    LinkedList<Integer> adj[];
    Graph(int x){
        adj =new LinkedList[x];
        for(int i=0;i<x;i++){
            adj[i]=new LinkedList<Integer>();
    }
}
    void add(int u,int v){
        adj[u].add(v);
    }
}
class Edge{
    int a,b,c;
    Edge(int a ,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
     }

    }
class comp implements Comparator<Edge>{
    @Override
    public int compare(Edge a,Edge b){
            return a.c-b.c;
        }
    }
//implementation of kruskals algorithom
public class Kruskals{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();
        ArrayList<Edge> e= new ArrayList<Edge>();
        System.out.println("Enter a negative value to exit the loop");
        for(;;){
            System.out.println("Enter v1 v2 and cost of the edge ");
            int l=sc.nextInt();
            if(l<0)
            break;
            Edge x=new Edge(l,sc.nextInt(),sc.nextInt());
            e.add(x);
        }
        sc.close();
        Collections.sort(e, new comp());
        for(Edge x: e){
            System.out.println(x.c);
        }
        HashSet<Integer> set = new HashSet<Integer>();//set of vertices
        Graph g =new Graph(n);
        while(set.size()!= n ){
            Edge x= e.remove(0);
            if(!(set.contains(x.a) && set.contains(x.b))){
                set.add(x.a);
                set.add(x.b);
                g.add(x.a,x.b);
                System.out.println(x.a+"---"+x.b+"=="+x.c);
            }
        }
    }
}
   