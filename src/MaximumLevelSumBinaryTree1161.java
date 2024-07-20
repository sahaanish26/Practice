import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumBinaryTree1161 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


    }


    public static int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sumAtEachLevelmap = new HashMap<>();
        dfs(root,sumAtEachLevelmap,1);
        System.out.println(sumAtEachLevelmap);
        int maxLevelSum =sumAtEachLevelmap.get(1);
        int maxLevel =1;
        for (int level : sumAtEachLevelmap.keySet()) {
            // System.out.println(level);
            // System.out.println(sumAtEachLevelmap.get(level));
            if (sumAtEachLevelmap.get(level) > maxLevelSum) {
                maxLevel =level;
                maxLevelSum = sumAtEachLevelmap.get(level);
            }
        }
        // System.out.println(maxLevelSum);
        // System.out.println(maxLevel);
        return maxLevel;

    }

    private static void dfs(TreeNode root, Map<Integer, Integer> sumAtEachLevelmap,int level) {
        if (root != null) {
           if(sumAtEachLevelmap.containsKey(level)) {
               sumAtEachLevelmap.put(level,sumAtEachLevelmap.get(level)+root.val);
           }else {
               sumAtEachLevelmap.put(level,root.val);
           }
            dfs(root.left, sumAtEachLevelmap, level+1);
            dfs(root.right, sumAtEachLevelmap,level+1);
        }
    }
}

 class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
   TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
       this.right = right;
    }
}
