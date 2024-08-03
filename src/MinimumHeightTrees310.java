import java.util.*;

public class MinimumHeightTrees310 {

    public static void main(String[] args) {

        int[] intArray1 = new int[]{ 1,0};
        int[] intArray2 = new int[]{ 1,2};
        int[] intArray3 = new int[]{ 1,3};

        int[][] points  = new int[][]{intArray1,intArray2,intArray3};


        /*int[] intArray1 = new int[]{ 3,0};
        int[] intArray2 = new int[]{ 3,1};
        int[] intArray3 = new int[]{ 3,2};
        int[] intArray4 = new int[]{ 3,4};
        int[] intArray5 = new int[]{ 5,4};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3,intArray4,intArray5};
*/

       // int[][] points= new int[][] {{0,1},{0,2},{0,3},{3,4},{4,5}};
       // int[][] points= new int[][] {{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}};


        System.out.println( findMinHeightTrees(4,points));
        // System.out.println( findMinHeightTrees(6,points));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for( int[] edge : edges ) {
            int start = edge[0];
            int end = edge[1];
            List<Integer> neighbours =  graphMap.getOrDefault(start, new ArrayList<>());
            neighbours.add(end);
            graphMap.put(start, neighbours);
            List<Integer> neighboursReverse =  graphMap.getOrDefault(end, new ArrayList<>());
            neighboursReverse.add(start);
            graphMap.put(end, neighboursReverse);
        }
        List<Integer> res = new ArrayList<>();
        int[] maxHeights = new int[n];
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
       // treeMap.put(Integer.MAX_VALUE,new ArrayList<>());
        for (int i=0; i<n; i++) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> chosenPath = new ArrayList<>();
            List<List<Integer>> allPathsFromNode = new ArrayList<>();
            maxHeights[i] = Integer.MIN_VALUE;
            int startNode=i;
            int minSoFar = Integer.MAX_VALUE;
            if(i>0) {
                minSoFar=treeMap.firstKey();
            }
            backTrackingDfs(i,startNode,visited,chosenPath,allPathsFromNode,graphMap,maxHeights,minSoFar);
            //  System.out.println("allPathsFromNode"+allPathsFromNode);
           // if(maxHeights[i]>Integer.MIN_VALUE) {
                List<Integer> nodes = treeMap.getOrDefault(maxHeights[i],new ArrayList<>());
                nodes.add(i);
                treeMap.put(maxHeights[i],nodes);
           // }

        }
         System.out.println("maxHeights"+Arrays.toString(maxHeights));

         System.out.println("treeMap"+treeMap);
        int firstEntry = treeMap.firstKey();
        List<Integer> result = treeMap.get(firstEntry);
        return result;
    }

    private static  void backTrackingDfs(int source, int startNode, Set<Integer> visited, List<Integer> chosenPath, List<List<Integer>> allPathsFromNode, Map<Integer, List<Integer>> graphMap, int[] maxHeights, Integer minSoFar) {
     System.out.println("for startNode "+startNode+" minSofar "+minSoFar);
        chosenPath.add(source);
        visited.add(source);
        List<Integer> eligibleNeighbours = new ArrayList<>();
        List<Integer> neighbours =  graphMap.get(source);
        for (Integer neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                eligibleNeighbours.add(neighbour);
            }
        }
        if (eligibleNeighbours.isEmpty()) {
            //found leaf node
            System.out.println("chosenPath"+chosenPath);
            allPathsFromNode.add(new ArrayList<>(chosenPath));
            if(chosenPath.size() > maxHeights[startNode]) {
                maxHeights[startNode] = chosenPath.size();
            }
        }


        if( (maxHeights[startNode]>0 && maxHeights[startNode] <= minSoFar) || (maxHeights[startNode]<0) ) {
            System.out.println(" minSoFar "+minSoFar+" chosenPath.size() "+chosenPath.size());
            for (Integer neighbour : eligibleNeighbours) {
                backTrackingDfs(neighbour, startNode, visited,chosenPath,allPathsFromNode,graphMap,maxHeights, minSoFar);
            }
    }

        chosenPath.remove(chosenPath.size()-1);

    }


}




