#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class edge{
    public:
        int u;
        int v;
        int wt;
        edge(int u,int v,int weight){
            this->u=u;
            this->v=v;
            this->wt=weight;
        }
        edge(){
            u=0;
            v=0;
            wt=0;
        }
};
bool comp(edge a,edge b){
    return a.wt<b.wt;
}
int find_set(int u,vector<int> &parent){
    if(u==parent[u])
        return u;
    return find_set(parent[u],parent);
}
void link(int u,int v,vector<int> &parent,vector<int> &rank){
    if(rank[u]<rank[v]){
        parent[u]=v;
    }
    else{
        parent[v]=u;
        if(rank[u]==rank[v]){
            rank[u]++;
        }
    }
}
void unionn(int u,int v,vector<int> &parent,vector<int > &rank){
    link(find_set(u,parent),find_set(v,parent),parent,rank);
}
int main(){
    int noV,noE;
    cout<<"Enter no of vertex:";
    cin>>noV;
    cout<<"Enter no of edges:";
    cin>>noE;
    vector<edge> edges;
    for(int i=0;i<noE;i++){
        edge tempEdge;
        cout<<"Enter u,v,weight for edge (u,v):";
        cin>>tempEdge.u>>tempEdge.v>>tempEdge.wt;
        edges.push_back(tempEdge);
    }
    sort(edges.begin(),edges.end(),comp);
    vector<int> parent(noV);
    for(int i=0;i<noV;i++){
        parent[i]=i;
    }
    vector<int> rank(noV,0);
    vector<pair<int,int>> mst;
    for(edge tempEdge:edges){
        if(find_set(tempEdge.u, parent)!=find_set(tempEdge.v,parent)){
            mst.push_back({tempEdge.u,tempEdge.v});
            unionn(tempEdge.u,tempEdge.v,parent,rank);
        }
    }
    cout<<"MST"<<endl;
    for(pair<int,int> traversing:mst){
        cout<<"("<<traversing.first<<","<<traversing.second<<")";
    }
}