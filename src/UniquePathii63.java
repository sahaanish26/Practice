public class UniquePathii63 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray = new int[]{ 1,0};
        int[][] graphArrays = { intArray };

        int target = 7;
        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ uniquePathsWithObstacles(graphArrays) );

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

      if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
      if (obstacleGrid[0][0] == 1) return 0;
      int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstaclesHelper(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
    }

    private static int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int row, int column, int[][] dp) {

System.out.println("row"+row +"column"+column);


        if (row <0 || column <0 ) {
            return 0;
        }
        if (obstacleGrid[row][column] == 1) {
            return 0;
        }

        if (row == 0 && column == 0) {
                return 1;
        }

        if (row == 0 && column == 1) {
            return 1;
        }
        if (row == 1 && column == 0) {
            return 1;
        }


        if (dp[row][column] > 0){
            return dp[row][column];

        }





       int numberOfWaysfromtop = uniquePathsWithObstaclesHelper(obstacleGrid,row-1,column,dp);
       int  numberOfWaysfromLeft= uniquePathsWithObstaclesHelper(obstacleGrid,row,column-1,dp);
       int totalNumberOfWays = numberOfWaysfromtop + numberOfWaysfromLeft;

        dp[row][column]=totalNumberOfWays;
        return totalNumberOfWays;
    }
}
