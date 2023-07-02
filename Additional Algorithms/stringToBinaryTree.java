//string like 6(3)(2) to binary tree
//4(2(3)(1))(6(5))
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class stringToBinaryTree {
    static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void toBinaryTree(int index[],String str,Node head){
        while(true){
            if(index[0]==str.length()){
                return;
            }
            if(str.charAt(index[0])!='(' && str.charAt(index[0])!=')'){
                head.data=Integer.parseInt(str.charAt(index[0])+"");
                index[0]+=1;
            }
            if(str.charAt(index[0])==')'){
                //return to parent
                index[0]+=1;
                return;
            }
            if(str.charAt(index[0])=='('){
                index[0]+=1;
                if(head.left==null){
                    head.left=new Node(0);
                    toBinaryTree(index, str, head.left);
                }
                else{
                    head.right=new Node(0);
                    toBinaryTree(index, str, head.right);  
                } 
            }
        }
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        Node head=new Node(0);
        toBinaryTree(new int[] {0},str,head);
        preorder(head);
    }
}
