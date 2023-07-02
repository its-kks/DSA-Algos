import java.util.*;
public class removeConsecutiveDuplicatesRecursively {
    public static String recursiveString(String s,String ans,int index,char prev){
        if(index==s.length()){
            return ans;
        }
        if(index==0){
            ans+=s.charAt(index);
            prev=s.charAt(index);
        }
        else{
            if(prev!=s.charAt(index)){
                ans+=s.charAt(index);
                prev=s.charAt(index);
            }
        }
        return recursiveString(s, ans, index+1, prev);

    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter string:");
        String s=input.next();
        System.out.println(recursiveString(s, "", 0, ' '));
    }
}
