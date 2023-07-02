//DFS
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
int tempGraphMaker(vector<vertex> &G){
    vertex temp1,temp2,temp3,temp4,temp5,temp6;
    temp1.linkings={0,1,2,negInf};
    temp2.linkings={1,3,negInf};
    temp3.linkings={2,1,negInf};
    temp4.linkings={3,2,negInf};
    temp5.linkings={4,3,5,negInf};
    temp6.linkings={5,5,negInf};
    G.push_back(temp1);
    G.push_back(temp2);
    G.push_back(temp3);
    G.push_back(temp4);
    G.push_back(temp5);
    G.push_back(temp6);
    return 6;
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
void dfsVisit(vector<vertex> &G,int v){
    G[v].color="gray";
    times=times+1;
    G[v].d=times;
    cout<<"("<<v<<" ";//Extra to print vertex being explored

    for(int i=1;i<G[v].linkings.size()-1;i++){
        int index=G[v].linkings[i];
        if(G[index].color=="white"){
            G[index].pi=&G[v];
            dfsVisit(G, index);
        }
    }
    G[v].color="black";
    cout<<" "<<v<<")";//Extra to print vertex being explored
    times++;
    G[v].f=times;
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
void timeStamps(vector<vertex> graph,int nV){
    for(int i=0;i<nV;i++){
        cout<<i<<":"<<graph[i].d<<"/"<<graph[i].f<<endl;
    }
}
int main(){
    vector<vertex> graph;
    int nV=tempGraphMaker(graph);
    graphPrinter(graph, nV);
    dfs(graph,nV);
    cout<<endl;
    timeStamps(graph, nV);
    return 0;
}