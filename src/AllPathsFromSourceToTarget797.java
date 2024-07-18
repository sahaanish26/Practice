import java.util.*;

public class AllPathsFromSourceToTarget797 {

//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        /*int[] intArray1 = new int[]{ 4,3,1};
        int[] intArray2 = new int[]{ 3,2,4};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ 4};
        int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4, intArray5 };
*/

        int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };




        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ allPathsSourceTarget(graphArrays) );

    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> chosenPath = new ArrayList<>();
        Map<Integer, List<Integer>> mapGraph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i=0; i<graph.length; i++) {
                int[] nodes =graph[i];
                List<Integer> listNodes = new ArrayList<>();
            for (int j=0; j<nodes.length; j++) {
                listNodes.add(nodes[j]);
            }
            mapGraph.put(i, listNodes);
        }
        System.out.println(mapGraph);
        dfsHelper(0,mapGraph.size()-1,chosenPath,allPaths,mapGraph,visited);
        System.out.println(allPaths);
        return allPaths;
    }

    private static void dfsHelper(int start, int target, List<Integer> chosenPath, List<List<Integer>> allPaths, Map<Integer, List<Integer>> mapGraph, Set<Integer> visited) {
       System.out.println("start"+start+" target"+target+"chosenPath"+chosenPath+"visited"+visited);
        visited.add(start);
        chosenPath.add(start);
        if(start == target) {
            System.out.println("chosenPath"+chosenPath);
            allPaths.add(new ArrayList<>(chosenPath));
        }
         else {
            // List<Integer> neighbourNodes = mapGraph.get(start);
            for (Integer neighbourNode : mapGraph.get(start)) {
                //since the graph is acyclic and directed we can ignore the if not visited condition
                //to get all paths. for a single path this condition can stay.
              //  if (!visited.contains(neighbourNode)) {
                    dfsHelper(neighbourNode, target, chosenPath, allPaths, mapGraph, visited);
               // }
            }
        }
        chosenPath.remove(chosenPath.size()-1);
    }
}
