import java.util.Scanner;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
class Node {
    int f;
    char c;
    Node l,r;
    Node(int f, char c, Node l,Node r){
        this.l=l;
        this.r=r;
        this.f=f;
        this.c=c;
    }
    Node(Integer f, Character c){
        this.l=null;
        this.r=null;
        this.f=f;
        this.c=c;
    }
}
class comp implements Comparator<Node>{
    public int compare(Node x, Node y){
        return x.f - y.f;
    }
}
public class huffman_code{
    static HashMap<String, Character> map =new HashMap<String,Character>();
    static HashMap<Character, String> map2 =new HashMap<Character,String>();

    static void gethuffman(Node root, String code){
        if(Character.isLetter(root.c) || root.c == '\n'){
            map.put(code,root.c);
            map2.put(root.c,code);
            return ;
        }
        gethuffman(root.l, code+"0");
        gethuffman(root.r, code+"1");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String message="";
        System.out.println("Enter the string text and type exit in a seperate line to exit");
        while(true){
        String st = sc.nextLine();
        if(st.equalsIgnoreCase("exit"))
        break;
        else
        message+=st+"\n";
        }
        int l=message.length();
        PriorityQueue<Node> q = new PriorityQueue<Node>(l, new comp());
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        for(int i = 0;i < l; i++){
            if(m.containsKey(message.charAt(i))){
                m.put(message.charAt(i),m.get(message.charAt(i))+1);
            }
            if(!m.containsKey(message.charAt(i))){
                m.put(message.charAt(i),0);
            }
            }
        
        for(Character ch: m.keySet()){
            System.out.println(ch);
            System.out.println(m.get(ch));
            Node n = new Node(m.get(ch),ch);
            q.add(n);
        }
        Node root = null;
        for(;q.size()>1;){
            Node x1 = q.poll();
            Node x2 = q.poll();
            Node x3 = new Node(x1.f+x2.f,'*',x1,x2);
            root = x3;
            q.add(x3);
        }
        gethuffman(root, "");
        String compressed="";
        System.out.println("Compressing ...");
        for(int i = 0;i<message.length();i++){
            compressed += map2.get(message.charAt(i));
        }
        System.out.println("Compressed:");
        System.out.println(compressed);
        System.out.println("Exploding(Decompressing)");
        char c;
        String cd="";
        for(int i = 0;i<compressed.length();i++){
            cd+=compressed.charAt(i);
            if(map.containsKey(cd)){
                System.out.print(map.get(cd));
                cd="";
            }
        }
    }
}