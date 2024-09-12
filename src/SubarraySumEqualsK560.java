import java.util.*;
public class SubarraySumEqualsK560{

public static void main (String[] args) {

    int[] nums = {10, 2, -2, -20, 10};
    //10, 2, -2, -20, 10
    int k =-10;

    int result = subarraySum(nums,k);
    System.out.println("result"+result);

}


public  static int subarraySum(int[] nums, int k) {

    int[] prefixSum = new int[nums.length];
    //Map(sum, List<Index1,index2>)
    Map<Integer,List<Integer>> indexMap = new HashMap<>();
    List<Integer> firstList = new ArrayList<>();
    firstList.add(-1);
    indexMap.put(0,firstList);

    //sj-si=k
    //sj-k=si
    int count=0;
    int maxSizeArray = 0;

  for (int j= 0 ; j<nums.length;j++){

   if(j==0){
    prefixSum[j]=nums[j];
   }else{
    prefixSum[j] = prefixSum[j-1] + nums[j];
   }

   if (indexMap.containsKey(prefixSum[j]-k)){
       count= count+ indexMap.get(prefixSum[j]-k).size();
       for (int n=0;n<indexMap.get(prefixSum[j]-k).size() ;n++){
        System.out.println("match found at"+j+"and"+ indexMap.get(prefixSum[j]-k).get(n));

       }
       //taking the earliest match from Map
       maxSizeArray = Math.max(maxSizeArray,j-indexMap.get(prefixSum[j]-k).get(0));
   }

   List<Integer> indexList = indexMap.getOrDefault(prefixSum[j], new ArrayList<>());
   indexList.add(j);
   indexMap.put(prefixSum[j],indexList);


  }

System.out.println("maxSizeArray"+maxSizeArray);
        return  count;
}

}