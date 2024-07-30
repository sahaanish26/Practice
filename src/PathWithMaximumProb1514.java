import java.util.*;

public class PathWithMaximumProb1514 {


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 0,1};
        int[] intArray2 = new int[]{ 1,2};
        int[] intArray3 = new int[]{ 0,2};
       // int[] intArray4 = new int[]{ 5,2};
       // int[] intArray5 = new int[]{ 7,0};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3};
        int[] intArray6 = new int[]{ 0,1};
        //int[] intArray7 = new int[]{ -2,5};
      //  int[] intArray8 = new int[]{ -4,1};
        int[][] points1  = new int[][]{intArray6};
        double[] succProb = new double[]{0.5,0.5,0.2};
        double[] succProb1 = new double[]{0.5};

        // int[][] points  = new int[][]{intArray6,intArray7,intArray8};


        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);
      //  System.out.println("Final result"+ maxProbability(3,points,succProb,0,2));
        System.out.println("Final result"+ maxProbability(3,points1,succProb1,0,2));

    }


    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

       double[] maxProbability = new double[n];
       for (int i = 0; i < n; i++) {
           maxProbability[i] = Double.MIN_VALUE;
       }
       Map<Integer, List<double[]>> graph = new HashMap<>();
       for (int i = 0; i < edges.length; i++) {
           int[] edge = edges[i];
           int source = edge[0];
           int target = edge[1];
           double weight = succProb[i];

           // now create the adj list
           if (!graph.containsKey(source)) {
               List<double[]> neighbours = new ArrayList<>();
               double[] neighbour = new double[2];
               neighbour[0] = target;
               neighbour[1] = weight;
               neighbours.add(neighbour);
               graph.put(source, neighbours);
           }else{
               List<double[]> neighbours = graph.get(source);
               double[] neighbour = new double[2];
               neighbour[0] = target;
               neighbour[1] = weight;
               neighbours.add(neighbour);
           }

           if (!graph.containsKey(target)) {
               List<double[]> neighbours = new ArrayList<>();
               double[] neighbour = new double[2];
               neighbour[0] = source;
               neighbour[1] = weight;
               neighbours.add(neighbour);
               graph.put(target, neighbours);
           }else{
               List<double[]> neighbours = graph.get(target);
               double[] neighbour = new double[2];
               neighbour[0] = source;
               neighbour[1] = weight;
               neighbours.add(neighbour);
           }
       }
System.out.println(graph);

    PriorityQueue<double[]> pq = new PriorityQueue<>(new ArayComparator());
       HashSet<Integer> visited = new HashSet<>();
       double[] startNode= new double[2];
        startNode[0] = start_node;
        startNode[1] = 1.0;
        maxProbability[start_node] = 1.0;
        pq.add(startNode);

       while (!pq.isEmpty()) {
           double[] currentNode = pq.poll();
           double currentNodeValue = currentNode[0];
           double currentNodeWeight = currentNode[1];
           visited.add((int) currentNodeValue);
          for (double[] neighbour : graph.getOrDefault((int)currentNodeValue,new ArrayList<double[]>())) {
              // for each unvisited neighbour
              if (!visited.contains((int) neighbour[0])) {
                 double updatedDistanceToTargetNode = maxProbability[(int)currentNodeValue]* neighbour[1];

                  if (updatedDistanceToTargetNode > maxProbability[(int) neighbour[0]]) {
                      maxProbability[(int) neighbour[0]] = updatedDistanceToTargetNode;
                      double[] updatedNeighbour = new double[2];
                      updatedNeighbour[0] = neighbour[0];
                      updatedNeighbour[1]= updatedDistanceToTargetNode;
                    //  updatedNeighbour[2] = updatedDistanceToTargetNode;
                      pq.add(updatedNeighbour);
                  }
              }
          }

       }

System.out.println(Arrays.toString(maxProbability))
;
if (maxProbability[end_node]>Double.MIN_VALUE){
    return maxProbability[end_node];
}
 return 0.0;
    }
}

class ArayComparator implements Comparator<double[]>  {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(List<Integer> l1, List<Integer> l2) {
        if (l1.get(1) > l2.get(1))
            return 1;
        else if (l1.get(1) < l2.get(1))
            return -1;
        return 0;
    }


    @Override
    public int compare(double[] o1, double[] o2) {
        if (o1[1] < o2[1])
            return 1;
        else if (o1[1] > o2[1])
            return -1;
        return 0;
    }
}
