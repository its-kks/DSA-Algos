import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class BST{
    Node root;
    BST(){
        root=null;
    }
    void inorderTrav(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorderTrav(root.left,list);
        list.add(root.data);
        inorderTrav(root.right,list);
    }
    void preorderTrav(Node root,ArrayList<Integer> list,int[] index){
        if(root==null){
            return;
        }
        root.data=list.get(index[0]);
        index[0]++;
        preorderTrav(root.left, list, index);
        preorderTrav(root.right, list, index);
    }
    void insert(Node root,int data){
        Node x=root;
        Node y=null;
        while(x!=null){
            y=x;
            if(x.data>data){
                x=x.left;
            }
            else{
                x=x.right;
            }
        }
        if(y==null){
           //BST was empty
           this.root=new Node(data); 
        }
        else{
            if(y.data>data){
                y.left=new Node(data);
            }
            else{
                y.right=new Node(data);
            }
        }
    }
    void create(int ... data){
        //here data is an array of integers
        for(int i:data){
            insert(root,i);
        }
    }
    void levelOrderTrav(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp=q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                System.out.print(temp.data+" ");
            }
            System.out.println("");
        }
    }
}
public class BSTtoMinHeap{
    public static void main(String[] args){
        BST bst=new BST();
        bst.create(4,2,6,1,3,5,7);
        bst.levelOrderTrav(bst.root);
        ArrayList<Integer> temp=new ArrayList<>();
        bst.inorderTrav(bst.root, temp);
        System.out.println(temp);
        bst.preorderTrav(bst.root, temp, new int[]{0});
        //converted to Min heap
        bst.levelOrderTrav(bst.root);
    }
}