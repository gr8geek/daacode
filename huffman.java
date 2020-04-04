import java.util.Comparator;
import java.util.PriorityQueue;
class Node
{
    int freq;
    char c;
    Node left;
    Node right;
}
class comp implements Comparator<Node>
{
    @Override
    public int compare(Node a , Node b){
        return a.freq-b.freq;
    }

}
public class huffman{
    static void printhuffman(Node root, String code)
    {
        if(Character.isLetter(root.c))
        {
            System.out.println(root.c+"-----"+code);
            return;
        }
        printhuffman(root.left, code+"0");
        printhuffman(root.right, code+"1");
    }
    public static void main(String args[]){
        int n = 6,i; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
        PriorityQueue<Node> q = new PriorityQueue<Node>(n , new comp());
        for(i = 0;i < n;i++)
        {
            Node x = new Node();
            x.freq = charfreq[i];
            x.c = charArray[i];
            x.left = null;
            x.right = null;
            q.add(x);
        }
        int v;
        Node root = null;
        while(q.size()>1){
            Node x1 = q.poll();
            Node x2 = q.poll();
            v = x1.freq + x2.freq;
            Node x3 = new Node();
            x3.freq = v;
            x3.c = '*';
            x3.left = x1;
            x3.right = x2;
            q.add(x3);
            root = x3;
        }
        String s = "";
        printhuffman( root , s );
    }
}