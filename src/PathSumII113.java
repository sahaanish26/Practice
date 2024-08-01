import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> chosenPath = new ArrayList<>();
        pathSumHelper(root,chosenPath,res,targetSum);
        return res;

    }

    private  void pathSumHelper1(TreeNode root, List<Integer> chosenPath, List<List<Integer>> res, int targetSum) {



        chosenPath.add(root.val);

        if (targetSum==root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(chosenPath));
        }

        List<TreeNode> neighbours = new ArrayList<>();
        if (root.left != null) {
            neighbours.add(root.left);
        }
        if (root.right != null) {
            neighbours.add(root.right);
        }
        for (TreeNode neighbour : neighbours) {
            pathSumHelper(neighbour,chosenPath,res,targetSum-root.val);

        }

        chosenPath.remove(chosenPath.size() - 1);

        };

    //this has better runtime and memory footprint in leetcode
    public void   pathSumHelper(TreeNode root, List<Integer> chosenPath, List<List<Integer>> res, int targetSum) {


        chosenPath.add(root.val);

        if (targetSum==root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(chosenPath));
        }


        // for (TreeNode neighbour : neighbours) {
        if (root.left != null) {
            pathSumHelper(root.left,chosenPath,res,targetSum-root.val);
        }
        if (root.right != null) {
            pathSumHelper(root.right,chosenPath,res,targetSum-root.val);

        }


        // }

        chosenPath.remove(chosenPath.size() - 1);

    }


    public boolean   pathSumHelperBoolean(TreeNode root, List<Integer> chosenPath, List<List<Integer>> res, int targetSum) {



        chosenPath.add(root.val);

        if (targetSum==root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(chosenPath));
            return true;
        }


        // for (TreeNode neighbour : neighbours) {
        if (root.left != null) {
           boolean result1= pathSumHelperBoolean(root.left,chosenPath,res,targetSum-root.val);
           if (result1) {
               return true;
           }
        }
        if (root.right != null) {
            boolean result2 = pathSumHelperBoolean(root.right,chosenPath,res,targetSum-root.val);
            if (result2) {
                return true;
            }
        }



        // }

        chosenPath.remove(chosenPath.size() - 1);
        return false;

    }

}

