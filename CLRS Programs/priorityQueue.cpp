//week 5 q1
#include <cmath>
#include <cstdio>
#include <iostream>
#include <iterator>
#include <stdexcept>
#include <type_traits>
using namespace std;
class maxPriorityQueue{
    public:
        int length;
        int size;
        int *array;
        maxPriorityQueue(int size){
            array=new int[size];
            length=size;
            this->size=size;
            for(int i=0;i<size;i++){
                scanf("%d",&array[i]);
            }
        }
        void printArrary(){
            for(int i=0;i<size;i++){
                printf("%d ",array[i]);
            }
            printf("\n");
        }
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    void swap(int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
    void increaseSize(){
        int *temp=new int[++length];
        size++;
        for(int i=0;i<length-1;i++){
            temp[i]=array[i];
        }
        array=temp;
        temp=NULL;
    }
};
typedef class maxPriorityQueue mpq;
void maxHeapify(mpq &queue,int i){
    int largest;
    int left=queue.left(i);
    int right=queue.right(i);
    if(left<queue.size && queue.array[i]<queue.array[left]){
        largest=left;
    }
    else{
        largest =i;
    }
    if(right<queue.size && queue.array[largest]<queue.array[right]){
        largest=right;
    }
    if(i!=largest){
        queue.swap(i,largest);
        maxHeapify(queue, largest);
    }
}
void buildMaxHeap(mpq &queue){
    for(int i=queue.length/2;i>=0;i--){
        maxHeapify(queue, i);
    }
}
int max(mpq &queue){
    return queue.array[0];
}
int extractMax(mpq &queue){
    int temp=queue.array[0];
    queue.array[0]=queue.array[queue.size-1];
    queue.size--;
    maxHeapify(queue, 0);
    return temp;
}
void increaseKey(mpq &queue,int key,int i){
    if(key<queue.array[i]){
        printf("Key is smaller\n");
    }
    else{
        while(i!=0 && queue.array[queue.parent(i)]<key){
            queue.array[i]=queue.array[queue.parent(i)];
            i=queue.parent(i);
        }
        queue.array[i]=key;
    }
}
void insertKey(mpq &queue,int value){
    queue.increaseSize();
    queue.array[queue.size-1]=-2147483648;
    increaseKey(queue, value, queue.size-1);
}
void deleteKey(mpq &queue,int i){
    if(queue.array[i]<queue.array[queue.size-1]){
        increaseKey(queue, queue.array[queue.size-1], i);
        queue.size--;
    }
    else{
        queue.array[i]=queue.array[queue.size-1];
        queue.size--;
        maxHeapify(queue, i);
    }
}
int main(){
    maxPriorityQueue Q1(7);
    Q1.printArrary();
    buildMaxHeap(Q1);
    Q1.printArrary();
    cout<<extractMax(Q1)<<endl;
    Q1.printArrary();
    insertKey(Q1, 12);
    Q1.printArrary();
    deleteKey(Q1, 2);
    Q1.printArrary();
    return 0;
}