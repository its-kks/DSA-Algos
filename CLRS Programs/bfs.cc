//bfs
#include <cstddef>
#include <cstdio>
#include <iostream>
#include <queue>
#include <thread>
#include <vector>
#include<unistd.h>
int negInf=-2147483648;
int posInf=2147483647;
using namespace std;
class vertex{
    public:
        vector<int> linkings;
        string color;
        int d;
        vertex *pi;
};
// void graphInput(vector<vertex> graph,int noVertex){
//     int temp;
//     int i,j;
//     for(i=0;i<noVertex;i++){
//         cout<<"Enter vertex value:";
//         cin>>temp;
//         vertex v;
//         v.linkings.push_back(temp);
//         graph.push_back(v);
//         int link=1;
//         while(link!=0){
//             cout<<"Enter Link:";
//             cin>>temp;
//             graph[i].linkings.push_back(temp);
//             cout<<"Enter more links(1/0):";
//             cin>>link;
//         }
//         graph[i].linkings.push_back(negInf);
//     }
// }
int tempGraphMaker(vector<vertex> &G){
    vertex temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8;
    temp1.linkings={0,1,3,negInf};
    temp2.linkings={1,0,2,negInf};
    temp3.linkings={2,1,negInf};
    temp4.linkings={3,5,4,0,negInf};
    temp5.linkings={4,5,3,6,7,negInf};
    temp6.linkings={5,6,4,3,negInf};
    temp7.linkings={6,7,4,5,negInf};
    temp8.linkings={7,6,4,negInf};
    G.push_back(temp1);
    G.push_back(temp2);
    G.push_back(temp3);
    G.push_back(temp4);
    G.push_back(temp5);
    G.push_back(temp6);
    G.push_back(temp7);
    G.push_back(temp8);
    return 8;
}
void graphPrinter(vector<vertex> G,int nV){
    for(int i=0;i<nV;i++){
        for(int i:G[i].linkings){
            if(i!=negInf){
                cout<<i;
            }
            else{
                cout<<"Null";
            }
            if(i!=negInf){
                cout<<"->";
            }
        }
        cout<<endl;
    }
    cout<<endl;
}
void BFS(vector<vertex> &G,int num){
    for(int i=1;i<num;i++){
        G[i].color="white";
        G[i].pi=NULL;
        G[i].d=posInf;
    }
    G[0].color="gray";
    G[0].d=0;
    G[0].pi=NULL;
    queue<vertex*> q;
    q.push(&G[0]);
    while(q.size()!=0){
        vertex *u=q.front();
        q.pop();
        for(int i=1;i<u->linkings.size()-1;i++){
            vertex *v=&G[u->linkings[i]];
            if(v->color=="white"){
                v->color="gray";
                v->d=u->d+1;
                v->pi=u;
                q.push(v);
            }
        }
        u->color="black";
        cout<<u->linkings[0]<<" ";
    }
}
void printPath(vector<vertex> G,int v){
    if(v==0){
        cout<<0<<" ";
    }
    else if(G[v].pi==NULL){
        cout<<"No path Exist from G[0] to G["<<v<<"]"<<" exists.";
    }
    else{
        printPath(G, G[v].pi->linkings[0]);
        cout<<G[v].linkings[0]<<" ";
    }
}
int main(){
    // int num;
    // cout<<"Enter no of vertex:";
    // cin>>num;
    vector<vertex> Graph;
    int nV;
    nV=tempGraphMaker(Graph);
    // graphInput(Graph, num);
    graphPrinter(Graph,nV);
    BFS(Graph, nV);
    cout<<endl;
    printPath(Graph,7);
    return 0;
}