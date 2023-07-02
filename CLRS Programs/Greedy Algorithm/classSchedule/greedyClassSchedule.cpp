//Greedy algorithm: classroom scheduling
#include <iostream>
#include <vector>
using namespace std;
class classes{
    public:
        string subject;
        string startTime;
        string endTime;
};
void classInput(vector<classes> &classList){
    classes cTemp;
    cout<<"Enter subject name:";
    cin>>cTemp.subject;
    cout<<"Enter start time format(HH:MM am/pm):";
    cin>>cTemp.startTime;
    cout<<"Enter end time format(HH:MM am/pm):";
    cin>>cTemp.endTime;
    classList.push_back(cTemp);
}

bool compare(string c1,string c2){
    if(c1[c1.size()-2] > c2[c2.size()-2]){
        return true;
    }
    else if(c1[c1.size()-2] < c2[c2.size()-2]){
        return false;
    }
    else{
        int size=c1.compare(c2);
        if(size<0){
            return false;
        }
        else{
            return true;
        }

    }
}
int main(){
    vector<classes> classList;
    int flag=1;
    while(true){
        classInput(classList);
        cout<<"Enter more classes(0/1):";
        cin>>flag;
        if(flag==0){
            break;
        }
    }
    int tempSize=classList.size();
    int index;
    classes previous;
    previous.endTime="00:00am";
    vector<classes> ::iterator it;
    for(int i=0;i<tempSize;i++){
        classes smallest=classList[0];
        for(int j=0;j<classList.size();j++){
            if(compare(smallest.endTime, classList[j].endTime)){
                index=j;
                smallest=classList[j];
            }   
        }
        it=classList.begin();
        while(index!=0){
            it++;
            index--;
        }
        classList.erase(it);
        if(compare(smallest.startTime,previous.endTime)){
            previous=smallest;
            cout<<previous.subject<<" ";
        }
        else{
            continue;
        }
    }
    return 0;
}