import java.util.*;
import java.lang.*;
public class ALS{
    static void inputStation(Vector<Integer> v,int size ){
        Scanner input=new Scanner(System.in);
        for(int i=0;i<size;i++){
            System.out.print("Enter cost of station "+(i+1)+":");
            v.add(input.nextInt());
        }
    }
    static void assembling(Vector<Integer> cost1,Vector<Integer> cost2,Vector<Integer> cross1,
    Vector<Integer> cross2){
        Vector<Vector<Integer>> totalCost=new Vector<Vector<Integer>>();
        Vector<Vector<Integer>> stationBeforeAL=new Vector<Vector<Integer>>();
        totalCost.add(new Vector<Integer>());
        totalCost.add(new Vector<Integer>());
        stationBeforeAL.add(new Vector<Integer>());
        stationBeforeAL.add(new Vector<Integer>());
        totalCost.get(0).add(cost1.get(0)+cost1.get(1));
        totalCost.get(1).add(cost2.get(0)+cost2.get(1));
        for(int i=1;i<=cross1.size();i++){
            if(totalCost.get(0).get(i-1)<=totalCost.get(1).get(i-1)+cross2.get(i-1)){
                totalCost.get(0).add(totalCost.get(0).get(i-1)+cost1.get(i+1));
                stationBeforeAL.get(0).add(1);
            }
            else{
                totalCost.get(0).add(totalCost.get(1).get(i-1)+cross2.get(i-1)+cost1.get(i+1));
                stationBeforeAL.get(0).add(2);
            }
            if(totalCost.get(1).get(i-1)<=totalCost.get(0).get(i-1)+cross1.get(i-1)){
                totalCost.get(1).add(totalCost.get(1).get(i-1)+cost2.get(i+1));
                stationBeforeAL.get(1).add(2);
            }
            else{
                totalCost.get(1).add(totalCost.get(0).get(i-1)+cross1.get(i-1)+cost2.get(i+1));
                stationBeforeAL.get(1).add(1);
            }
        }
        totalCost.get(0).add(cost1.get(cost1.size()-1)+totalCost.get(0).lastElement());
        totalCost.get(1).add(cost2.get(cost1.size()-1)+totalCost.get(1).lastElement());
        int exitedFrom=0;
        if(totalCost.get(0).get(totalCost.get(0).size()-1)>totalCost.get(1).get(totalCost.get(0).size()-1)){
            exitedFrom=2;
        }
        else{
            exitedFrom=1;
        }
        for(int i=stationBeforeAL.get(0).size()-1;i!=-2;i--){
            System.out.println("Station:"+(i+2)+" Assembly Line:"+exitedFrom);
            System.out.println("              ↑");
            if(i==-1)
                break;
            exitedFrom=stationBeforeAL.get(exitedFrom-1).get(i);
        }
        System.out.println("          Entrance");

    }
    public static void main(String[] args) {
        int noOfStations=0;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter no of stations on single assembly line:");
        noOfStations=input.nextInt();
        Vector<Integer> cost1=new Vector<Integer>();
        Vector<Integer> cost2=new Vector<Integer>();
        Vector<Integer> cross1=new Vector<Integer>();
        Vector<Integer> cross2=new Vector<Integer>();
        System.out.println("Enter cost of 1st AL:");
        inputStation(cost1,noOfStations+2);
        System.out.println("Enter cost of 1st AL:");
        inputStation(cost2,noOfStations+2);
        System.out.println("Cost AL1 to AL2:");
        inputStation(cross1, noOfStations-1);
        System.out.println("Cost AL2 to AL1:");
        inputStation(cross2, noOfStations-1);
        assembling(cost1, cost2, cross1, cross2);

    }

}