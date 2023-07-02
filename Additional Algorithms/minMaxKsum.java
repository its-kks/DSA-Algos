import java.util.*;
public class minMaxKsum{
    public static void printValues(int arr[],int end,int start,int max,int min){
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print(" Min:"+min);        
        System.out.println(" Max:"+max);
    }
    public static void printMaxMin(int arr[],int k){
        Deque<Integer> L=new LinkedList<>();
        Deque<Integer> S=new LinkedList<>();
        //initialisation
        for(int i=0;i<k;i++){
            //L
            while(L.size()!=0 && arr[L.peekFirst()]<arr[i]){
                L.pop();
            }
            L.add(i);
            //S
            while(S.size()!=0 && arr[S.peekFirst()]>arr[i]){
                S.pop();
            }
            S.add(i);
        }
        printValues(arr,k-1,0,arr[L.peekFirst()],arr[S.peekFirst()]);
        for(int i=k;i<arr.length;i++){
            //remove elements not in current range
            while(L.size()!=0 && L.peekFirst()<=i-k){
                L.removeFirst();
            }
            while(S.size()!=0 && S.peekFirst()<=i-k){
                S.removeFirst();
            }
            //adding value
            while(L.size()!=0 && arr[L.peekFirst()]<arr[i]){
                L.pop();
            }
            L.add(i);
            //S
            while(S.size()!=0 && arr[S.peekFirst()]>arr[i]){
                S.pop();
            }
            S.add(i);
            //printValues
            printValues(arr,i,i-k+1,arr[L.peekFirst()],arr[S.peekFirst()]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 8, 1,4,2,6};
        int k = 3;

        printMaxMin(arr, k);
    }
}