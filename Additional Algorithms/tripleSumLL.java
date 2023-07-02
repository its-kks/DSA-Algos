import java.util.Scanner;

class Node{
    Node next;
    Node prev;
    int data;
    Node(int data){
        this.data=data;
        next=null;
        prev=null;
    }
}
public class tripleSumLL {

    public static Node makeDLL(){
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
                traverse.next.prev=traverse;
                traverse=traverse.next;
            }
        }
        return ans;
    }
    public static void printTriplets(Node head,int value){
        int sum=value;
        Node i=head,tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        while(i.next.next!=null){
            //data must be smaller than sum not only 
            //smaller <=sum/3 as if a preeceding elements
            //will cover covers more sum/3 the left elements 
            //a left sum <2*(sum/3) which is impossible
            //in a list which is sorted in ascending order
            if(i.data<=(sum/3)){
                sum-=i.data;
                Node left=i.next,right=tail;
                while(left.data<right.data){
                    if(left.data+right.data>sum){
                        right=right.prev;
                    }
                    else if(left.data+right.data<sum){
                        left=left.next;
                    }
                    else{
                        System.out.println(i.data+","+left.data+","+right.data+" ");
                        left=left.next;
                        right=right.prev;
                    }
                }
            }
            i=i.next;
            sum=value;
        }
    }
    public static void main(String args[]){
        //finding sum of triplets in DLL in O(n^2)
        Node head=makeDLL();
        System.out.print("Enter value to find:");
        Scanner input=new Scanner(System.in);
        int toFind=input.nextInt();
        printTriplets(head, toFind);
    }
}
