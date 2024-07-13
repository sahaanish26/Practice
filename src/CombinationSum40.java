import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

*/


public class CombinationSum40 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray = new int[]{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
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
        Collections.sort(choices);
        Set<List<Integer>> set = new HashSet<>();
        combinationSumHelper(choices,chosen,resultSets,target,set);
        return resultSets;
    }

    private static void combinationSumHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target, Set<List<Integer>> set) {

        if(target==0){
            if(!set.contains(chosen)){
                set.add(new ArrayList<>(chosen));
            resultSets.add(new ArrayList<>(chosen));
        }
        }
        else if (target>0 && !choices.isEmpty()){

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            //explore
            combinationSumHelper(choices,chosen,resultSets,target,set);
            //unchoose
            choices.add(0,firstChoice);

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            choices.remove(0);
            combinationSumHelper(choices,chosen,resultSets,target-firstChoice,set);
            //unchoose
            chosen.remove(chosen.size()-1);
            choices.add(0,firstChoice);

        }
    }
}
