public class radixSort {
    public static int returnNthDigit(int nth,int number){
        int divisor=(int)Math.pow(10,nth-1);
        number=number/divisor;
        return number%10;
    }
    public static int[] countSortOnDigit(int nthDigit,int arrayToSort[]){
        int[] keyArray=new int[10];
        int[] outputArray=new int[arrayToSort.length];
        for(int value:arrayToSort){
            keyArray[returnNthDigit(nthDigit, value)]++;
        }
        for(int i=1;i<keyArray.length;i++){
            keyArray[i]+=keyArray[i-1];
        }
        for(int i=arrayToSort.length-1;i>=0;i--){
            outputArray[--keyArray[returnNthDigit(nthDigit,arrayToSort[i])]]=arrayToSort[i];
        }
        return outputArray;

    }
    public static void main(String args[]){
        //based on concept of counting sort
        //counting sort is applied on the digits of each number starting
        //from least significant digit to most (vice versa in case of string)
        int arrayToSort[]=new int[]{432,8,530,90,88,231,11,45,677,199};
        int max=arrayToSort[0];
        for(int value:arrayToSort){
            if(max<value){
                value=max;
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
            arrayToSort=countSortOnDigit(nthDigit++, arrayToSort);
        }
        //printing sorted array
        for(int value:arrayToSort){
            System.out.print(value+" ");
        }
    }
}
