import java.math.BigInteger;
import java.util.PriorityQueue;

public class FindtheKthLargestIntegerintheArray1985 {


    public static void main (String[] args){

       // String[] nums = {"3","6","7","10"};
       // int k =4;
        String[] nums = {"0","1","1"};
        int k =1;
        System.out.println(kthLargestNumber(nums,k));



    }

    public  static String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<BigInteger> pq= new PriorityQueue<>();

        for (int i=0;i<nums.length;i++){
            String s = nums[i];
            BigInteger num = new BigInteger(s);

            if(pq.size()<k){
                pq.add(num);

            }
            else if(num.compareTo(pq.peek())>0) {
                pq.poll();
                pq.add(num);
                
            }
        }

        
        return pq.poll().toString(); 
 
    }
    
}
