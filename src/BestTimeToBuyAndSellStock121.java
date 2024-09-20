import java.util.Arrays;

public class BestTimeToBuyAndSellStock121 {
    public static void main (String[ ] args){
     
        int[] prices = {7,1,5,3,6,4};
        System.out.println("mxProfit"+maxProfit(prices));

    }
    
    
    public static int maxProfit(int[] prices) {
        
        int [] minSofar = new int[prices.length];
        int max = Integer.MIN_VALUE;

        for (int i= 0; i<prices.length;i++){
            if(i==0){minSofar[i]=prices[i];}
            else{
                minSofar[i] = Math.min(minSofar[i-1],prices[i]);

            }
           
        }

        for (int i= 0; i<prices.length;i++){
          max = Math.max(max,prices[i]-minSofar[i]);

        }

        System.out.println(Arrays.toString(minSofar));

        if (max>=0)
        return max;

        return 0;
    }
}
