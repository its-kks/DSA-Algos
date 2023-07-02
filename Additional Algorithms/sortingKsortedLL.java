import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data=data;
    }
}
public class sortingKsortedLL {
    public static Node makeSLL(){
        Node ans=null,traverse=ans;
        System.out.print("Enter no of nodes:");
        Scanner input=new Scanner(System.in);
        int count=0;
        count=input.nextInt();
        while(count--!=0){
            System.out.print("Enter node value:");
            if(ans==null){
                ans=new Node(input.nextInt());
                traverse=ans;
            }
            else{
                traverse.next=new Node(input.nextInt());
                traverse=traverse.next;
            }
        }
        return ans;
    }
    public static void sortingKsorted()
    public static void main(String args[]){

    }
}
