public class printingAllSubArrays {
    public static void printArray(int i,int j,int array[]){
        if(i==-1 || j==-1){
        }
        else{
            for(int I=i;I<=j;I++){
                System.out.print(array[I]+" ");
            }
            System.out.println("");
        }
    }
    public static void arraySubs(int start,int end,int array[],int toAdd){
        if(toAdd==array.length || (end!=-1 && end+1!=toAdd)){
            printArray(start, end, array);
            return;
        }
        //add bhi tbh hi krna he jb kuch common ho vrna ans return in case of matrix
        arraySubs(start,end,array,toAdd+1);
        if(start==-1){
            arraySubs(toAdd,toAdd,array,toAdd+1);
        }
        else{
            if(end+1==toAdd)
                arraySubs(start, toAdd, array, toAdd+1);
        }
    }
    public static void main(String args[]){    
        int array[]=new int[]{5,6,7,8,-8,3,63,31}; 
        arraySubs(-1, -1, array, 0);   
    }
}

