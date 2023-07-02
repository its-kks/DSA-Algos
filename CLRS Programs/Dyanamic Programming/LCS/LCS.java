import java.util.*;
public class LCS {
    static class matrixCell{
        int value;
        char sign;
        //sign takes the values:
        //L->left
        //T->toop
        //D->Diagonal
        //M->left or top
        //N->null
        matrixCell(){
            value=0;
            sign='N';
        }
    }
    public static void printSubstrings(Vector<Vector<matrixCell>> matrix,
    String s,int i,int j,String s1,String s2){
        if(i==0 || j==0){
            for(int k=s.length()-1;k!=-1;k--){
                System.out.print(s.charAt(k));
            }
            System.out.println("");
            return;
        }
        if(matrix.get(i).get(j).sign=='L'){
            printSubstrings(matrix, s, i, j-1,s1,s2);
        }
        else if(matrix.get(i).get(j).sign=='T'){
            printSubstrings(matrix, s, i-1, j,s1,s2);
        }
        else if(matrix.get(i).get(j).sign=='D'){
            String snew=new String(s+s1.charAt(i-1));
            printSubstrings(matrix, snew, i-1, j-1,s1,s2);
        }
        else{
            printSubstrings(matrix, s, i, j-1,s1,s2);
            printSubstrings(matrix, s, i-1, j,s1,s2);
        }
        return;
    }
    public static void findingSubsequence(String s1,String s2){
        Vector<Vector<matrixCell>> matrix=new Vector<Vector<matrixCell>>(s1.length()+1);
        for(int i=0;i<s1.length()+1;i++){
            matrix.add(new Vector<matrixCell>());
        }
        //initialisation
        for(int i=0;i<s1.length()+1;i++){
            matrixCell temp=new matrixCell();
            matrix.get(i).add(temp);
        }
        for(int i=0;i<s2.length()+1;i++){
            matrixCell temp=new matrixCell();
            matrix.get(0).add(temp);
        }
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                matrixCell temp=new matrixCell();
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp.value=matrix.get(i-1).get(j-1).value+1;
                    temp.sign='D';
                }
                else{
                    int valLeft=matrix.get(i).get(j-1).value;
                    int valTop=matrix.get(i-1).get(j).value;
                    if(valLeft==valTop){
                        temp.value=valLeft;
                        temp.sign='M';
                    }
                    else if(valLeft>valTop){
                        temp.value=valLeft;
                        temp.sign='L';
                    }
                    else{
                        temp.value=valTop;
                        temp.sign='T';
                    }
                }
                matrix.get(i).add(temp);
            }
        }
        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                System.out.print((matrix.get(i).get(j).value)+" "+
                matrix.get(i).get(j).sign+"  ");
            }
            System.out.println("");
        }
        System.out.println("Largest substring size:"+matrix.get(s1.length()).get(s2.length()).value);
        System.out.println("Substrings:");
        String empty=new String();
        printSubstrings(matrix,empty,(s1.length()),s2.length(),s1,s2);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter string 1:");
        String s1=new String(input.next());
        System.out.print("Enter string 2:");
        String s2=new String(input.next());
        findingSubsequence(s1, s2);
    }
}
//abcbdab
//bdcaba