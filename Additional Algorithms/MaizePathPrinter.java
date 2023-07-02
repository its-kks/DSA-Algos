import java.util.*;
public class MaizePathPrinter{
    static int totalPaths(int matrix[][],
    int indexFirst,int indexSecond,int count,Vector<Character> v){
        if(indexFirst==matrix.length-1 && indexSecond==matrix[0].length-1){
            for(char c:v){
                System.out.print(c+" ");
            }
            System.out.println("");
            return 1;
        }
        Vector<Character> vNewR=new Vector<Character>();
        vNewR.addAll(v);
        vNewR.add('R');
        Vector<Character> vNewD=new Vector<Character>();
        vNewD.addAll(v);
        vNewD.add('D');
        if(indexFirst==matrix.length-1){  
            count+=totalPaths(matrix,indexFirst, indexSecond+1,count,vNewD);
            return count;
        }
        else if(indexSecond==matrix[0].length-1){
            count+=totalPaths(matrix,indexFirst+1, indexSecond,count,vNewR);
            return count;
        }
        count+=totalPaths(matrix,indexFirst+1, indexSecond,count,vNewR)+
        totalPaths(matrix,indexFirst, indexSecond+1,count,vNewD);
        return count;
    }
    public static void main(String args[]){
        System.out.println("Enter rows and column:");
        int row,col;
        Scanner input=new Scanner(System.in);
        row=input.nextInt();
        col=input.nextInt();
        int matrix[][]=new int[row][col];
        System.out.println("Total paths:"+totalPaths(matrix,0,0,0,new Vector<Character>()));
    }
}