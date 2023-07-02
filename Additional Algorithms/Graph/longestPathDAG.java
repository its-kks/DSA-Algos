package Graph;

import java.util.*;

class Edge {
    int ch;
    int wt;

    Edge(int ch, int wt) {
        this.ch = ch;
        this.wt = wt;
    }
}

public class longestPathDAG {
    public static  void arrayPrint(int array[]){
        for(int item:array){
            System.out.print(item+" ");
        }
        System.out.println("");
    }
    public static void longPathBFS(int ver,ArrayList<ArrayList<Edge>> adj,int indegree[],int distance[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(ver);
        while(q.size()!=0){
            int temp=q.poll();
            for(Edge child:adj.get(temp)){
                indegree[child.ch]--;
                if(indegree[child.ch]==0){
                    q.add(child.ch);
                    if(distance[child.ch]<distance[temp]+child.wt){
                        distance[child.ch]=distance[temp]+child.wt;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        // Driver code
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Edge(1, 5));
        adj.get(0).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 6));
        adj.get(1).add(new Edge(2, 2));
        adj.get(2).add(new Edge(4, 4));
        adj.get(2).add(new Edge(5, 2));
        adj.get(2).add(new Edge(3, 7));
        adj.get(3).add(new Edge(5, 1));
        adj.get(3).add(new Edge(4, -1));
        adj.get(4).add(new Edge(5, -2));
        //assign indegree
        int indegree[]=new int[V];
        for(int i=0;i<adj.size();i++){
            for(Edge temp:adj.get(i)){
                indegree[temp.ch]++;
            }
        }
        //assing distance from source
        int distance[]=new int[V];
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                longPathBFS(i,adj,indegree,distance);
                break;
            }
        }
        //print ans
        arrayPrint(distance);
    }
}
