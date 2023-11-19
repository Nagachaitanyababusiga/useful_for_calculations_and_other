import java.util.Scanner;
public class GetTransitiveMatrix {

    static int transitive_mat[][];

    static public void reset_tr_mat(int s){
        transitive_mat=new int[s][s];
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                transitive_mat[i][j]=0;
            }
        }
    }

    public void get_tr_mat(){
        System.out.println("The Transitive matrix is:");
        int s=transitive_mat.length;
        for(int i=0;i<s;i++){
            String result="| ";
            for(int j=0;j<s;j++){
                result+=Integer.toString(transitive_mat[i][j])+"|";
            }
            System.out.println(result);
        }
    }

    static public void or(int a[][],int b[][]){
        int s=a.length;
        int[][] c=new int[s][s];
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                c[i][j]=a[i][j]+b[i][j]>0?1:0;
            }
        }
        transitive_mat=c;
    }
    
    public int[][] mul(int a[][],int b[][]){
        int s=a.length;
        int c[][]=new int[s][s];
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
               	int sum=0;
                for(int k=0;k<s;k++){
                    sum+=a[i][k]*b[k][j];
                }
                if(sum>0) c[i][j]=1;
                else c[i][j]=0;
            }
        }
        or(transitive_mat, c);
        for(int i=0;i<s;i++){
            String result="| ";
            for(int j=0;j<s;j++){
                result+=Integer.toString(c[i][j])+"|";
            }
            System.out.println(result);
        }
        return c;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.print("enter degree of matrix:");
        int n=5;//sc.nextInt();
        int mat[][]=new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("enter the "+(n*i+(j+1))+" element:");
                mat[i][j]=sc.nextInt();
            }
        }
        GetTransitiveMatrix g=new GetTransitiveMatrix();
        System.out.print("enter no.of times to multiply:");
        int times=sc.nextInt()-1;
        System.out.println("The 1st matrix is:");
        for(int i=0;i<n;i++){
            String result="| ";
            for(int j=0;j<n;j++){
                result+=Integer.toString(mat[i][j])+"|";
            }
            System.out.println(result);
        }
        int new_mat[][]=mat;
        reset_tr_mat(n);
        for(int m=0;m<times;m++){
            System.out.println("The "+(m+2)+" matrix is:");
            new_mat=g.mul(new_mat,mat);
        }
        g.get_tr_mat();
        sc.close();
    }
}