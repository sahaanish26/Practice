package generic;

import java.util.*;

public class graphTopoSort {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 4,3,1};
        int[] intArray2 = new int[]{ 3,2,4};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ 4};
        int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4, intArray5 };

      /*  int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };
*/



        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);

        topologicalSort(graphArrays);
        System.out.println("Final result" );

    }



    private static void topologicalSort(int[][] graph) {

        Map<Integer, List<Integer>> mapGraph = new HashMap<>();

        for (int i=0; i<graph.length; i++) {
            int[] nodes =graph[i];
            List<Integer> listNodes = new ArrayList<>();
            for (int j=0; j<nodes.length; j++) {
                listNodes.add(nodes[j]);
            }
            mapGraph.put(i, listNodes);
        }
        System.out.println(mapGraph);
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> nodestack = new Stack<>();
        for (int i=0; i<mapGraph.size(); i++) {
            if(!visited.contains(i)) {
                     topologicalSortHelper(i,nodestack,visited,mapGraph);
            }

            //int node = mapGraph.ge
        }
       System.out.println(nodestack);
        while (!nodestack.isEmpty()) {
            int node = nodestack.pop();
            System.out.println(node);
        }
    }

    private static void topologicalSortHelper(int currentNode,Stack<Integer> nodestack, Set<Integer> visited, Map<Integer, List<Integer>> mapGraph) {

        visited.add(currentNode);
        List<Integer> neighbourNodes = mapGraph.get(currentNode);
        for (int i=0; i<neighbourNodes.size(); i++) {

            if (!visited.contains(neighbourNodes.get(i))) {
                topologicalSortHelper(neighbourNodes.get(i),nodestack,visited,mapGraph);
            }
        }
        //post order traversal so adding node at the end.
        nodestack.push(currentNode);
    }
}
