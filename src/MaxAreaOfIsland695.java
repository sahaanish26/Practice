import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxAreaOfIsland695 {

    public static void main(String[] args) {

        int[] intArray1 = new int[]{ 0,0,1,0,0,0,0,1,0,0,0,0,0};
        int[] intArray2 = new int[]{ 0,0,0,0,0,0,0,1,1,1,0,0,0};
        int[] intArray3 = new int[]{ 0,1,1,0,1,0,0,0,0,0,0,0,0};
        int[] intArray4 = new int[]{ 0,1,0,0,1,1,0,0,1,0,1,0,0};
        int[] intArray5 = new int[]{ 0,1,0,0,1,1,0,0,1,1,1,0,0};
        int[] intArray6 = new int[]{ 0,0,0,0,0,0,0,0,0,0,1,0,0};
        int[] intArray7 = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        int[] intArray8 = new int[]{ 0,0,0,0,0,0,0,1,1,0,0,0,0};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3,intArray4,intArray5,intArray6,intArray7,intArray8};

        int result = maxAreaOfIsland(points);
        System.out.println(result);
    }

    public static int maxAreaOfIsland(int[][] grid) {
       // List<Node> chosenPath = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        List<List<Node>> paths = new ArrayList<>();
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int max  = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               Node cell = new Node(i,j);
                if (grid[i][j] == 0) {
                    visited.add(cell);
                }
                if(!visited.contains(cell)){
                   // System.out.println("number of dfs starting at "+cell);
                    List<Node> chosenPath = new ArrayList<>();
                    maxAreaOfIslandHelper(cell,grid,chosenPath,visited,paths );
                 //  System.out.println("chosenPath SIZE AFTER iteration of "+cell+ chosenPath+chosenPath.size());
                   if (chosenPath.size() > max) {
                       max = chosenPath.size();
                   }

                }
            }
        }
        if(max==Integer.MIN_VALUE) return 0;
        return max;
    }

    private static void maxAreaOfIslandHelper(Node cell, int[][] grid, List<Node> chosenPath, Set<Node> visited, List<List<Node>> paths) {
       // System.out.println(cell);
        chosenPath.add(cell);
        visited.add(cell);
    //    System.out.println(visited);
      // System.out.println(chosenPath.size());
      //  System.out.println(chosenPath);

        List<Node> neighbours = new ArrayList<>();
        //checkEligibility and then add as neighbour
        checkForEligibleNeighbour(cell,grid,neighbours);
       // System.out.println(neighbours.size());
        for (Node neighbour : neighbours) {
       //    System.out.println(neighbour);
            if(!visited.contains(neighbour)){
               // System.out.println(neighbour);
              //  System.out.println(visited);
                maxAreaOfIslandHelper(neighbour,grid,chosenPath,visited,paths);
            }

        }
       //we are not doing backtracking here , we are finding out the nodes in traversal
       // chosenPath.remove(chosenPath.size()-1);

    }

    private static void checkForEligibleNeighbour(Node cell, int[][] grid, List<Node> neighbours) {
        Node leftCell = new Node(cell.getRow() , cell.getCol()-1);
        Node rightCell = new Node(cell.getRow(), cell.getCol()+1);
        Node upperCell = new Node(cell.getRow()-1 , cell.getCol());
        Node lowerCell = new Node(cell.getRow()+1 , cell.getCol());

        if(isValidCell(leftCell,grid)){
            neighbours.add(leftCell);
           // System.out.println(leftCell[0] + "leftCell " + leftCell[1]);
        }
        if(isValidCell(rightCell,grid)){
            neighbours.add(rightCell);
           // System.out.println(rightCell[0] + "rightCell " + rightCell[1]);

        }
        if(  isValidCell(upperCell,grid)){
            neighbours.add(upperCell);
           // System.out.println(upperCell[0] + "upperCell " + upperCell[1]);

        }
        if(isValidCell(lowerCell,grid)){
            neighbours.add(lowerCell);
           // System.out.println(lowerCell[0] + "lowerCell " + lowerCell[1]);

        }


    }

    private static boolean isValidCell(Node cell, int[][] grid) {
        if ( cell.getRow()<0 || cell.getRow()>= grid.length || cell.getCol() <0 || cell.getCol() >= grid[0].length ){
            return false;

        }
        if ( grid[cell.getRow()][cell.getCol()] == 1 ){
            return true;
        }
        return false;
        }



}
