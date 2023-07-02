//MCM
import java.util.*;
public class MCM{
    public static int minOperations(Vector<Vector<Integer>> matrix,
    Vector<Integer> matrixSize,int i,int k,int j,int minValue){
        if(k==j){
            matrix.get(i).add(j,minValue);
            return minValue;
        }
        int temp=matrix.get(i).get(k)+matrix.get(k+1).get(j)+matrixSize.get(i)*matrixSize.get(k+1)*
        matrixSize.get(j+1);
        if(temp<minValue){
            minValue=temp;
        }
        return minOperations(matrix, matrixSize, i, ++k, j, minValue);
    }
    public static void main(String[] args) {
        final int infinite=2147483647;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter no of matrix:");
        int noMatrix=input.nextInt();
        System.out.println("Enter the matrix sizes:");
        Vector<Integer> matrixSize=new Vector<Integer>();
        for(int i=0;i<noMatrix+1;i++){
            System.out.print("Value:");
            matrixSize.add(input.nextInt());
        }
        Vector<Vector<Integer>> matrix=new Vector<Vector<Integer>>();
        for(int i=0;i<noMatrix;i++){
            matrix.add(new Vector<Integer>(noMatrix));
        }
        //initialisation
        for(int i=0;i<noMatrix;i++){
            for(int j=0;j<noMatrix;j++){
                matrix.get(i).add(j,0);
                if(i==j){
                    break;
                }
            }
        }
        for(int k=1;k<noMatrix;k++){
            for(int j=0+k,i=0;j<noMatrix && i<noMatrix;i++,j++){
                minOperations(matrix, matrixSize,i, i, j,infinite);
            }
        }
        System.out.println("Minimum operations required:"+matrix.get(0).get(noMatrix-1));
    }
}