import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeLevelOrderTraversalII107 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>(Collections.reverseOrder());
        levelOrderBottomHelper(root,levelMap,0);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : levelMap.values()) {
            res.add(list);
        }
        return res;
    }

    private static void levelOrderBottomHelper(TreeNode root, TreeMap<Integer, List<Integer>> levelMap, int level) {
        if (root != null) {

            List<Integer> listOfNodesAtLevel = levelMap.getOrDefault(level,new ArrayList<>());
            listOfNodesAtLevel.add(root.val);
            levelMap.put(level,listOfNodesAtLevel);
            levelOrderBottomHelper(root.left,levelMap,level+1);
            levelOrderBottomHelper(root.right,levelMap,level+1);
        }
    }
}




