import java.util.Arrays;

public class UniquePaths62 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray = new int[]{ 1,3,2};
        int target = 7;
        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ uniquePaths(3,7) );

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return uniquePathsHelper(m,n,dp);
    }

    public static int uniquePathsHelper(int m, int n, int[][] dp) {
        // System.out.println("m: " + m + ", n: " + n);
        // System.out.println("int[m][n] dp" + dp[m][n]);
        if (m == 0 || n == 0) {
            dp[m][n]=0;
            return 0;}
        if (m == 1 || n == 1) {
            dp[m][n]=1;
            return 1;}

        if(dp[m][n]>0){
            return dp[m][n];
        }

        int numberOfPaths=  uniquePathsHelper(m-1,n,dp) + uniquePathsHelper(m,n-1,dp);
        dp[m][n] = numberOfPaths;
        //  System.out.println("m: later" + m + ", n: later " + n);
        //  System.out.println("int[m][n] dp later" + dp[m][n]);
        return numberOfPaths;
    }
}
