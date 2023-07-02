import java.util.*;
public class postOrderIterative {
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
    ArrayList<Integer> postOrder(Node root) {
        //postOrder traversal iterative
        Stack<Integer> values=new Stack<>();
        Stack<Node> stack=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        stack.push(root);
        while(stack.size()!=0){
            Node trav=stack.pop();
            values.push(trav.data);
            if(trav.left!=null){
                stack.push(trav.left);
            }
            if(trav.right!=null){
                stack.push(trav.right);
            }
        }
        while(!values.empty()){
            ans.add(values.pop());
        }
        return ans;
    }
}