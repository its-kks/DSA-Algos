//searching a string in a 2D array in 8 directions possible
import java.util.*;

import temporaryFiles.Solution;
class SearchingString2Darray{
    public static void main(String args[]){
        char a[][] =new char[][]{
            {'c','e','e','a'},
            {'c','b','e','d'},
            {'d','d','c','e'},
            {'a','d','e','d'},
            {'a','b','a','e'},
            {'b','e','e','b'},
            {'c','d','a','d'},
            {'d','e','e','c'},
            {'e','d','a','e'}
        };
        Solution ans=new Solution();
        ans.find2D("d", a);
    }
}

class Solution{
    public void bubbleSort(ArrayList<ArrayList<Integer>> ansList){
        for(int i=0;i<ansList.size()-1;i++){
            boolean flag=false;
            for(int j=0;j<ansList.size()-1-i;j++){
                if(ansList.get(j).get(0)>=ansList.get(j+1).get(0)){
                    if(ansList.get(j).get(0)==ansList.get(j+1).get(0)){
                        if(ansList.get(j).get(1)<=ansList.get(j+1).get(1)){
                            continue;
                        }
                    }
                    ArrayList<Integer> temp=ansList.get(j);
                    ansList.set(j,ansList.get(j+1));
                    ansList.set(j+1,temp);
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
    public void addingAns(HashSet<Integer> ansSet,ArrayList<ArrayList<Integer>> ansList,int row,int col){
        if(ansSet.contains(row*7+col*9)){
            return;
        }
        else{
            ArrayList<Integer> toPush=new ArrayList<>(2);
            toPush.add(row);
            toPush.add(col);
            ansList.add(toPush);
            ansSet.add(row*7+col*9);
        }
    }
    public void find2D(String str,char matrix[][]){
        HashSet<Integer> ansSet=new HashSet<>();
        ArrayList<ArrayList<Integer>> ansList=new ArrayList<>();  
        int indexR=0;
        int indexC=0;
        int rindexR=0;
        int rindexC=0;
        int norT=0;
        int revT=str.length()-1;
        int counter=0;
        boolean revS=false;
        boolean norS=false;
        //traversing horizontally
        for(int i=0;i<matrix.length;i++){
            revS=false;
            norS=false;
            for(int j=0;j<matrix[0].length;j++){
                if(norS==true){
                    if(matrix[i][j]==str.charAt(norT)){
                        norT++;
                    }
                    else{
                        norT=0;
                        norS=false;
                    }
                }
                if(revS==true){
                    if(matrix[i][j]==str.charAt(revT)){
                        revT--;
                    }
                    else{
                        revT=str.length()-1;
                        revS=false;
                    }
                }
                if(norS==false && matrix[i][j]==str.charAt(norT)){
                    indexR=i;
                    indexC=j;
                    norT++;
                    norS=true;
                }
                if(revS==false && matrix[i][j]==str.charAt(revT)){
                    rindexR=i;
                    rindexC=j;
                    revT--;
                    revS=true;
                }
                if(norT==str.length()){
                    counter++;
                    norT=0;
                    addingAns(ansSet, ansList, indexR, indexC);

                }
                if(revT==-1){
                    counter++;
                    revT=str.length()-1;
                    addingAns(ansSet, ansList, i, j);
                }
            }
            norT=0;
            revT=str.length()-1;
        }
        
        norT=0;
        revT=str.length()-1;
        revS=false;
        norS=false;
        //traversing vertically
        for(int j=0;j<matrix[0].length;j++){
            revS=false;
            norS=false;
            for(int i=0;i<matrix.length;i++){
                if(norS==true){
                    if(matrix[i][j]==str.charAt(norT)){
                        norT++;
                    }
                    else{
                        norT=0;
                        norS=false;
                    }
                }
                if(revS==true){
                    if(matrix[i][j]==str.charAt(revT)){
                        revT--;
                    }
                    else{
                        revT=str.length()-1;
                        revS=false;
                    }
                }
                if(norS==false && matrix[i][j]==str.charAt(norT)){
                    indexR=i;
                    indexC=j;
                    norT++;
                    norS=true;
                }
                if(revS==false && matrix[i][j]==str.charAt(revT)){
                    rindexR=i;
                    rindexC=j;
                    revT--;
                    revS=true;
                }
                if(norT==str.length()){
                    counter++;
                    norT=0;
                    addingAns(ansSet, ansList, indexR, indexC);

                }
                if(revT==-1){
                    counter++;
                    revT=str.length()-1;
                    addingAns(ansSet, ansList, i, j);
                }
            }
            norT=0;
            revT=str.length()-1;
        }
        
        //traversing diagonally /
        norT=0;
        revT=str.length()-1;
        revS=false;
        norS=false;
        int i=0;//row
        int j=matrix[0].length-1;//col
        int subCol=1;
        int subRow=matrix.length-1;
        while(true){
            revS=false;
            norS=false;
            while(j<matrix[0].length && i<matrix.length){
                if(norS==true){
                    if(matrix[i][matrix[0].length-j-1]==str.charAt(norT)){
                        norT++;
                    }
                    else{
                        norT=0;
                        norS=false;
                    }
                }
                if(revS==true){
                    if(matrix[i][matrix[0].length-j-1]==str.charAt(revT)){
                        revT--;
                    }
                    else{
                        revT=str.length()-1;
                        revS=false;
                    }
                }
                if(norS==false && matrix[i][matrix[0].length-j-1]==str.charAt(norT)){
                    indexR=i;
                    indexC=matrix[0].length-j-1;
                    norT++;
                    norS=true;
                }
                if(revS==false && matrix[i][matrix[0].length-j-1]==str.charAt(revT)){
                    rindexR=i;
                    rindexC=matrix[0].length-j-1;
                    revT--;
                    revS=true;
                }
                if(norT==str.length()){
                    counter++;
                    norT=0;
                    addingAns(ansSet, ansList, indexR, indexC);

                }
                if(revT==-1){
                    counter++;
                    revT=str.length()-1;
                    addingAns(ansSet, ansList, i,matrix[0].length-j-1 );
                }
                i++;
                j++;
                if(j==matrix[0].length || i==matrix.length){
                    break;
                }
            }
            norT=0;
            revT=str.length()-1;
            if(i==matrix.length && j==1){
                //matrix completed so breaking loop
                break;
            }
            if(subCol<matrix[0].length+1){
                //row start constant
                //col start changing
                subCol++;
                i=0;
                j=matrix[0].length-subCol;   
            }
            if(subCol==matrix[0].length+1){
                //row start changing 
                //col start constant
                j=0;
                i=matrix.length-subRow;
                subRow--;
            }
        }
        
        //traversing diagonally \
        norT=0;
        revT=str.length()-1;
        revS=false;
        norS=false;
        i=0;//row
        j=matrix[0].length-1;//col
        subCol=1;
        subRow=matrix.length-1;
        while(true){
            revS=false;
            norS=false;
            while(j<matrix[0].length && i<matrix.length){
                if(norS==true){
                    if(matrix[i][j]==str.charAt(norT)){
                        norT++;
                    }
                    else{
                        norT=0;
                        norS=false;
                    }
                }
                if(revS==true){
                    if(matrix[i][j]==str.charAt(revT)){
                        revT--;
                    }
                    else{
                        revT=str.length()-1;
                        revS=false;
                    }
                }
                if(norS==false && matrix[i][j]==str.charAt(norT)){
                    indexR=i;
                    indexC=j;
                    norT++;
                    norS=true;
                }
                if(revS==false && matrix[i][j]==str.charAt(revT)){
                    rindexR=i;
                    rindexC=j;
                    revT--;
                    revS=true;
                }
                if(norT==str.length()){
                    counter++;
                    norT=0;
                    addingAns(ansSet, ansList, indexR, indexC);

                }
                if(revT==-1){
                    counter++;
                    revT=str.length()-1;
                    addingAns(ansSet, ansList, i, j);
                }
                i++;
                j++;
                if(j==matrix[0].length || i==matrix.length){
                    break;
                }
            }
            norT=0;
            revT=str.length()-1;
            if(i==matrix.length && j==1){
                //matrix completed so breaking loop
                break;
            }
            if(subCol<matrix[0].length+1){
                //row start constant
                //col start changing
                subCol++;
                i=0;
                j=matrix[0].length-subCol;   
            }
            if(subCol==matrix[0].length+1){
                //row start changing 
                //col start constant
                j=0;
                i=matrix.length-subRow;
                subRow--;
            }
        }
        
        int ans[][]=new int[ansList.size()][];
        int index=0;
        bubbleSort(ansList);
        for(ArrayList<Integer> temp:ansList){
            ans[index]=new int[]{temp.get(0),temp.get(1)};
            index++;
        }
        for(int k=0;k<ans.length;k++){
            for(int m=0;m<ans[0].length;m++){
                System.out.print(ans[k][m]);
            }
            System.out.println("");
        }
    }
}