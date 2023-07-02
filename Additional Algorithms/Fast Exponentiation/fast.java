import java.util.*;
public class fast {
    public static int fastExpo(int a,int n,int dp[]){//a^n
        if(n==0){
            return 1;
        }
        if(n==1){
            return a;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n%2!=0){
            return dp[n]=a*fastExpo(a,n/2,dp)*fastExpo(a,n/2,dp);
        }
        return dp[n]=fastExpo(a,n/2,dp)*fastExpo(a,n/2,dp);
    }
    //tabulated
    public static int expo(int a,int n){
        int tab[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            if(i==0){
                tab[i]=1;
                continue;
            }
            if(i==1){
                tab[i]=a;
                continue;
            }
            if(i%2!=0){
                tab[i]=a*tab[i/2]*tab[i/2];
                continue;
            }
            tab[i]=tab[i/2]*tab[i/2];
        }
        return tab[n];
    }
    public static void main(String args[]){
        int dp[]=new int[32];
        Arrays.fill(dp,-1);
        System.out.println(fastExpo(6, 10,dp));
        System.out.println(expo(6,10));        

    }
}