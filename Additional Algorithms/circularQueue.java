class cQ{
    public boolean full,empty;
    public int size,rem,add,queue[];
    public cQ(int size){
        this.size=size;
        this.rem=0;
        this.add=0;
        queue=new int[size];
        full=false;
        empty=false;
    }
    public void enqueue(int value){
        if(full){
            System.out.println("Overflow");
        }
        else{
            queue[add]=value;
            add=(add+1)%size;
            if(add==rem){
                full=true;
            }
            if(empty){
                empty=false;
            }
        }
    }
    public int dequeue(){
        if(empty){
            System.out.println("Underflow");
            return -1;
        }
        else{
            int value=queue[rem];
            rem=(rem+1)%size;
            if(add==rem){
                empty=true;
            }
            if(full){
                full=false;
            }
            System.out.println(value);
            return value;
        }
    }
}
class circularQueue {
    public static void main(String[] args) {
        cQ queue = new cQ(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);        
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
    }
}
