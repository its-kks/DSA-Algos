//Topological sort:
//For a DAG directed acyclic graph
//Acyclic:each edge directed from one vertex to another, 
//such that following those directions will never form a closed loop.
#include <cstddef>
#include <iostream>
#include <vector>
using namespace std;
int negInf=-2147483648;
int posInf=2147483647;
int times=0;
class vertex{
    public:
        vector<int> linkings;
        string color;
        int d;
        int f;
        vertex *pi;
};
class node{
    public:
    int data;
    node *link;
};
node *head=NULL;
void insertFront(node *temp){
    if(head==NULL){
        head=temp;
    }
    else{
        temp->link=head;
        head=temp;
    }
    cout<<head->data<<endl;
}
void printLL(){
    node *point=head;
    if(head==NULL){
        cout<<"Empty!";
        return;
    }
    while(point!=NULL){
        cout<<point->data<<" ";
        point=point->link;
    }
}
int tempGraphMaker(vector<vertex> &G){
    vertex temp1,temp2,temp3,temp4,temp5,temp6;
    temp1.linkings={0,1,2,negInf};
    temp2.linkings={1,3,4,negInf};
    temp3.linkings={2,5,3,negInf};
    temp4.linkings={3,4,5,negInf};
    temp5.linkings={4,negInf};
    temp6.linkings={5,negInf};
    G.push_back(temp1);
    G.push_back(temp2);
    G.push_back(temp3);
    G.push_back(temp4);
    G.push_back(temp5);
    G.push_back(temp6);
    return 6;
}
void dfsVisit(vector<vertex> &G,int v){
    G[v].color="gray";
    times=times+1;
    G[v].d=times;
    for(int i=1;i<G[v].linkings.size()-1;i++){
        int index=G[v].linkings[i];
        if(G[index].color=="white"){
            G[index].pi=&G[v];
            dfsVisit(G, index);
        }
    }
    G[v].color="black";
    times++;
    G[v].f=times;
    node *temp=new node;
    temp->data=v;
    temp->link=NULL;
    insertFront(temp);
}
void dfs(vector<vertex> &G,int nV){
    for(int i=0;i<nV;i++){
        G[i].color="white";
        G[i].pi=NULL;
    }
    times=0;
    for(int i=0;i<nV;i++){
        if(G[i].color=="white"){
            dfsVisit(G,i);
            cout<<endl;
        }
    }
}
int main(){
    vector<vertex> graph;
    int nV=tempGraphMaker(graph);
    dfs(graph,nV);
    cout<<"Topological sort:";
    printLL();
    cout<<endl<<endl;
    return 0;
}