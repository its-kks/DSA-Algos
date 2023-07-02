//time complexity 
import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class palindromeMinSwapsN
{
	public static void main(String[] args) {
		Solution tempClass=new Solution();
		System.out.println(tempClass.minMovesToMakePalindrome("skwhhaaunskegmdtutlgtteunmuuludii"));
	}
}
class Solution {
    //i ko age shift krna he
    public void replaceLeft(LinkedList<Character> array,int i,int k1){
        // System.out.println(array.get(i)+" "+array.get(k1));
        array.add(i,array.get(k1));
        array.remove(k1+1);
    }
    //i is the right character
    public void replaceRight(LinkedList<Character> array,int j,int k2){
        array.add(j+1,array.get(k2));
        array.remove(k2);
    }
    public int minMovesToMakePalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        int count=0;
        LinkedList<Character> array=new LinkedList<>();
        Map<Character,ArrayDeque<Integer>> mapCharacter=new HashMap<>();
        for(int index=0;index<s.length();index++){
            if(mapCharacter.get(s.charAt(index))==null){
                mapCharacter.put(s.charAt(index),new ArrayDeque<>());
                mapCharacter.get(s.charAt(index)).add(index);
            }
            else{
                mapCharacter.get(s.charAt(index)).add(index);
            }
            array.add(s.charAt(index));
        }
        for(;i<=j;){
            int k1=i+1,k2=j-1;
            if(array.get(i)!=array.get(j)){//here
                // for(;k1<j;k1++){
                //     if(array.get(k1)==array.get(j)){
                //         break;
                //     }
                // }
                // for(;k2>i;k2--){
                //     if(array.get(k2)==array.get(i)){
                //         break;
                //     }
                // }
                k1=mapCharacter.get(array.get(j)).
                if(k1-i>j-k2){
                    // System.out.println("j;"+j+" "+"k2:"+k2);
                    replaceRight(array,j,k2);
                    // for(int index=0;index<array.size();index++){
                    //     System.out.print(array.get(index)+" ");
                    // }
                    // System.out.println("");
                    count+=j-k2;
                }
                else{
                    // System.out.println("i;"+i+" "+"k1:"+k1);
                    replaceLeft(array,i,k1);
                    // for(int index=0;index<array.size();index++){
                    //     System.out.print(array.get(index)+" ");
                    // }
                    // System.out.println("");
                    count+=k1-i;
                }
            }
            i++;
            j--;
        }
        return count;
    }
}