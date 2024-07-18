package generic;

import java.util.*;

public class Dijikstra {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
       /* int[] intArray1 = new int[]{ 0,1,100};
        int[] intArray2 = new int[]{ 1,2,100};
        int[] intArray3 = new int[]{ 2,0,100};
        int[] intArray4 = new int[]{ 1,3,600};
        int[] intArray5 = new int[]{2,3,200 };
        int[][] flightArrays = { intArray1, intArray2, intArray3, intArray4, intArray5 };
        System.out.println("Final result" + findCheapestPrice(4,flightArrays,0,3,1) );
*/

        /*int[] intArray1 = new int[]{ 0,1,100};
        int[] intArray2 = new int[]{ 1,2,100};
        int[] intArray3 = new int[]{ 0,2,500};
       // int[] intArray4 = new int[]{ 1,3,600};
       // int[] intArray5 = new int[]{2,3,200 };
        int[][] flightArrays = { intArray1, intArray2, intArray3};
        System.out.println("Final result" + findCheapestPrice(3,flightArrays,0,2,1) );
*/

        /* int[] intArray1 = new int[]{ 0,1,100};
        int[] intArray2 = new int[]{ 1,2,100};
        int[] intArray3 = new int[]{ 2,0,100};
        int[] intArray4 = new int[]{ 1,3,600};
        int[] intArray5 = new int[]{2,3,200 };
        int[][] flightArrays = { intArray1, intArray2, intArray3, intArray4, intArray5 };
        System.out.println("Final result" + findCheapestPrice(4,flightArrays,0,3,1) );
*/

        int[] intArray1 = new int[]{ 0,1,1};
        int[] intArray2 = new int[]{ 0,2,5};
        int[] intArray3 = new int[]{ 1,2,1};
        int[] intArray4 = new int[]{ 2,3,1};
        int[][] flightArrays = { intArray1, intArray2, intArray3, intArray4 };
        System.out.println("Final result" + findCheapestPrice(4,flightArrays,0,3,1) );






    }


    public static  int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer,List<List<Integer>>> mapGraph  = new HashMap();
        Set<Integer> visited= new HashSet<>();
        Map<Integer,Integer> distancetoThisNode = new HashMap();
        PriorityQueue<List<Integer>> nodePriorityQueue = new PriorityQueue<>(new ListComparator());
        //populate distancetoThisNode with infinite max for all nodes.
        for(int i=0;i<n;i++){
            distancetoThisNode.put(i,Integer.MAX_VALUE);
            List<List<Integer>> oneNeighbournodeList = new ArrayList();
            mapGraph.put(i,oneNeighbournodeList);
        }
        for(int i=0;i<flights.length;i++){
            int[] flightArray = flights[i];
            List<Integer> oneNeighbournode = new ArrayList<>();
            oneNeighbournode.add(flightArray[1]);
            oneNeighbournode.add(flightArray[2]);
            if(mapGraph.get(flightArray[0])!=null){
                List<List<Integer>> oneNeighbournodeList = mapGraph.get(flightArray[0]);
                oneNeighbournodeList.add(oneNeighbournode);
            }

        }
        System.out.println("mapGraph"+mapGraph);
        System.out.println("distancetoThisNode"+distancetoThisNode);
        findCheapestPriceHelper( src,mapGraph,distancetoThisNode,nodePriorityQueue,visited,dst,k);
        System.out.println("distancetoThisNode after"+distancetoThisNode);
        int shortestDistance = distancetoThisNode.get(dst);
        if(shortestDistance<Integer.MAX_VALUE){
            return shortestDistance;
        }

        return -1;
    }

    private static void findCheapestPriceHelper(int src, Map<Integer, List<List<Integer>>> mapGraph, Map<Integer, Integer> distancetoThisNode, PriorityQueue<List<Integer>> nodePriorityQueue, Set<Integer> visited,int dst,int k) {
        Set<Integer> queuedSet = new HashSet();
        List<Integer> startNode = new ArrayList();
        startNode.add(src);
        startNode.add(0);

        nodePriorityQueue.add(startNode);
        queuedSet.add(startNode.get(0));
        distancetoThisNode.put(src,0);
        int iteration=-1;

        while(!nodePriorityQueue.isEmpty() ){
            List<Integer> currentNode = nodePriorityQueue.poll();
            System.out.println("current node"+currentNode);
            visited.add(currentNode.get(0));
            List<List<Integer>> neighbors = mapGraph.get(currentNode.get(0));
            for(List<Integer> neighbor : neighbors){
                if(!visited.contains(neighbor.get(0))){
                    int existingShortestDistance = distancetoThisNode.get(neighbor.get(0));
                    int distanceToNeighborNode = neighbor.get(1) + distancetoThisNode.get(currentNode.get(0))  ;
                    if(distanceToNeighborNode<existingShortestDistance){
                        // put in PQ since new short distance found
                        // before putting check for duplicate
                    /*if(queuedSet.contains(neighbor.get(0))){
                        System.out.println("if found");
                        nodePriorityQueue.remove(neighbor);
                    }*/
                        nodePriorityQueue.add(neighbor);
                        //update the new short distance
                        distancetoThisNode.put(neighbor.get(0),distanceToNeighborNode);
                    }
                }
            }
            iteration++;
            System.out.println("after iteration  "+iteration+ "   distancetoThisNode   "+distancetoThisNode);
            System.out.println("nodePriorityQueue"+nodePriorityQueue);


        }



    }

}

class ListComparator implements Comparator<List<Integer>>  {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(List<Integer> l1, List<Integer> l2) {
        if (l1.get(1) > l2.get(1))
            return 1;
        else if (l1.get(1) < l2.get(1))
            return -1;
        return 0;
    }



}

