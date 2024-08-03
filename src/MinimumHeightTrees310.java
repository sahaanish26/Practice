import java.util.*;

public class MinimumHeightTrees310 {

    public static void main(String[] args) {

       /* int[] intArray1 = new int[]{ 1,0};
        int[] intArray2 = new int[]{ 1,2};
        int[] intArray3 = new int[]{ 1,3};

        int[][] points  = new int[][]{intArray1,intArray2,intArray3};*/


        int[] intArray1 = new int[]{ 3,0};
        int[] intArray2 = new int[]{ 3,1};
        int[] intArray3 = new int[]{ 3,2};
        int[] intArray4 = new int[]{ 3,4};
        int[] intArray5 = new int[]{ 5,4};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3,intArray4,intArray5};


       // System.out.println( findMinHeightTrees(4,points));
         System.out.println( findMinHeightTrees(6,points));
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
        for (int i=0; i<n; i++) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> chosenPath = new ArrayList<>();
            List<List<Integer>> allPathsFromNode = new ArrayList<>();
            maxHeights[i] = Integer.MIN_VALUE;
            int startNode=i;
            backTrackingDfs(i,startNode,visited,chosenPath,allPathsFromNode,graphMap,maxHeights);
            //  System.out.println("allPathsFromNode"+allPathsFromNode);

        }
        // System.out.println("maxHeights"+Arrays.toString(maxHeights));
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i=0; i<n; i++) {
            List<Integer> nodes = treeMap.getOrDefault(maxHeights[i], new ArrayList<>());
            nodes.add(i);
            treeMap.put(maxHeights[i], nodes);
        }
        // System.out.println("treeMap"+treeMap);
        int firstEntry = treeMap.firstKey();
        List<Integer> result = treeMap.get(firstEntry);
        return result;
    }

    private static  void backTrackingDfs(int source, int startNode, Set<Integer> visited, List<Integer> chosenPath, List<List<Integer>> allPathsFromNode, Map<Integer, List<Integer>> graphMap, int[] maxHeights) {

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
            // System.out.println(chosenPath);
            allPathsFromNode.add(new ArrayList<>(chosenPath));
            if(chosenPath.size() > maxHeights[startNode]) {
                maxHeights[startNode] = chosenPath.size();
            }
        }

        //explore only if maxHeight has not reached the size of graph, because in a tree max edge can not be more than number of nodes.
        if( maxHeights[startNode]<graphMap.size() ) {
            for (Integer neighbour : eligibleNeighbours) {
                backTrackingDfs(neighbour, startNode, visited,chosenPath,allPathsFromNode,graphMap,maxHeights);
            }}

        chosenPath.remove(chosenPath.size()-1);

    }}
