import java.util.*;

public class NetworkDelayTime743 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

     //https://www.youtube.com/watch?v=NHLValhbnVE
  /*      int[] intArray1 = new int[]{ 2,1,1};
        int[] intArray2 = new int[]{ 2,3,1};
        int[] intArray3 = new int[]{ 3,4,1};
        // int[] intArray4 = new int[]{ 2,3,1};
        int[][] flightArrays = { intArray1, intArray2, intArray3 };
        System.out.println("Final result" + findCheapestPrice(4,flightArrays,2) );

*/

        int[] intArray1 = new int[]{ 2,4,10};
        int[] intArray2 = new int[]{ 5,2,38};
        int[] intArray3 = new int[]{ 3,4,33};
        int[] intArray4 = new int[]{ 4,2,76};

        int[] intArray5 = new int[]{ 3,2,64};
        int[] intArray6 = new int[]{ 1,5,54};
        int[] intArray7 = new int[]{ 1,4,98};

        int[] intArray8 = new int[]{ 2,3,61};
        int[] intArray9 = new int[]{ 2,1,0};
        int[] intArray10 = new int[]{ 3,5,77};
        int[] intArray11 = new int[]{ 5,1,34};
        int[] intArray12 = new int[]{ 3,1,79};
        int[] intArray13 = new int[]{ 5,3,2};
        int[] intArray14 = new int[]{ 1,2,59};
        int[] intArray15 = new int[]{ 4,3,46};
        int[] intArray16 = new int[]{ 5,4,44};
        int[] intArray17 = new int[]{ 2,5,89};
        int[] intArray18 = new int[]{ 4,5,21};
        int[] intArray19 = new int[]{ 1,3,86};
        int[] intArray20 = new int[]{ 4,1,95};



        // int[] intArray4 = new int[]{ 2,3,1};
        int[][] flightArrays = { intArray1, intArray2, intArray3,intArray4, intArray5, intArray6,intArray7, intArray8, intArray9,intArray10, intArray11, intArray12,intArray13, intArray14, intArray15,intArray16, intArray17,intArray18, intArray19, intArray20 };
        System.out.println("Final result" + networkDelayTime(flightArrays,5,1) );






    }


    public static  int networkDelayTime( int[][] times, int n,int k) {

        Map<Integer,List<List<Integer>>> mapGraph  = new HashMap();
        Set<Integer> visited= new HashSet<>();
        Map<Integer,Integer> distancetoThisNode = new HashMap();
        PriorityQueue<List<Integer>> nodePriorityQueue = new PriorityQueue<>(new ListComparator());
        //populate distancetoThisNode with infinite max for all nodes.
        for(int i=1;i<=n;i++){
            distancetoThisNode.put(i,Integer.MAX_VALUE);
            List<List<Integer>> oneNeighbournodeList = new ArrayList();
            mapGraph.put(i,oneNeighbournodeList);
        }
        for(int i=0;i<times.length;i++){
            int[] flightArray = times[i];
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
        networkDelayTimeHelper( k,mapGraph,distancetoThisNode,nodePriorityQueue,visited);
      //  System.out.println("distancetoThisNode after"+distancetoThisNode);
       PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        distancetoThisNode.forEach((key, value) -> {
            if(key!=k){
                maxQueue.add(value);
            }
        });
      //iterate over map and put the min distance [Ignore the src node]
        int max = maxQueue.poll();
        if(max==Integer.MAX_VALUE){
            return -1;

        }
        return max;

    }

    private static void networkDelayTimeHelper(int src, Map<Integer, List<List<Integer>>> mapGraph, Map<Integer, Integer> distancetoThisNode, PriorityQueue<List<Integer>> nodePriorityQueue, Set<Integer> visited) {
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
            System.out.println("neighbors"+neighbors);
            for(List<Integer> neighbor : neighbors){
                if(!visited.contains(neighbor.get(0))){
                    System.out.println("neighbor..."+neighbor);
                int existingShortestDistance = distancetoThisNode.get(neighbor.get(0));
                int distanceToNeighborNode = neighbor.get(1) + distancetoThisNode.get(currentNode.get(0))  ;
                if(distanceToNeighborNode<existingShortestDistance){
                    // put in PQ since new short distance found
                    // before putting check for duplicate
                    /*if(queuedSet.contains(neighbor.get(0))){
                        System.out.println("if found");
                        nodePriorityQueue.remove(neighbor);
                    }*/

                    //update the new short distance
                    distancetoThisNode.put(neighbor.get(0),distanceToNeighborNode);
                    List<Integer> updatedNeighbourNode = new ArrayList();
                    updatedNeighbourNode.add(neighbor.get(0));
                    updatedNeighbourNode.add(distanceToNeighborNode);
                    nodePriorityQueue.add(updatedNeighbourNode);
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
