#include <iostream>
#include <vector>
#include <map>
#include <list>
#include <set>
using namespace std;
int negInf=-2147483648;
int posInf=2147483647;
using namespace std;
template <class type>
class weightValue{
    public:
        type a;
        type b;//edge (a,b)
        int value;//weight for (a,b)
};
template <class Type>
class vertex{
    public:
        vector<Type> linkings;
        // string color;
        // int d;
        // vertex *pi;
};
template <class type>
void graphInput(vector<vertex<type>> &graph,int noVertex){
    type temp;
    int i,j;
    for(i=0;i<noVertex;i++){
        cout<<"Enter vertex value:";
        cin>>temp;
        vertex<type> v;
        v.linkings.push_back(temp);
        graph.push_back(v);
        int link=1;
        while(1){
            cout<<"Enter links(1/0):";
            cin>>link;
            if(link==0){
                break;
            }
            cout<<"Enter Link:";
            cin>>temp;
            graph[i].linkings.push_back(temp);
        }
        graph[i].linkings.push_back(negInf);
    }
}
//function to input data weight of each edge
template <class type>
void wGraph(vector<weightValue<type>*> &weightGraph,vector<vertex<type>> g){
    for(vertex<type> temp:g){
        for(int i=1;i<temp.linkings.size()-1;i++){
            weightValue<type> *vertexPairs=new weightValue<type>;
            vertexPairs->a=temp.linkings[0];
            vertexPairs->b=temp.linkings[i];
            cout<<"Enter weight for edge ("<<temp.linkings[0]<<","\
            <<temp.linkings[i]<<") :";
            cin>>vertexPairs->value;
            weightGraph.push_back(vertexPairs);
        }
    }
}
template <class type>
void graphPrinter(vector<vertex<type>> G){
    for(vertex<type> v:G){
        for(int i=0;i<v.linkings.size()-1;i++){
            cout<<v.linkings[i];
            if(i!=v.linkings.size()-1){
                cout<<"->";
            }
        }
        cout<<"NULL"<<endl;
    }
    cout<<endl;
}
template <class type>
void weightPrinter(vector<weightValue<type>*> weights){
    for(weightValue<type>* temp: weights){
        cout<<"("<<temp->a<<","<<temp->b<<")"<<":"<<temp->value<<endl;
    }
    cout<<endl;
}
template <class type>
class setObject{
    public:
        type value;
        setObject *next;
        setObject *rprsntv;
};
template <class type>
class headTail{
    public:
        setObject<type> *head;
        setObject<type> *tail;
};
template <class type>
class disjointSet{
    public:
        list<headTail<type>*> DS;
        //DS -> disjoint set
        void makeSet(type x){
            if(findSet(x)==NULL){
                // cout<<x<<" ";//
                headTail<type> *ht=new headTail<type>;
                ht->head=new setObject<type>;
                ht->head->value=x;
                ht->head->next=NULL;
                ht->head->rprsntv=ht->head;
                ht->tail=ht->head;
                DS.push_back(ht);
            }
        }
        setObject<type>* findSet(type x){
            for(headTail<type> *ht:DS){
                setObject<type>* representative=ht->head;
                setObject<type>* temp=representative;
                while(temp!=NULL){
                    if(temp->value==x){
                        return representative;
                    }
                    temp=temp->next;
                }
            }
            return NULL;
        }
        void unions(type x,type y){
            setObject<type>* s1=findSet(x);
            setObject<type>* s2=findSet(y);
            // if(s1==s2){
            //     return;
            // }
            headTail<type> *ht1;
            headTail<type> *ht2;
            for(headTail<type> *ht:DS){
                if(ht->head->value==s1->value){
                    ht1=ht;
                }
                if(ht->head->value==s2->value){
                    ht2=ht;
                }
            }
            ht1->tail->next=ht2->head;
            setObject<type> *temp=ht2->head;
            while(temp!=NULL){
                temp->rprsntv=ht1->head;
                temp=temp->next;
            }
            ht1->tail=ht2->tail;
            DS.remove(ht2);
        }
        void printDS(){
            for(headTail<type> *h1:DS){
                setObject<type> *temp=h1->head;
                while(temp!=NULL){
                    cout<<temp->value<<" ";
                    temp=temp->next;
                }
                cout<<endl;
            }
        }
};  
template <class type>
void mstKruskal(vector<vertex<type>> graph,vector<weightValue<type>*> &weights,
                vector<vertex<type>> &edgesVertex){
    disjointSet<type> DS;
    for(int i=0;i<graph.size();i++){
        DS.makeSet(graph[i].linkings[0]);
    }
    //sorting edges by weight
    {
        int i=1,j;
        for(;i<weights.size();i++){
            j=i-1;
            weightValue<type> *temp=weights[i];
            while(j>=0 && weights[j]->value>temp->value){
                weights[j+1]=weights[j];
                j--;
            }
            weights[j+1]=temp;
        }
    }
    for(int i=0;i<weights.size();i++){
        if(DS.findSet(weights[i]->a)!=DS.findSet(weights[i]->b)){
            //inserting and edge into MST
            {
                vertex<type> tempVertexMST;
                tempVertexMST.linkings.push_back(weights[i]->a);
                tempVertexMST.linkings.push_back(weights[i]->b);
                tempVertexMST.linkings.push_back(negInf);
                edgesVertex.push_back(tempVertexMST);
            }
            DS.unions(DS.findSet(weights[i]->a)->value\
            , DS.findSet(weights[i]->b)->value);
        }
    }

}
int main(){
    vector<vertex<char>> g1;
    int countVertex;
    cout<<"Enter number of vertex:";
    cin>>countVertex;
    graphInput(g1, countVertex);
    vector<weightValue<char>*> weights;
    wGraph(weights, g1);
    // graphPrinter(g1);
    // weightPrinter(weights);
    vector<vertex<char>> mst;
    mstKruskal(g1, weights, mst);
    graphPrinter(mst);
    return 0;
}
/*
The output of the MST comes as an adjacency list
like:
a->b->null
b->a->null
it represents the graph:
a-b
*/