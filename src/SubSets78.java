import java.util.ArrayList;
import java.util.List;

// Given a Set of Integers , print all subsets
public class SubSets78 {
    public static int numcalls;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray = new int[]{ 1,3,5};

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
        subListHelper (choices,chosen,resultSets);
        System.out.println("numcalls"+ numcalls );

        return resultSets;
    }

    private static void subListHelper(List<Integer> choices,List<Integer> chosen, List<List<Integer>> resultSets) {

        numcalls++;
        if (choices.isEmpty()) {
            resultSets.add(new ArrayList<>(chosen));
        } else {
            // choose
            // choice without taking the first element
            // remove the first element from choices
            Integer firstChoice = choices.get(0);
            choices.remove(0);
            //explore
            subListHelper(choices, chosen, resultSets);
            //unchoose [ restore the choices]
            choices.add(0, firstChoice);

            //choose
            //choice with the first element
            chosen.add(firstChoice);
            choices.remove(0);
            //explore
            subListHelper(choices, chosen, resultSets);
            //unchoose [ restore the choices and choosen]
            chosen.remove(chosen.size() - 1);
            choices.add(0, firstChoice);
        }
    }
}
