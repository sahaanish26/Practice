import java.util.*;

public class MinCostToConnectAllPoints1584 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 0,0};
        int[] intArray2 = new int[]{ 2,2};
        int[] intArray3 = new int[]{ 3,10};
        int[] intArray4 = new int[]{ 5,2};
        int[] intArray5 = new int[]{ 7,0};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3,intArray4,intArray5};
        int[] intArray6 = new int[]{ 3,12};
        int[] intArray7 = new int[]{ -2,5};
        int[] intArray8 = new int[]{ -4,1};

       // int[][] points  = new int[][]{intArray6,intArray7,intArray8};


        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);
        System.out.println("Final result"+ minCostConnectPoints(points));

    }

    public static int minCostConnectPoints(int[][] points) {
        int numberOfPoints = points.length;
        if(numberOfPoints == 1) return 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int[] firstPoint = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] secondPoint = points[j];
                int distance = Math.abs(firstPoint[0] - secondPoint[0]) + Math.abs(firstPoint[1] - secondPoint[1]);
                int[] node = new int[3];
                node[0] = i;
                node[1] = j;
                node[2] = distance;
                list.add(node);
                int [] reverseNode = new int[3];
                reverseNode[0] = j;
                reverseNode[1] = i;
                reverseNode[2] = distance;
                list.add(reverseNode);
            }
        }
        // System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            int[] point = list.get(i);
            // System.out.println(point[0] + " " + point[1] + " " + point[2]);
        }

        Set<Integer> inMST = new HashSet<>();
        int minCost=0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[] firstRandomNode = list.get(0);
        inMST.add(firstRandomNode[0]) ;
        for (int i = 0; i < list.size(); i++) {
            int[] point = list.get(i);
            //put all neighbours of first chosen random node in heap
            if(firstRandomNode[0]==point[0]){
                minHeap.add(point);
            }
        }

        // System.out.println("minHeap with neighbours of first node "+minHeap.size());

        while(!minHeap.isEmpty()){
            // if the toNode of the edge is not is MST then only add
            if(!inMST.contains(minHeap.peek()[1])){
                int[] minCostNode = minHeap.poll();
                minCost =minCost+minCostNode[2];
                inMST.add(minCostNode[1]);
                //if all nodes of graph are already in MST then stop and return the value
                if(inMST.size()==numberOfPoints){
                    return minCost;
                }

                // System.out.println("minCostNode"+minCostNode[0] + " *" + minCostNode[1] + " *" + minCostNode[2]);
                // System.out.println("mminCost "+minCost);
                // put all neighbours of chosen endNode in heap
                for(int i = 0; i < list.size(); i++){
                    int[] node = list.get(i);
                    if(minCostNode[1]==node[0] ){
                      minHeap.add(node);
                    }
                }
            }
            else{
                minHeap.poll();
            }


        }



        return 0;
    }
}
