import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
class Node{
    int v,name;
    int prev;
    Node(int name,int v,int prev){
        this.name = name;
        this.v=v;
        this.prev=prev;
    }
    void set(int v,int prev){
        this.v=v;
        this.prev=prev;
    }
}
class comp implements Comparator<Node>{
    @Override
    public int compare(Node a, Node b){
        return a.v - b.v;
    }
}
public static void main(String args[]){
    int graph[][] = new int[][] { { Integer.MAX_VALUE, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE }, 
    { 4, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 11, Integer.MAX_VALUE }, 
    { Integer.MAX_VALUE, 8, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, 2 }, 
    { Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 9, 14, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, 
    { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, 
    { Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 14, 10, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE }, 
    { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 1, 6 }, 
    { 8, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 7 }, 
    { Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 7, Integer.MAX_VALUE } };
    PriorityQueue<Node> q = new PriorityQueue<Node>(9, new comp());
    HashMap<Integer,Node> m = new HashMap<Integer,Node>();
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the source and destination");
    int source = sc.nextInt();
    int dest = dc.nextInt();
    q.add(new Node(source, 0, null));
    m.put(source, q.peek());
    for(int j=0;j<9;j++){
        if(j!=source){
        Node x = new Node(j, Integer.MAX_VALUE, null);
        q.add(x);
        m.put(j,x);
    }
        
    }
    HashSet<Node> visited = new HashSet<Node>();
    int min = 0;
    visited.add(m.get(source));
     while(){
         Node t = q.peek();
         Node p = null;
         int tem[] =graph[t.name];
         for(int j=0;j<tem.length;j++){
             Node x = m.get(j);
            if(!visited.contains(m.get(j)) && x.v<min){
                min = x.v;
                p = x;
            }
         }
         p.prev = t.name;
         if(p.v == Integer.MAX_VALUE)
            p.v = 0;
        if(p.v!= Integer.MAX_VALUE)
        p.v+=t.v;
    }

}
}