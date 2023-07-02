import java.util.*;
public class preorderTravIterative {
    public static void main(String args[]){
        
    }
}
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Solution {
    ArrayList<Integer> preorder(Node root) {
        //preorder traversal iterative
        Stack<Node> stack=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        Node trav=root;
        while(stack.size()!=0 || trav!=null){
            if(trav!=null){
                ans.add(trav.data);
                stack.push(trav);
                trav=trav.left;
            }
            else{
                trav=stack.pop();
                trav=trav.right;
            }
        }
        return ans;
    }
}