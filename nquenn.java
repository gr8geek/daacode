import java.util.Scanner;
public class nquenn{
    static class pos{
        int row,col;
        pos(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of board");
        int n=sc.nextInt();
        pos p[]=new pos[n];
        recursiveSolveNQuenns(n,0,p);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(p[i].col==j){
                    System.out.print(" Q ");
                }
                else{
                    System.out.print("   ");
                }

            }
            System.out.println();
        }

        //display the resul
    }
    public static boolean recursiveSolveNQuenns(int n,int row,pos[] p){
        if(n==row){
            return true;//reached the maximum depth
        }
        for(int col=0;col<n;col++){
            boolean valid=true;
            for(int quenn=0;quenn<row;quenn++){
                if(p[quenn].row==row||p[quenn].col==col||
                (p[quenn].row+p[quenn].col==row+col)||(p[quenn].row-p[quenn].col==row-col)){
                    valid=false;
                }
            }
                if(valid){
                    pos x=new pos(row,col);
                    p[row]=x;
                    if(recursiveSolveNQuenns(n, row+1, p)){
                        return true;
                    }
                }
            }
            return false;

        }
    }
