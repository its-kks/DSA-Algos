#include <iostream>
#include <list>
using namespace std;
class setObject{
    public:
        int value;
        setObject *next;
        setObject *rprsntv;
};
class headTail{
    public:
        setObject *head;
        setObject *tail;
};
class disjointSet{
    public:
        list<headTail*> DS;
        void makeSet(int x){
            if(findSet(x)==NULL){
                // cout<<x<<" ";//
                headTail *ht=new headTail;
                ht->head=new setObject;
                ht->head->value=x;
                ht->head->next=NULL;
                ht->head->rprsntv=ht->head;
                ht->tail=ht->head;
                DS.push_back(ht);
            }
        }
        setObject* findSet(int x){
            for(headTail *ht:DS){
                // cout<<ht->head->value<<" "<<endl;//
                setObject* representative=ht->head;
                setObject* temp=representative;
                while(temp!=NULL){
                    if(temp->value==x){
                        return representative;
                    }
                    temp=temp->next;
                }
            }
            return NULL;
        }
        void unions(int x,int y){
            setObject* s1=findSet(x);
            setObject* s2=findSet(y);
            headTail *ht1;
            headTail *ht2;
            for(headTail *ht:DS){
                if(ht->head->value==s1->value){
                    ht1=ht;
                }
                if(ht->head->value==s2->value){
                    ht2=ht;
                }
            }
            ht1->tail->next=ht2->head;
            setObject *temp=ht2->head;
            while(temp!=NULL){
                temp->rprsntv=ht1->head;
                temp=temp->next;
            }
            ht1->tail=ht2->tail;
            DS.remove(ht2);
        }
        void printDS(){
            for(headTail *h1:DS){
                setObject *temp=h1->head;
                while(temp!=NULL){
                    cout<<temp->value<<" ";
                    temp=temp->next;
                }
                cout<<endl;
            }
        }
};  
int main(){
    disjointSet DS1;
    DS1.makeSet(5);
    DS1.makeSet(6); 
    DS1.makeSet(8); 
    DS1.makeSet(5);   
    DS1.makeSet(8); 
    DS1.unions(DS1.findSet(5)->value,DS1.findSet(6)->value);
    DS1.printDS();                          
    return 0;
}