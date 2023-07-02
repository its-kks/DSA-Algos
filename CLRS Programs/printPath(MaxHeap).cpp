//printing the shortest path such that
//BFS has run on G with source as s
#include <cstddef>
#include <cstdio>
#include <iostream>
#include <queue>
#include <thread>
#include <vector>
#include<unistd.h>
using namespace std;
int negInf=-2147483648;
int posInf=2147483647;
class vertex{
    public:
        vector<int> linkings;
        string color;
        int d;
        vertex *pi;
};
using namespace std;
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
    return 0;
}