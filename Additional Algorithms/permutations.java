import java.util.*;
public class permutations {
    public static List<String> printPermutations(String s){
        List<String> ans=new ArrayList<>();
        int array[]=new int[s.length()];
        for(int i=0;i<array.length;i++){
            array[i]=-1;
        }
        HashSet<Integer> tempSet=new HashSet<>();
        int i=0;
        while(true){
            array[i]++;
            while(array[i]!=s.length() && tempSet.contains(array[i])){
                array[i]++;
            }
            //either array[i] has a valid index
            //move to next index
            if(array[i]!=s.length()){
                if(i==s.length()-1){
                    String tempString="";
                    for(int j=0;j<array.length;j++){
                        tempString+=s.charAt(array[j]);
                    }
                    if(ans.contains(tempString)==false){
                        ans.add(tempString);;
                    }
                }
                else{
                    tempSet.add(array[i]);
                    i++;
                    continue;
                }

            }
            // invalid hoga yaa string print ho gayi hogi to yha tk pohoch jaega
            if(i!=0){
                array[i]=-1;
                i--;
                tempSet.remove(array[i]);
            }
            else{
                break;
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String args[]){
        List<String> ans=printPermutations("ABSG");
        for(String S:ans){
            System.out.println(S);
        }
    }
}