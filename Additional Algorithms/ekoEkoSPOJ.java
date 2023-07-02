import java.util.*;
class ekoEkoSPOJ{
    public static boolean enoughWood(int height[],int woodNeeded,int bladeHeight){
        int woodCut=0;
        for(int h:height){
            if(h>bladeHeight)
                woodCut+=h-bladeHeight;
        }
        if(woodCut>=woodNeeded){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int noTrees=input.nextInt();
        int woodNeeded=input.nextInt();
        int height[]=new int[noTrees];
        int left=0,right=-1,ans=-1;
        for(int i=0;i<height.length;i++){
            height[i]=input.nextInt();
            if(height[i]>right){
                right=height[i];
            }
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(enoughWood(height,woodNeeded,mid)){
                ans=mid;
                //increase height
                left=mid+1;
            }
            else{
                //decrease height
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}