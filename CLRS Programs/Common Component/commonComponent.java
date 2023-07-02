import java.util.*;
class disjointSet{
    class linkedList{
        linkedListObject head;
        linkedListObject tail;
    }
    class linkedListObject{
        int value;
        linkedListObject next;
        linkedListObject representative;
        linkedListObject(int value){
            this.value=value;
            this.next=null;
            this.representative=this;
        }
    }
    Vector<linkedList> listOfSets=new Vector<linkedList>();
    void makeSet(int value){
        if(findSet(value)==null){
            linkedList newList=new linkedList();
            newList.head=new linkedListObject(value);
            newList.tail=newList.head;
            listOfSets.add(newList);
        }
    }
    linkedListObject findSet(int value){
        linkedListObject referenceValue=null;
        for(linkedList tempList:listOfSets){
            linkedListObject traversingNodes=tempList.head;
            while(traversingNodes!=null){
                if(traversingNodes.value==value){
                    referenceValue=traversingNodes.representative;
                    break;
                }
                traversingNodes=traversingNodes.next;
            }
        }
        return referenceValue;
    }
    void union(int x,int y){
        linkedListObject referenceX=findSet(x);
        linkedListObject referenceY=findSet(y);
        if(referenceX==null || referenceY==null){
            System.out.println("One of the value not found!");
            return;
        }
        linkedList listX=null;
        linkedList listY=null;
        //for check
        for(linkedList traversingListOfSet:listOfSets){
            if(traversingListOfSet.head==referenceX){
                listX=traversingListOfSet;
            }
            else if(traversingListOfSet.head==referenceY){
                listY=traversingListOfSet;
            }
        }
        listX.tail.next=listY.head;
        listX.tail=listY.tail;
        linkedListObject yNodeTraversal=listY.head;
        while(yNodeTraversal!=null){
            yNodeTraversal.representative=listX.head;
            yNodeTraversal=yNodeTraversal.next;
        }
        listOfSets.remove(listY);
    }
    void printAllDisjointSets(){
        for(linkedList traversingList:listOfSets){
            linkedListObject traversingSet=traversingList.head;
            while(traversingSet!=null){
                System.out.print(traversingSet.value+" ");
                traversingSet=traversingSet.next;
            }
            System.out.println("");
        }
    }
}
public class commonComponent{
    public static void graphInput(Vector<Vector<Integer>> graph,int noOfVertex){
        Scanner input=new Scanner(System.in);
        for(int i=0;i<noOfVertex;i++){
            System.out.print("Enter vertex value:");
            graph.get(i).add(input.nextInt());
            int noOfAdjacentVertex=0;
            System.out.print("Enter no of adjacent vertex:");
            noOfAdjacentVertex=input.nextInt();
            while(noOfAdjacentVertex--!=0){
                System.out.print("Enter adjacent vertex:");
                graph.get(i).add(input.nextInt());
            }
        }
    }
    public static void main(String args[]){
        Vector<Vector<Integer>> graph=new Vector<Vector<Integer>>();
        int noOfVertex=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of vertex:");
        noOfVertex=input.nextInt();
        for(int i=0;i<noOfVertex;i++){
            graph.add(new Vector<Integer>());
        }
        graphInput(graph, noOfVertex);
        disjointSet disjointSet=new disjointSet();
        // Finding Connected graphs
        for(int i=0;i<graph.size();i++){
            disjointSet.makeSet(graph.get(i).get(0));
        }
        for(int i=0;i<graph.size();i++){
            for(int j=1;j<graph.get(i).size();j++){
                if(disjointSet.findSet(graph.get(i).get(0))!=disjointSet.findSet(graph.get(i).get(j))){
                    disjointSet.union(graph.get(i).get(0),graph.get(i).get(j));
                }
            }
        }
        System.out.println("\n"+"There are "+disjointSet.listOfSets.size()+" disconnected graphs.");
        System.out.println("Graphs:");
        disjointSet.printAllDisjointSets();
    }
} 