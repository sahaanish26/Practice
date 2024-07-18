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
        topologicalSortKahns(graphArrays);
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
       System.out.println("topologicalSort"+nodestack);
        while (!nodestack.isEmpty()) {
            int node = nodestack.pop();
            System.out.println("topologicalSort"+node);
        }
    }

    private static void topologicalSortKahns(int[][] graph) {

        Map<Integer, List<Integer>> mapGraph = new HashMap<>();
        Map<Integer, Integer> inDegreeGraph = new HashMap<>();

        for (int i=0; i<graph.length; i++) {
            int[] nodes =graph[i];
            List<Integer> listNodes = new ArrayList<>();
            for (int j=0; j<nodes.length; j++) {
                listNodes.add(nodes[j]);
            }
            mapGraph.put(i, listNodes);
            inDegreeGraph.put(i,0);
        }
        System.out.println(mapGraph);
        System.out.println("initial inDegreeGraph"+inDegreeGraph);
        Queue<Integer> zeroIndegreeQueue = new LinkedList<>();
        List<Integer> sortedCourse = new ArrayList<>();

        for (int i =0;i<mapGraph.size();i++){
       List<Integer> neighbourNodes= mapGraph.get(i);
       for (int j=0;j<neighbourNodes.size();j++){
       if(inDegreeGraph.containsKey(neighbourNodes.get(j))){
           int prevIndegreeCount = inDegreeGraph.get(neighbourNodes.get(j));
           inDegreeGraph.put(neighbourNodes.get(j),prevIndegreeCount+1);
       }
       }
        }
        System.out.println("final inDegreeGraph"+inDegreeGraph);

        inDegreeGraph.forEach((key, value) -> {
                 if(value==0){
                    zeroIndegreeQueue.add(key);
                }
            });
        System.out.println("final zeroIndegreeQueue"+zeroIndegreeQueue);


        topologicalSortKhansHelper(zeroIndegreeQueue,sortedCourse,inDegreeGraph,mapGraph);
        System.out.println("final sortedCourse"+sortedCourse);

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

    private static void topologicalSortKhansHelper(Queue<Integer> zeroIndegreeQueue, List<Integer> sortedCourse, Map<Integer, Integer> inDegreeGraph, Map<Integer, List<Integer>> mapGraph) {

   while (!zeroIndegreeQueue.isEmpty()) {
       int currentNode = zeroIndegreeQueue.poll();
       sortedCourse.add(currentNode);
       List<Integer> neighbourNodes = mapGraph.get(currentNode);

       for (int neighbour : neighbourNodes) {
         int newIndegreeCount = inDegreeGraph.get(neighbour)-1;
         if (newIndegreeCount == 0) {
             zeroIndegreeQueue.add(neighbour);
         }
         inDegreeGraph.put(neighbour,newIndegreeCount);
       }
   }

    }



}
