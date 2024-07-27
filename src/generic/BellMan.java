package generic;

import java.util.*;

public class BellMan {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        //https://www.youtube.com/watch?v=NHLValhbnVE
       // https://cp-algorithms.com/graph/bellman_ford.html
  /*      int[] intArray1 = new int[]{ 2,1,1};
        int[] intArray2 = new int[]{ 2,3,1};
        int[] intArray3 = new int[]{ 3,4,1};
        // int[] intArray4 = new int[]{ 2,3,1};
        int[][] flightArrays = { intArray1, intArray2, intArray3 };
        System.out.println("Final result" + findCheapestPrice(4,flightArrays,2) );

*/

        int[] intArray8 = new int[]{ 0,1,4};
        int[] intArray2 = new int[]{ 0,2,2};
        int[] intArray3 = new int[]{ 1,2,3};
        int[] intArray4 = new int[]{ 2,1,1};
        int[] intArray5 = new int[]{ 1,4,3};
        int[] intArray6 = new int[]{ 2,3,4};
        int[] intArray7 = new int[]{ 2,4,5};
        int[] intArray1 = new int[]{ 4,3,-5};
        int[] intArray9 = new int[]{ 1,3,2};


        int[] intArray11 = new int[]{ 0,1,10};
        int[] intArray12 = new int[]{ 1,2,10};
        int[] intArray13 = new int[]{ 0,2,100};
        int[] intArray14 = new int[]{ 2,0,-10};
        int[] intArray15 = new int[]{ 1,2,1};








        // int[] intArray4 = new int[]{ 2,3,1};
      //  int[][] flightArrays = { intArray1, intArray2, intArray3,intArray4, intArray5,intArray6,intArray7,intArray8,intArray9 };
        int[][] flightArrays = { intArray11, intArray12, intArray13,intArray14, intArray15 };

        flights1(4,flightArrays,0,3,1);






    }

    private static void flights(int n, int[][] flightArrays, int src, int dst, int k) {

        int[] minDistance= new int[n];
        for (int i = 0; i < n; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flightArrays.length; i++) {
            int[] neighbour = new int[2];
           int[] flight = flightArrays[i];
           int startNode = flight[0];
           int endNode = flight[1];
           int distance = flight[2];
           neighbour[0] = endNode;
           neighbour[1] = distance;
           if (map.containsKey(startNode)) {
               List<int[]> neighbours = map.get(startNode);
               neighbours.add(neighbour);
           }else{
               List<int[]> neighbours = new ArrayList<>();
               neighbours.add(neighbour);
               map.put(startNode, neighbours);
           }
        }
        //setting starting node distance to 0;
        minDistance[src] = 0;
        System.out.println(map);
        //for bellman ford we should iterate for n-1 times, however for this problem we will do until k (k stops)
        for(int i = 0; i <n; i++) {

        //List<int[]> neighboursOfStart = map.get(src);
        helperBfs(src,map,minDistance);
        System.out.println("minDistance array after iteration" +i+ "is"+Arrays.toString(minDistance));

        }

    }

    private static void helperBfs(int src, Map<Integer, List<int[]>> map, int[] minDistance) {
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited.add(cur);
            List<int[]> neighbours = map.get(cur);
          if(neighbours != null) {
              for (int[] neighbour : neighbours) {
                  System.out.println(Arrays.toString(neighbour));
                  int distanceFromCurtoNeighbour = minDistance[cur] + neighbour[1];
                  if (distanceFromCurtoNeighbour < minDistance[neighbour[0]]) {
                      minDistance[neighbour[0]] = distanceFromCurtoNeighbour;
                  }
                  System.out.println(Arrays.toString(minDistance));
                  if (!visited.contains(neighbour[0])) {
                      queue.add(neighbour[0]);
                  }
              }
          }

        }
    }


    private static void flights1(int n, int[][] flightArrays, int src, int dst, int k) {

        int[] minDistance= new int[n];
        for (int i = 0; i < n; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flightArrays.length; i++) {
            int[] neighbour = new int[2];
            int[] flight = flightArrays[i];
            int startNode = flight[0];
            int endNode = flight[1];
            int distance = flight[2];
            neighbour[0] = endNode;
            neighbour[1] = distance;

        }
        //setting starting node distance to 0;
        minDistance[src] = 0;
        System.out.println(map);
        //for bellman ford we should iterate for n-1 times, however for this problem we will do until k (k stops)
        for(int i = 0; i <n; i++) {

            //List<int[]> neighboursOfStart = map.get(src);
            for (int j = 0; j < flightArrays.length; j++) {
                int[] edge = flightArrays[j];
                System.out.println(Arrays.toString(edge));
                System.out.println(minDistance[edge[0]]);
                if(minDistance[edge[0]]<Integer.MAX_VALUE) {
                    int distanceToEdgeVertex = minDistance[edge[0]] + edge[2];
                    if(minDistance[edge[1]]>distanceToEdgeVertex) {
                        minDistance[edge[1]] = distanceToEdgeVertex;
                    }

                }
                System.out.println(Arrays.toString(minDistance));
            }

            System.out.println("minDistance array after iteration" +i+ "is"+Arrays.toString(minDistance));

        }

    }

}
