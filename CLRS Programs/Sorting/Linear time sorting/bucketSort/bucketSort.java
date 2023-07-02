import java.util.PriorityQueue;
import java.util.Vector;
public class bucketSort {
    public static int returnNthDigit(int nth,int number){
        int divisor=(int)Math.pow(10,nth-1);
        number=number/divisor;
        return number%10;
    }
    public static void main(String args[]){
        int arrayToSort[]=new int[]{15,1,321,10,802,2,123,90,109,11};
        Vector<PriorityQueue<Integer>> vectorOfQueue=new Vector<PriorityQueue<Integer>>(10);
        for(int i=0;i<10;i++){
            vectorOfQueue.add(new PriorityQueue<Integer>());
        }
        int max=arrayToSort[0];
        for(int i=1;i<arrayToSort.length;i++){
            if(arrayToSort[i]>max){
                max=arrayToSort[i];
            }
        }
        int noOfDigits=0;
        int temporaryValue=max;
        while(temporaryValue!=0){
            noOfDigits++;
            temporaryValue=temporaryValue/10;
        }
        int nthDigit=1;
        while(noOfDigits--!=0){
            for(int i=arrayToSort.length-1;i>-1;i--){
                vectorOfQueue.get(returnNthDigit(nthDigit++,arrayToSort[i])).add(arrayToSort[i]);
            }
            int indexArrayToSort=0;
            for(int i=0;i<vectorOfQueue.size();i++){
                while(vectorOfQueue.get(i).isEmpty()!=true){
                    arrayToSort[indexArrayToSort++]=vectorOfQueue.get(i).remove();
                }
            }
        }
        //printing sorted array
        for(int value:arrayToSort){
            System.out.print(value+" ");
        }

    }    
}
