import java.util.*;
class Item{
    float price;
    float weight;
}
public class fractionalKnapsack{
    static int partition(Vector<Item> v,int high,int low){
        int i=low-1;
        int j=low;
        for(;j<=high;j++){
            if(v.get(j).price>v.get(high).price){
                i++;
                Item temp=v.get(i);
                v.set(i,v.get(j));
                v.set(j,temp);
            }
        }
        i++;
        Item temp=v.get(i);
        v.set(i,v.get(high));
        v.set(high,temp);
        return i;

    }
    static void quickSort(Vector<Item> v,int high,int low){
        if(low<high){
            int pivot=partition(v,high,low);
            quickSort(v,pivot-1,low);
            quickSort(v,high,pivot+1);
        }
    }
    public static void main(String[] args){
        Vector<Item> items=new Vector<Item>();
        Scanner input=new Scanner(System.in);
        int numberOfItem;
        System.out.print("Enter no of items:");
        numberOfItem=input.nextInt();
        int knapsackWeight;
        System.out.print("Enter weight of knapsack:");
        knapsackWeight=input.nextInt();
        for(int i=0;i<numberOfItem;i++){
            Item temp=new Item();
            System.out.print("Enter price of item "+i+":");
            temp.price=input.nextFloat();
            System.out.print("Enter weight of item "+i+":");
            temp.weight=input.nextFloat();
            items.add(temp);
        }
        float profit=0;
        quickSort(items,numberOfItem-1,0);
        for(int i=0;knapsackWeight!=0;i++){
            if(items.get(i).weight>knapsackWeight){
                profit+=(knapsackWeight/items.get(i).weight)*items.get(i).price;
                knapsackWeight=0;
            }
            else{
                profit+=items.get(i).price;
                knapsackWeight-=items.get(i).weight;
            }
        }
        System.out.println("Profit:"+profit);
    }
}
