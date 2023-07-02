import java.lang.*;
import java.util.*;
class minPriorityQueue{
    public Vector<vertex> v;
    public int size;
    static final int infinite=2147483647;
    minPriorityQueue(int s){
        this.size=s;;
        v=new Vector<vertex>();
    }
    int parent(int i){
        return (i-1)/2;
    }
    int leftChild(int i){
        return 2*i+1;
    }
    int rightChild(int i){
        return 2*i+2;
    }
    void swap(int i,int j){
        vertex temp=v.get(i);
        v.set(i,v.get(j));
        v.set(j,temp);
    }
    void minHeapify(int index){
        int smallest;
        int left=leftChild(index);
        int right=rightChild(index);
        if(left<size && v.elementAt(index).key>v.elementAt(left).key){
            smallest=left;
        }
        else{
            smallest=index;
        }
        if(right<size && v.elementAt(smallest).key>v.elementAt(right).key){
            smallest=right;
        }
        if(smallest!=index){
            swap(index,smallest);
            minHeapify(smallest);
        }
    }
    void buildMinHeap(){
        for(int i=size/2;i>=0;i--){
            minHeapify(i);
        }
    }
    void printMinHeap(){
        System.out.println("Printing Heap:");
        for(int i=0;i<size;i++){
            System.out.print(v.elementAt(i).key+","+v.elementAt(i).value+"   ");
        }
        System.out.print("\n");
    }
    vertex extractMin(){
        vertex temp=v.get(0);
        v.set(0,v.get(size-1));
        size--;
        minHeapify(0);
        return temp;
    }
    void decreaseKey(vertex ver,int i){
        if(ver.key>v.get(i).key){
            System.out.println("Key is larger!");
            return;
        }
        while(i!=0 && v.get(parent(i)).key>ver.key){
            v.set(i,v.get(parent(i)));
            i=parent(i);
        }
        v.set(i,ver);
    }
    void insertKey(vertex ver){
        size++;
        vertex tempver=new vertex();
        tempver.key=tempver.infinite;
        v.set(size-1,tempver);
        decreaseKey(ver,size-1);
    }
};
class vertex{
    final int infinite=2147483647;
    int value;
    int key;
    vertex pi;
}
class edge{
    int u;
    int v;
    int weight;
    void printEdge(){
        System.out.print("("+u+","+v+") ");
    }
}
class Graph{
    int nV;
    int nE;
    Vector<vertex> v;
    Vector<edge> e;
    Graph(){
        v=new Vector<vertex>();
        e=new Vector<edge>();
        Scanner input=new Scanner(System.in);
        System.out.print("Enter number of vertex:");
        nV=input.nextInt();
        System.out.print("Enter number of edges:");
        nE=input.nextInt();
        System.out.println("Enter the Edge:");
        for(int i=0;i<nE;i++){
            edge temp=new edge();
            System.out.println("Enter (u,v):");
            System.out.print("u:");
            temp.u=input.nextInt();
            System.out.print("v:");
            temp.v=input.nextInt();
            System.out.print("weight:");
            temp.weight=input.nextInt();
            e.addElement(temp);
        }
        for(int i=1;i<nV+1;i++){
            vertex temp=new vertex();
            temp.key=temp.infinite;
            temp.pi=null;
            temp.value=i;
            v.addElement(temp);
        }
    }
    void mstPrims(){
        for(int i=0;i<nV;i++){
            v.get(i).key=v.get(i).infinite;
            v.get(i).pi=null;
        }
        v.get(0).key=0;
        minPriorityQueue Q=new minPriorityQueue(0);
        for(int i=0;i<nV;i++){
            Q.insertKey(v.get(i));
        }
        System.out.println("MST:");
        while(Q.size!=0){
            vertex u=Q.extractMin();
            if(u.pi!=null){
                System.out.println("("+u.value+","+u.pi.value+")");
            }
            for(int i=0;i<nE;i++){
                if(e.get(i).u==u.value || e.get(i).v==u.value){
                    int value,pos,Qpos;
                    if(e.get(i).u==u.value){
                        value=e.get(i).v;
                    }
                    else{
                        value=e.get(i).u;
                    }
                    for(pos=0;pos<nV;pos++){
                        if(v.get(pos).value==value){
                            break;
                        }
                    }
                vertex w=v.get(pos);
                boolean presentInQ=false;
                for(Qpos=0;Qpos<Q.size;Qpos++){
                    if(Q.v.get(Qpos).value==w.value){
                        presentInQ=true;
                        break;
                    }
                }
                if(presentInQ && e.get(i).weight<w.key){
                    w.pi=u;
                    w.key=e.get(i).weight;
                    Q.decreaseKey(w,Qpos);

                }
                }
            }
        }

    }

}
class primsAlgo{
    public static void main(String[] args) {
        Graph G=new Graph();
        G.mstPrims();
        
    }
}