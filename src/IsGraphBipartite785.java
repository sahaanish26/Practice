import java.util.*;

public class IsGraphBipartite785 {


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 1,3};
        int[] intArray2 = new int[]{ 0,2};
        int[] intArray3 = new int[]{ 1,3};
        int[] intArray4 = new int[]{ 0,2};

        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };

      /*  int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };
*/



        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ isBipartite(graphArrays) );

    }


        public static boolean isBipartite(int[][] graph) {

            Map<Integer, List<Integer>> mapGraph = new HashMap<>();
            Set<Integer> visited = new HashSet<>();
            Map<Integer, String> colorGraph = new HashMap<>();
            for (int i=0; i<graph.length; i++) {
                int[] nodes =graph[i];
                List<Integer> listNodes = new ArrayList<>();
                for (int j=0; j<nodes.length; j++) {
                    listNodes.add(nodes[j]);
                }
                mapGraph.put(i, listNodes);
                colorGraph.put(i,"Neutral");
            }

            System.out.println(mapGraph);
            System.out.println(colorGraph);

            for(int i=0; i<graph.length; i++) {
                if(!visited.contains(i)) {
                  boolean result=   isBipartiteBfs(i,mapGraph,visited,colorGraph);
                  if(!result) {
                      return false;
                  }
                }
            }
            return true;
        }

    private static boolean isBipartiteBfs(int start, Map<Integer, List<Integer>> mapGraph, Set<Integer> visited, Map<Integer, String> colorGraph) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colorGraph.put(start,"Blue");
        while(!queue.isEmpty()) {

            int node = queue.poll();
            visited.add(node);
            List<Integer> listNodes = mapGraph.get(node);
            for(int i=0; i<listNodes.size(); i++) {
                if(colorGraph.get(node).equalsIgnoreCase("Blue")) {
                    if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral"))
                    {colorGraph.put(listNodes.get(i), "Red");}

                }
                if(colorGraph.get(node).equalsIgnoreCase("Red")) {
                    if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral")){
                        colorGraph.put(listNodes.get(i), "Blue");
                    }

                }

                if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase(colorGraph.get(node))  && !colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral") && !colorGraph.get(node).equalsIgnoreCase("Neutral")) {
                    return false;
                }
                if(!visited.contains(listNodes.get(i))) {

                    queue.add(listNodes.get(i));
                }
            }

            System.out.println(colorGraph);

        }
        return true;
    }

    //coloring before color check also works
    private static boolean isBipartiteBfs1(int start, Map<Integer, List<Integer>> mapGraph, Set<Integer> visited, Map<Integer, String> colorGraph) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colorGraph.put(start,"Blue");
        while(!queue.isEmpty()) {

            int node = queue.poll();
            visited.add(node);
            List<Integer> listNodes = mapGraph.get(node);
            for(int i=0; i<listNodes.size(); i++) {
                if(colorGraph.get(node).equalsIgnoreCase("Blue")) {
                    if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral"))
                    {colorGraph.put(listNodes.get(i), "Red");}

                }
                if(colorGraph.get(node).equalsIgnoreCase("Red")) {
                    if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral")){
                        colorGraph.put(listNodes.get(i), "Blue");
                    }

                }

                if(colorGraph.get(listNodes.get(i)).equalsIgnoreCase(colorGraph.get(node))  && !colorGraph.get(listNodes.get(i)).equalsIgnoreCase("Neutral") && !colorGraph.get(node).equalsIgnoreCase("Neutral")) {
                    return false;
                }
                if(!visited.contains(listNodes.get(i))) {

                    queue.add(listNodes.get(i));
                }
            }

            System.out.println(colorGraph);

        }
        return true;
    }

}
