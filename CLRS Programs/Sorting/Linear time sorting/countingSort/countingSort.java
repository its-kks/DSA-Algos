public class countingSort{
    public static void main(String args[]){
        int arrayToSort[]=new int[]{1,5,5,7,8,0,7,5,3,10};
        int max=arrayToSort[0];
        for(int i=1;i<arrayToSort.length;i++){
            if(arrayToSort[i]>max){
                max=arrayToSort[i];
            }
        }
        int keyArray[]=new int[max+1];
        for(int i=0;i<arrayToSort.length;i++){
            keyArray[arrayToSort[i]]++;
        }
        //updating key array for actual position
        for(int i=1;i<keyArray.length;i++){
            keyArray[i]+=keyArray[i-1];
        }
        int sortedArray[]=new int[arrayToSort.length];
        //adding values to new sorted array
        for(int i=arrayToSort.length-1;i>=0;i--){
            sortedArray[--keyArray[arrayToSort[i]]]=arrayToSort[i];
        }
        //printing sorted array
        for(int value:sortedArray){
            System.out.print(value+" ");
        }
    }
}