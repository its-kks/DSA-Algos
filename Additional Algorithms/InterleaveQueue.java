import java.util.LinkedList;
import java.util.Queue;
public class InterleaveQueue {
    public static void interleave(Queue<Integer> q){
        int value=q.size()/2;
        Queue<Integer> tempQ=new LinkedList<>();
        while(value!=0){
            tempQ.add(q.poll());
            value--;
        }
        while(!tempQ.isEmpty()){
            q.add(tempQ.poll());
            q.add(q.poll());
        }
    }
    public static void main(String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        interleave(q);
        System.out.println(q);
    }
}
