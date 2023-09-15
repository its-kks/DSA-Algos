#include <iostream>
#include <vector> 
#include <cmath>
using namespace std;
//we maintain the size of the segment tree array as power of two
int left(int i, int n){
    return 
}
int right(){

}
int main(){
    vector<int> temp;
    int size = ceil(log2(temp.size()));
    while(temp.size()!=0) temp.push_back(0);
    vector<int> segArr(2*size-1);
    for(int i=0;i<temp.size();i++){
        segArr[i+size-1] = temp[i];
    }
    return 0;
}
