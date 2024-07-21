import java.util.HashSet;
import java.util.Set;

public class IslandPerimeter463 {
public static int count=0;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 0,1,0,0};
        int[] intArray2 = new int[]{ 1,1,1,0};
        int[] intArray3 = new int[]{ 0,1,0,0};
        int[] intArray4 = new int[]{ 1,1,0,0};


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


        System.out.println("Final result"+ islandPerimeter(graphArrays) );

    }
    public static int islandPerimeter(int[][] grid) {
       Set<String> visited = new HashSet<>();
        count=0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if(!visited.contains(String.valueOf(i)+"*"+String.valueOf(j))) {
                  dfsHelper(i,j,visited,grid,grid.length,grid[0].length);
                }
            }
        }
        return count;
    }

    private static void dfsHelper(int row, int col, Set<String> visited, int[][] grid,int rowLength, int colLength ) {
        // System.out.println(count);
        visited.add(String.valueOf(row)+"*"+String.valueOf(col));
        // System.out.println(visited);
        //do further dfs if land found and the cells are within grid
        if((row>=0 && row<rowLength) && (col>=0 && col<colLength) && (grid[row][col] == 1)){

            // upper perimeter
            int upperRow = row-1;
            int upperCol = col;
            //if upper position is outside(so boundary) or  water
            if(upperRow<0) {
                count++;
            }else if(grid[upperRow][upperCol]==0 ){
                count++;
            }
            // lower perimeter
            int lowerRow = row+1;
            int lowerCol = col;

            if( lowerRow>=rowLength) {
                count++;
            }else if(grid[lowerRow][lowerCol]==0 ){
                count++;
            }
            // left side perimeter
            int leftRow=row;
            int leftCol=col-1;
            if( leftCol<0) {
                count++;
            }
            else if(grid[leftRow][leftCol]==0){
                count++;
            }

            // right side perimeter
            int rightRow=row;
            int rightCol=col+1;
            if(rightCol>=colLength) {
                count++;
            }
            else if(grid[rightRow][rightCol]==0){
                count++;
            }
            if(!visited.contains(String.valueOf(upperRow)+"*"+String.valueOf(upperCol))) {
                dfsHelper(upperRow,upperCol,visited,grid,rowLength,colLength);
            }

            if(!visited.contains(String.valueOf(lowerRow)+"*"+String.valueOf(lowerCol))) {
                dfsHelper(lowerRow,lowerCol,visited,grid,rowLength,colLength);
            }

            if(!visited.contains(String.valueOf(leftRow)+"*"+String.valueOf(leftCol))) {
                dfsHelper(leftRow,leftCol,visited,grid, rowLength,colLength);
            }

            if(!visited.contains(String.valueOf(rightRow)+"*"+String.valueOf(rightCol))) {
                dfsHelper(rightRow,rightCol,visited,grid, rowLength,colLength);
            }


        }
    }}
