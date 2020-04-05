import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
class Node{
    int v,cost;
    Node(int v,int cost){
        this.v=v;
        this.cost=cost;
    }
}
class Graph{
    LinkedList<Node> adj[];
    HashMap<Integer,LinkedList<Node>> hm =new HashMap<Integer,LinkedList<Node>>();
    Graph(int v){
        int i;
        adj= new LinkedList[v];
        for(i = 0;i<v;i++){
            adj[i]=new LinkedList();
            hm.put(i,adj[i]);
        }
    }
    void add(int v,int u,int cost){
        adj[hm.get(u)].add(new Node(v,cost));
        adj[v].add(new Node(u,cost));
    }
}
public class prims{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the ")
    }
}