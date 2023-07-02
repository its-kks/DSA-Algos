//week 5 q2
#include <algorithm>
#include <cstddef>
#include <ios>
#include <iostream>
#include <iterator>
using namespace std;
#define negInfinity -2147483648;
class bst{
    public:
        bst *left;
        bst *right;
        bst *p;
        int key;
        bst(){
            left=NULL;
            right=NULL;
            p=NULL;
            key=negInfinity;
        }
};
bst* max(bst *node){
    if(node->right!=NULL){
        return max(node->right);
    }
    else{
        cout<<node->key<<endl;
        return node;
    }
}
bst* min(bst *node){
    if(node->left!=NULL){
        return min(node->left);
    }
    else{
        cout<<node->key<<endl;
        return node;
    }
}
void inorderTraversal(bst *tree){
    if(tree!=NULL){
        inorderTraversal(tree->left);
        cout<<tree->key<<" ";
        inorderTraversal(tree->right);
    }
}
void insertBst(bst **tree,bst *node){
    bst *y=NULL;
    bst *x=*tree;
    while(x!=NULL){
        y=x;
        if(node->key<x->key){
            x=x->left;
        }
        else{
            x=x->right;
        }
    }
    node->p=y;
    if(y==NULL){
        *tree=node;
    }
    else{
        if(y->key>node->key){
            y->left=node;
        }
        else{
            y->right=node;
        }
    }
}
void buildBST(bst **tree,int number){
    for(int i=0;i<number;i++){
        bst *node=new bst;
        cout<<"Value "<<i+1<<":";
        cin>>node->key;
        insertBst(tree, node);
    }
}
bst* succesor(bst *node){
    if(node->right!=NULL){
        return min(node->right);
    }
    while(node->p!=NULL){
        bst *x=node->p;
        if(x->left==node){
            cout<<x->key<<endl;
            return node;
        }
        node=node->p;
    }
    node=NULL;
    return node;
}
bst* predecessor(bst *node){
    if(node->left!=NULL){
        return max(node->left);
    }
    while(node->p!=NULL){
        bst *x=node->p;
        if(x->right==node){
            cout<<x->key<<endl;
            return node;
        }
        node=node->p;
    }
    node=NULL;
    return node;
}
void search(bst *tree,int key){
    if(tree->key==key){
        cout<<"Found"<<endl;
    }
    else{
        if(tree->key>key){
            if(tree->left!=NULL){
                search(tree->left,key);
            }
            else{
                cout<<"Not found"<<endl;
            }
        }
        else{
            if(tree->right!=NULL){
                search(tree->right,key);
            }
            else{
                cout<<"Not found"<<endl;
            }
        }
    }
}
void deleteNode(bst *tree,bst *node){
    if(node->left==NULL && node->right==NULL){
        if(node->p->left==node){
            node->p->left=NULL;
        }
        else{
            node->p->right=NULL;
        }
        cout<<"pop1";
    }
    else if(node->left==NULL){
        if(node->p->left==node){
            node->p->left=node->right;
        }
        else{
            node->p->right=node->right;
        }

    }
    else if(node->right==NULL){
        if(node->p->left==node){
            node->p->left=node->left;
        }
        else{
            node->p->right=node->left;
        }
    }
    else{
        if(node->p->right==node){
            node->p->right=succesor(node);
        }
        else{
            node->p->left=succesor(node);
        }
        cout<<"pop4";
    }
}
int main(){
    bst *tree=NULL;
    // buildBST(&tree, 5);
    bst *array=new bst[5];
    array[0].key=10;
    array[1].key=9;
    array[2].key=8;
    array[3].key=7;
    array[4].key=6;
    for(int i=0;i<5;i++){
        insertBst(&tree, &array[i]);
    }
    inorderTraversal(tree);
    cout<<endl;
    max(tree);
    min(tree);
    succesor(&array[3]);
    predecessor(&array[3]);
    search(tree,10);
    deleteNode(tree, &array[1]);
    inorderTraversal(tree);
    return 0;
}
