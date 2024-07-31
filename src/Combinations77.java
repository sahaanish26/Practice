import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

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


        System.out.println("Final result"+ combine(1,1) );

    }

    public static List<List<Integer>> combine(int n, int k) {
      if(n == 0 || k == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
           choices.add(i);
        }
        List<Integer> chosen = new ArrayList<>();

        combineHelper(chosen,choices,res,k);

        return  res;
    }

    private static void combineHelper(List<Integer> chosen, List<Integer> choices, List<List<Integer>> res, int k) {
        if(chosen.size() == k) {
            res.add(new ArrayList<>(chosen));
        } else if (chosen.size() < k && choices.size() >0) {
            // chose explore unchoose without selecting first choice
           int firstChoice = choices.get(0);
           //consider the choice is not there
           choices.remove(0);
           combineHelper(chosen,choices,res,k);
           choices.add(0,firstChoice);

            // chose explore unchoose with selecting first choice
            chosen.add(firstChoice);
           choices.remove(0);
           combineHelper(chosen,choices,res,k);
           chosen.remove(chosen.size()-1);
           choices.add(0,firstChoice);

        }
    }
}
