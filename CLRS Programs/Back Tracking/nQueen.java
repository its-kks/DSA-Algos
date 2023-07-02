//n queen problem
//https://www.codingninjas.com/codestudio/problems/the-n-queens-puzzle_981286
import java.util.* ;
import java.io.*; 
class Solution 
{
    public boolean queenPlace(int i,int j,boolean checkboard[][]){
        //moving horizontally
        for(int k=j-1;k>=0;k--){
            if(checkboard[i][k]==true){
                return false;
            }
        }
        //moving vertically
        for(int I=i-1,J=j-1;I>=0 && J>=0;I--,J--){
            if(checkboard[I][J]==true){
                return false;
            }
        }
        for(int I=i+1,J=j-1;I<checkboard.length && J>=0;I++,J--){
            if(checkboard[I][J]==true){
                return false;
            }
        }
        return true;
    }
    public void placingQueens(boolean checkboard[][],int col,ArrayList<ArrayList<Integer>> ans){
        if(col==checkboard.length){
            //problem in this
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<checkboard.length;i++){
                for(int j=0;j<checkboard.length;j++){
                    if(checkboard[i][j]==true){
                        temp.add(1);
                    }
                    else{
                        temp.add(0);
                    }
                }
            }
            ans.add(temp);
            return;
        }
        for(int i=0;i<checkboard.length;i++){
            if(queenPlace(i,col,checkboard)){
                checkboard[i][col]=true;
                placingQueens(checkboard, col+1, ans);
            }
            checkboard[i][col]=false;
        }
    }
    public ArrayList<ArrayList<Integer>> nQueens(int n)
    {
        boolean checkboard[][]=new boolean[n][n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        placingQueens(checkboard, 0, ans);
        return ans;
    } 
} 
public class nQueen{
    public static void main(String args[]){
        Solution findingWays=new Solution();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter board size:");
        int sizeBoard=input.nextInt();
        ArrayList<ArrayList<Integer>> ans=findingWays.nQueens(sizeBoard);
        System.out.println("Total no of ways:"+ans.size());
        //printing the checkboard in linear form
        for(int i=0;i<ans.size();i++){
            for(int value:ans.get(i)){
                System.out.print(value+" ");
            }
            System.out.println("");
        }
    }
}