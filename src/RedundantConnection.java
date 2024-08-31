import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class RedundantConnection {

    public static void main(String[] args){

        int[][] edges = {{1,4},{3,4},{1,3},{1,2},{4,5}};
       
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public  static int[] findRedundantConnection(int[][] edges) {
       
        UnionFind unionFind = new UnionFind(edges.length);
        int[] res = new int[2];

        for (int i=0;i<edges.length;i++){
           int[] edge = edges[i];
           int firstNode=edge[0];
           int secondNode =edge[1];
           if(!unionFind.union(firstNode,secondNode)){
            res=edge;
           // return edge;

           }


        }
        return res ;
    }
    
}

class UnionFind {

    public Map<Integer,Integer> childToParentMap ;
    public Map<Integer,Integer> numberOfNodesMap ;
    
    public UnionFind(int numberOfEdges){
        childToParentMap = new HashMap<>();
        numberOfNodesMap = new HashMap<>();
        for (int i=1;i<=numberOfEdges;i++){
            // parent of all nodes are -1 i.e self
            childToParentMap.put(i,-1);
            // count has own count i. e 1 at the start
            numberOfNodesMap.put(i,1);


        }

    }

    public int find (int node){

        if (childToParentMap.get(node)==-1){
           return  node;
        }
        return find(childToParentMap.get(node));
    }

    public boolean union (int firstNode , int secondNode){
        int parentOfFirstNode = find(firstNode);
        int parentOfSecondNode = find(secondNode);
        if (parentOfFirstNode==parentOfSecondNode){

            return false;
        }
        if( numberOfNodesMap.get(parentOfFirstNode)>= numberOfNodesMap.get(secondNode)){
            childToParentMap.put(secondNode,parentOfFirstNode);
            numberOfNodesMap.put(parentOfFirstNode,numberOfNodesMap.get(parentOfFirstNode)+1);
            numberOfNodesMap.put(parentOfSecondNode,numberOfNodesMap.get(parentOfSecondNode)-1);
            
        }
        else{
            childToParentMap.put(firstNode,parentOfSecondNode);
            numberOfNodesMap.put(parentOfSecondNode,numberOfNodesMap.get(parentOfSecondNode)+1);
            numberOfNodesMap.put(parentOfFirstNode,numberOfNodesMap.get(parentOfFirstNode)-1);
            

        };
        
        return true;
    }

   
}
