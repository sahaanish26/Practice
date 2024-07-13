import java.util.*;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
*/


public class CombinationSum216 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        int target = 1;
        int desiredLength=4;
        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ combinationSum3(desiredLength,target) );

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9};
        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<Integer>();
        List<Integer> choices = new ArrayList<Integer>();


        for (int i : intArray)
        {
            choices.add(i);
        }
       // Collections.sort(choices);
      // Leetcode submission happened without the below optimization
       /* int maxPossibleSum=0;
        int minPossibleSum=0;
        for(int j=choices.size()-1;j>=choices.size()-k;j--){
            maxPossibleSum=maxPossibleSum+choices.get(j);
            System.out.println("maxPossibleSum="+maxPossibleSum);

        }
        if (n>maxPossibleSum){return resultSets;}
        for(int l=0;l<k;l++){
            minPossibleSum=minPossibleSum+choices.get(l);
            System.out.println("minPossibleSum="+minPossibleSum);

        }
        if (n<minPossibleSum){return resultSets;}*/
        combinationSum3Helper(choices,chosen,resultSets,n,k);
        return resultSets;
    }

    private static void combinationSum3Helper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target, int desiredLength ) {

        if(target==0){
            if(chosen.size()==desiredLength){
                resultSets.add(new ArrayList<>(chosen));
            }
        }
        else if (target>0 && !choices.isEmpty() && chosen.size()<desiredLength ){
            //also need to find if target is unachievable

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            //explore
            combinationSum3Helper(choices,chosen,resultSets,target,desiredLength);
            //unchoose
            choices.add(0,firstChoice);

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            choices.remove(0);
            combinationSum3Helper(choices,chosen,resultSets,target-firstChoice,desiredLength);
            //unchoose
            chosen.remove(chosen.size()-1);
            choices.add(0,firstChoice);

        }
    }
}
