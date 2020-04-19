import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
public class huffman2{
    static class comp implements Comparator<node>{
        public int compare(node a,node b){
            return a.f-b.f;
        }

    }
    static class node{
        //used to represent internal tree and nodes
        String s;
        int f;
        node left;
        node right;
        node(String s,int f){
            this.s=s;
            this.f=f;
            left=right=null;

        }
        node(String s,int f,node left,node right){
            this.s=s;
            this.f=f;
            this.left=left;
            this.right=right;
        }  
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter symbols and their freq");
        System.out.println("Enter exit to quit");
        System.out.println("Enter number of character");
        int n=sc.nextInt();
        PriorityQueue<node> list =new PriorityQueue<node>(n,new comp());
        HashMap<String,node> map=new HashMap<String,node>();
        while(true){
            System.out.println("Symbol:");
            String s=sc.next();
            if(s.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Frequency:");
            int f=sc.nextInt();
            node x=new node(s,f);
            list.add(x);
            map.put(s,x);
        }
        sc.close();
        node T3=null;
        while(list.size()>1){
            node T1=list.poll();
            node T2=list.poll();
            String ns=T1.s+T2.s;
            T3=new node(ns,T1.f+T2.f,T1,T2);
            list.add(T3);
        }
        getCode(T3, "");       
    }
    public static void getCode(node n,String c){
        if(n.left==null && n.right==null){
            System.out.println(n.s+"===="+c);
        }
        if(n.left!=null)
        getCode(n.left,c+"0");
        if(n.right!=null)
        getCode(n.right, c+"1");
        }    
    }