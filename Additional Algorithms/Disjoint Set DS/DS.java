
import java.util.*;

class DisjointSet{
    //here setParent does not store the immediate parent rather parent of the set
    int setPar[];
    //we maintain rank of each element
    int setRank[];
    DisjointSet(int n){
        setPar=new int[n];
        setRank=new int[n];
        Arrays.fill(setRank,0);
        for(int i=0;i<n;i++){
            setPar[i]=i;
        }
    }
    //union by rank
    public void union(int v1,int v2){
        //union is done based on rank of parent
        v1=findParent(v1);
        v2=findParent(v2);
        int rank1=setRank[v1];
        int rank2=setRank[v2];
        //the one having higher rank is made parent
        //if rank is equal any one is made parent
        //the one who is made parent its rank is increased by 1

        //REASON: The node having higher value rank will more height of tree
        //so if it is made a child rather parent the height will increase further
        //reduing the searching time
        if(rank1>=rank2){
            setPar[v2]=v1;
            setRank[v1]++;
        }
        else{
            setPar[v1]=v2;
            setRank[v2]++;
        }
    }
    //find parent and path compression
    //we are finding parent of val
    public int findParent(int val){
        if(setPar[val]==val){
            return val;
        }
        //path compression is executed
        return setPar[val]=findParent(setPar[val]);
    }
}
class DS {
    public static void main(String[] args){
        DisjointSet d1=new DisjointSet(5);
        d1.union(1,3);
        System.out.println(d1.findParent(3));
    }
}
