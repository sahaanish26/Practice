import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindLargestvalueinEachTreeRow515 {

    public List<Integer> largestValues(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        largestValuesHelper(root,map,0);
        System.out.println("map"+map);
    List<Integer> res = new ArrayList<>();
    for (int key : map.keySet()) {
        res.add(map.get(key));
    }
    return res;
    }

    private void largestValuesHelper(TreeNode root, TreeMap<Integer, Integer> map, int level) {
        if (root != null) {
            if (!map.containsKey(level)) {
                map.put(level,root.val);
            }else{
                if(map.get(level)<root.val){
                    map.put(level,root.val);
                }
            }
            largestValuesHelper(root.left,map,level+1);
            largestValuesHelper(root.right,map,level+1);
        }


    }
}
