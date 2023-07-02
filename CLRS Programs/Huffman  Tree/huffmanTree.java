import java.util.*;
class queueObject{
    int frequency;
    String s;
    queueObject left;
    queueObject right;
    queueObject(int value,String s){
        this.frequency=value;
        this.s=s;
        this.left=null;
        this.right=null;
    }
    queueObject(){
        this.right=null;
        this.left=null;
    }
}
class minPriorityQueue{
    public Vector<queueObject> v;
    public int size;
    static final int infinite=2147483647;
    minPriorityQueue(int s){
        this.size=s;
        v=new Vector<queueObject>();
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
        queueObject temp=v.get(i);
        v.set(i,v.get(j));
        v.set(j,temp);
    }
    void minHeapify(int index){
        int smallest;
        int left=leftChild(index);
        int right=rightChild(index);
        if(left<size && v.elementAt(index).frequency>v.elementAt(left).frequency){
            smallest=left;
        }
        else{
            smallest=index;
        }
        if(right<size && v.elementAt(smallest).frequency>v.elementAt(right).frequency){
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
            System.out.print(v.elementAt(i).s+","+v.elementAt(i).frequency+"   ");
        }
        System.out.print("\n");
    }
    queueObject extractMin(){
        queueObject temp=v.get(0);
        v.set(0,v.get(size-1));
        size=size-1;
        minHeapify(0);
        return temp;
    }
    void decreaseKey(queueObject ver,int i){
        if(ver.frequency>v.get(i).frequency){
            System.out.println("Key is larger!");
            return;
        }
        while(i!=0 && v.get(parent(i)).frequency>ver.frequency){
            v.set(i,v.get(parent(i)));
            i=parent(i);
        }
        v.set(i,ver);
    }
    void insertKey(queueObject ver){
        size++;
        queueObject tempver=new queueObject();
        tempver.s="KKS";
        tempver.frequency=infinite;
        v.set(size-1,tempver);
        decreaseKey(ver,size-1);
    }
}
public class huffmanTree{
    public static queueObject makingHuffmanTree(minPriorityQueue q){
        q.buildMinHeap();
        while(q.size!=1){
            queueObject qObject1=q.extractMin();
            queueObject qObject2=q.extractMin();
            queueObject newObject=new queueObject();
            newObject.frequency=qObject1.frequency+qObject2.frequency;
            newObject.s=qObject1.s+qObject2.s;
            newObject.left=qObject1;
            newObject.right=qObject2;
            q.insertKey(newObject);
        }
        return q.extractMin();
    }
    public static void backTracking(HashMap<String,String> variableCode,queueObject hTree,String code){
        if(hTree.left==null){
            variableCode.put(hTree.s,code);
            return;
        }
        backTracking(variableCode, hTree.left,code+"0");
        backTracking(variableCode, hTree.right, code+"1");
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter string to code:");
        String toEncode=input.next();
        //using set to find the different elements presetn
        HashSet<Character> setChar=new HashSet<Character>();
        for(int i=0;i<toEncode.length();i++){
            setChar.add(toEncode.charAt(i));
        }
        //making minPriorityQueue
        minPriorityQueue queue=new minPriorityQueue(setChar.size());
        //using hashmap to find the frequency of each character in string
        HashMap<Character,Integer> mapFrequency=new HashMap<Character,Integer>();
        for(char c:setChar){
            mapFrequency.put(c,0);
        }
        for(int i=0;i<toEncode.length();i++){
            int value=mapFrequency.get(toEncode.charAt(i));
            value++;
            mapFrequency.replace(toEncode.charAt(i),value);
        }
        //adding objects to the priorityQueue with frequency from 
        //mapFrequency HashMap and characters from setChar HashSet
        for(char c:setChar){
            queue.v.add(new queueObject(mapFrequency.get(c),c+""));
        }
        queueObject hashTree=makingHuffmanTree(queue);
        //hash map having codes for each character
        HashMap<String,String> codeMap=new HashMap<>();
        backTracking(codeMap, hashTree, "");
        // System.out.println(hashTree.frequency);
        for(char c:setChar){
            System.out.println(c+":"+codeMap.get(c+""));
        }
        //printing code for the string entered
        String ans="";
        for(int i=0;i<toEncode.length();i++){
            ans+=codeMap.get(toEncode.charAt(i)+"");
        }
        System.out.println("The encoded string is:"+ans);
    }
}