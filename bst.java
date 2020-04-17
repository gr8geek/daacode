import java.util.Scaanner;
import java.util.Scanner;

public class bst{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Insert\n2.Inorder");
        boolean loop=true;
        int ch,val;
        Node root=null;
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
}