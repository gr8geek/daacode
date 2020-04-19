import java.util.Scaanner;
import java.util.Scanner;

public class bst{
    static Node root=null;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Insert\n2.Inorder\n3.maximum\n4.delete min");
        boolean loop=true;
        int ch,val;
        Node x=null,t=null;
        while(loop){
            System.out.println("Enter your option");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the vlaue of node to be inserted");
                    val=sc.nextInt();
                    int m;
                    x=root;
                    while(x!=null){
                        t=x;
                        if(x.v<val){
                            x=x.r;
                        }
                        else{
                            x=x.l;
                        }
                    }
                if(root==null){
                    root=new Node(val);
                }
                else if(t.v<val){
                    t.r=new Node(val);

                }
                else{
                    t.l=new Node(val);
                }
                break;
                case 2:
                inorder(root);
                break;
                case 3:
                x=root;
                while(x.r!=null){
                        x=x.r;           
                }
                System.out.println(x.v);
                break;
                case 4:
                    deleteMin(root);
                break;
                default:
                    loop=false;
                break;
            }
        }
    }
    static void inorder(Node x){
        if(x!=null){
            inorder(x.l);
            System.out.println(x.v);
            inorder(x.r);
        }
    }
    static void deleteMin(Node x){
        //Node x is the root
        if(x.l==null){
            root=x.r;
            return;
        }
        Node t=null;
        while(x.l!=null){
            t=x;
            x=x.l;
        }
        t.l=x.r;
    
}
}