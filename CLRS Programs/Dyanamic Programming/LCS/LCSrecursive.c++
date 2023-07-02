#include <iostream>
using namespace std;
int LCS(string x,string y,int sx,int sy){
    if(sx==0 || sy==0){
        return 0;
    }
    else{
        if(x[sx-1]==y[sy-1]){
            return 1+LCS(x,y,sx-1,sy-1);
        }
        else{
            return max(LCS(x,y,sx-1,sy),LCS(x,y,sx,sy-1));
        }
    }
}
int main()
{
    string S1;
    int s1;
    string S2;
    int s2;
    cin>>S1>>s1;
    cin>>S2>>s2;
    cout<<LCS(S1,S2,s1,s2);
    return 0;
}
