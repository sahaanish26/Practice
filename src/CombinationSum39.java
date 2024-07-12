import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
        frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



        Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
*/


public class CombinationSum39 {
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


        System.out.println("Final result"+ combinationSum(intArray,target) );

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<Integer>();
        List<Integer> choices = new ArrayList<Integer>();


        for (int i : candidates)
        {
            choices.add(i);
        }
        combinationSumHelper(choices,chosen,resultSets,target);
    return resultSets;
    }

    private static void combinationSumHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target) {

        if(target==0){
            resultSets.add(new ArrayList<>(chosen));
        }
        else if (target>0 && !choices.isEmpty()){

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            //explore
            combinationSumHelper(choices,chosen,resultSets,target);
            //unchoose
            choices.add(0,firstChoice);

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            // since choices are infinite , removing choices does not matter
            //choices.remove(firstChoice)
            combinationSumHelper(choices,chosen,resultSets,target-firstChoice);
            //unchoose
            chosen.remove(chosen.size()-1);

        }
    }
}
