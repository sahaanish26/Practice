import java.util.LinkedList;
import java.util.Queue;

public class CountSubarraysWithScoreLessThanK {
    
public static void main (String[] args){

    System.out.println("Hello World");

    //int [] nums =  {2,1,4,3,5};
   // long k =10;


    int [] nums =  {1,1,1};
    long k =5;

    System.out.println(countSubarrays(nums,k));
}


public static long countSubarrays(int[] nums, long k) {

    long count = 0;
    int leftP=0;
    int rightP=0;
    long sum =0;
    long score =0;
    Queue<Integer> windowSumIndex = new LinkedList<>();

    while(rightP<nums.length){
        sum =sum+nums[rightP];
        windowSumIndex.add(rightP);
        rightP++;
    //decrease the window only when the window becomes invalid
        while(sum*windowSumIndex.size()>=k){
          sum = sum - nums[leftP];
          windowSumIndex.remove(leftP);
          leftP++;

        }
        count = count + rightP - leftP;
     

    }


    return count;
        
}

}
