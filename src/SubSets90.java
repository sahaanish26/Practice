import java.util.*;

// Given a Set of Integers , print all subsets
// But the choices contain duplicates ,so we need to make sure
// only unique subsets are present
/*
Given an integer array nums that may contain duplicates, return all possible
subsets
        (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/
public class SubSets90 {
    public static int numcalls;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray = new int[]{ 4,4,4,1,4};

       // choices.add(1);
       // choices.add(3);
       // choices.add(5);

       // subListHelper (choices,chosen,resultSets);
       // System.out.println(resultSets);
        System.out.println("Final result"+ subsets(intArray) );

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<Integer>();
        List<Integer> choices = new ArrayList<Integer>();


        for (int i : nums)
        {
            choices.add(i);
        }
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Collections.sort(choices);
        subListHelper (choices,chosen,resultSets,set);
        System.out.println("numcalls"+ numcalls );
        System.out.println("set........."+ set );

        return resultSets;
    }

    private static void subListHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, Set<List<Integer>> set) {

        numcalls++;
        if (choices.isEmpty()) {
            if(!set.contains(chosen)) {
                set.add((new ArrayList<>(chosen)));
                resultSets.add(new ArrayList<>(chosen));
            }

        } else {
            // choose
            // choice without taking the first element
            // remove the first element from choices
            Integer firstChoice = choices.get(0);
            choices.remove(0);
            //explore
            subListHelper(choices, chosen, resultSets, set);
            //unchoose [ restore the choices]
            choices.add(0, firstChoice);

            //choose
            //choice with the first element
            chosen.add(firstChoice);
            choices.remove(0);
            //explore
            subListHelper(choices, chosen, resultSets, set);
            //unchoose [ restore the choices and choosen]
            chosen.remove(chosen.size() - 1);
            choices.add(0, firstChoice);
        }
    }
}
