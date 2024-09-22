import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxSubArraySum {

private static int maxSubArrayLen(int[] nums, int k) {
    int max=Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    // prefixSum , and the indexes where the prefix sum is found
    Map<Integer,List<Integer>> map = new HashMap<>();
    List<Integer> firstList = new ArrayList<>();
    firstList.add(-1);
    map.put(0, firstList);
    //Sj-Si=k; so sj-k=si

    int[] prefixSum = new int[nums.length];

    for (int j=0;j<nums.length;j++){
        if(j>0){
        prefixSum[j] = prefixSum[j-1]+nums[j];}
        else{
            prefixSum[j] = nums[j];
        }

        if (map.containsKey(prefixSum[j]-k)) { // if the prefix sum -k is found in the map
            List<Integer> indexes = map.get(prefixSum[j]-k);
            //indexes.get(0) is the first index where the prefix sum is found
            // so max length of the subarray is j-indexes.get(0)
             max = Math.max(max, j-indexes.get(0));
             // min length of the subarray is j-indexes.get(indexes.size()-1)
             min = Math.min(min, j-indexes.get(indexes.size()-1));

        }

        List<Integer> indexesTobeUpdated = map.getOrDefault(prefixSum[j], new ArrayList<>());
        indexesTobeUpdated.add(j);
        map.put(prefixSum[j], indexesTobeUpdated);
    }


    System.out.println("min = " + min);

    return max;


}
}
