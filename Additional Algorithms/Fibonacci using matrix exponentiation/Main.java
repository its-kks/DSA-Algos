import java.util.*;
public class Main {
    public int[][] multiply(int a[][], int b[][]){
        int row = a.length;
        int col = a[0].length;
        int ans[][] = new int[row][row];
        for(int i=0;i<row;i++){
            int sum =0;
            for(int j=0;j<col;j++){
                for(int k=0;k<row;k++){
                    sum += a[i][k]*b[k][j];
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
    public int[][] binaryExponentiation(int mat[][], int n){
        if(n==1){
            return mat;
        }
        else{
            int res[][] = binaryExponentiation(mat, n/2);
            if(n%2==0){
                return multiply(res, res);
            }
            else{
                return multiply(multiply(res, res), mat);
            }
        }
    }
    public static void Main(String args[]){
        //matrix exponentiation
    }
}

/*

public int pow(int a, int b){
    if( b == 1 ) return a;
    if( b == 0 ) return 1;
    int half = pow(a, b/2);
    if(b%2==0){
        return half*half;
    }
    else{
        return half*half*a;
    }
}

 */
