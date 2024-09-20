import java.util.Arrays;

public class BestTimeToBuyAndSellStock121 {
    public static void main (String[ ] args){
     
        int[] prices = {7,1,5,3,6,4};
        System.out.println("mxProfit1"+maxProfit(prices));

    }
    
    // can be solved by min so far concept
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
    //with Max so far on right side
    public static int maxProfit1(int[] prices) {
        
        int [] maxSofar = new int[prices.length];
        int max = Integer.MIN_VALUE;

        for (int i= prices.length-1; i>=0;i--){
            if(i==prices.length-1){maxSofar[i]=prices[i];}
            else{
                maxSofar[i] = Math.max(maxSofar[i+1],prices[i]);

            }
           
        }
        System.out.println(Arrays.toString(maxSofar));

        for (int i= prices.length-1; i>=0;i--){
          max = Math.max(max,maxSofar[i]-prices[i]);

        }

       

        if (max>=0)
        return max;

        return 0;
    }
}
