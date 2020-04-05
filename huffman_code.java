import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
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
    static HashMap<Character,String> map1 =new HashMap<Character, String>();
    static HashMap<String,Character> map2 =new HashMap<String,Character>();
    static int val=0;
    static void printhuffman(Node root, String code)
    {
        System.out.println(root.c+"--"+root.freq);
        if(Character.isLetter(root.c) || root.c ==' ')
        {
            map1.put(root.c, code);
            map2.put(code,root.c);
            return;
        }
        printhuffman(root.left, code+"0");
        printhuffman(root.right, code+"1");
    }
    public static void main(String args[]){
        int n ,i; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string ending by blank space");
        String dat = sc.nextLine();
        HashSet<Character> ch  = new HashSet<Character>();
        for(i = 0;i<dat.length();i++){
            ch.add(dat.charAt(i));
        }
        n = ch.size();
        char[] charArray = new char[n]; 
        int[] charfreq = new int[n];
        i = 0;
        for(Character c: ch){
            int count = 0;
            for(int j = 0;j<dat.length();j++){
                if(c == dat.charAt(j))
                count++;
            } 
            charArray[i]= c;
            charfreq[i] = count;
            i++;
        }
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
        printhuffman(root , s );
        System.out.println(map1);
        System.out.println(map2);
        String x="";
        for(i = 0;i<dat.length();i++){
            x+=map1.get(dat.charAt(i)); 
        }
        int len=x.length();
        System.out.println("Size before compression "+(dat.length()*2)+" Bytes");
        System.out.println(x.length()/8+ " Bytes After compression");
        System.out.println("Encoded:"+x);
        System.out.println("Decoding ...."+"\n");
        String dec="";
        System.out.println("Decoded:");
        int pos = decoder(x);
}
static int decoder(String st){
    String y="";
    int i;
    for(i=0;i<st.length();i++)
    {
        if(map2.containsKey(y)){
            System.out.print(map2.get(y));
            break;
        }
        else{
            y+=st.charAt(i);
        }
    }
    if(st.length()>0){
       
    decoder(st.substring(i,st.length()));

    }
    return i;
}
}