import java.util.ArrayList;
import java.util.List;

public class CoinChange322 {
    public static int minValue= Integer.MAX_VALUE;
    public static int numOfCalls;


    public static void main(String[] args) {
          System.out.println("Hello and welcome!");

        int[] intChoiceArray = new int[]{ 411,412,413,414,415,416,417,418,419,420,421,422};
        int desiredSum =9864;
        int fianlResult = coinChange(intChoiceArray,desiredSum);
        System.out.println("fianlResult"+ fianlResult );
        System.out.println("numOfCalls"+ numOfCalls );





    }


    public static  int coinChange(int[] coins, int amount) {

        List<Integer> choices = new ArrayList<>();
       // choices.add(1);
       // choices.add(2);
       // choices.add(5);



        for (int i : coins)
        {
            choices.add(i);
        }
        int minNumberOfCoins= minCoin(choices,amount);
        System.out.println("minNumberOfCoins"+ minNumberOfCoins );


        return minNumberOfCoins;


    }

    private static int minCoin(List<Integer> choices, int desiredSum) {
        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        minCoinHelper(choices,chosen,resultSets,desiredSum);
        System.out.println("resultSets"+ resultSets );
        if(minValue==Integer.MAX_VALUE){
            return -1;
        }
        return minValue;

    }

    private static void minCoinHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int desiredSum) {
        numOfCalls++;
        if (desiredSum == 0) {
            if(chosen.size()<minValue) {
                minValue=chosen.size();
                resultSets.add(new ArrayList<>(chosen));
            }
        } else if (desiredSum > 0 && !choices.isEmpty() && chosen.size()< minValue) {
            //choose
            //choice without considering first element
            int firstCoinValue=choices.get(0);
            choices.remove(0);
            // explore without considering first element
            minCoinHelper(choices,chosen,resultSets,desiredSum);
            //unchoose
            choices.add(0,firstCoinValue);

            //choose
            //choice with considering first element
            chosen.add(firstCoinValue);
            //since the choices are infinite this step is not required
            // choices.remove(0);
            // explore without considering first element
            minCoinHelper(choices,chosen,resultSets,desiredSum -firstCoinValue);
            //unchoose
            //since the choices are infinite this step is not required
           // choices.add(0,firstCoinValue);
             chosen.remove(chosen.size()-1);

        }


    }


}
