import java.util.*;
class keyPadToString{
    public static void main(String args[]){
        Map<Integer,String> values=new HashMap<>();
        int temp='A';
        for(int i=0;i<8;i++){
            char value=(char)(i+2+'0');
            String toAdd=value+"";
            values.put(temp,toAdd);
            int num=2;
            if(i==5 || i==7){
                num++;
            }
            for(int j=0;j<num;j++){
                temp++;
                toAdd+=value;
                values.put(temp,toAdd);
            }
            temp++;
        }
        values.put((int)' ',"0");
        Scanner input=new Scanner(System.in);
        String stringToConvert=input.nextLine();
        String ans="";
        for(int i=0;i<stringToConvert.length();i++){
            ans+=values.get((int)stringToConvert.charAt(i));
        }
        System.out.println("Keypade ans:"+ans);
    }
}