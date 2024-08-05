import java.util.*;

public class MostFrequentSubTreeSum508 {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
         findFrequentTreeSumHelper(root,map);
         System.out.println("map = " + map);
         TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           List<Integer> frequentNodes=   sortedMap.getOrDefault(entry.getValue(),new ArrayList<>());
           frequentNodes.add(entry.getKey());
           sortedMap.put(entry.getValue(),frequentNodes);
         }
        System.out.println("sortedMap = " + sortedMap);
         List<Integer> mostFrequentNodes = sortedMap.get(sortedMap.firstKey());
         int[] res = new int[mostFrequentNodes.size()];
         for (int i = 0; i < mostFrequentNodes.size(); i++) {
             res[i] = mostFrequentNodes.get(i);
         }
         return res;

    }

    private int findFrequentTreeSumHelper(TreeNode root, Map<Integer, Integer> map) {
        if (root== null) {
            return 0;
        }

            int rootSum = root.val;
            int sumLeftTree=findFrequentTreeSumHelper(root.left,map);
            int sumRightTree=findFrequentTreeSumHelper(root.right,map);
            int subTreeSum = rootSum+sumLeftTree+sumRightTree;
            int existingFrequency= map.getOrDefault(subTreeSum,0);
            map.put(subTreeSum,existingFrequency+ 1);

            return subTreeSum;

    }
}
