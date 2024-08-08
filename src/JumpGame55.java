import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JumpGame55 {


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> allPath= new ArrayList<>();
        return  canJumpHelper(0,nums.length-1,nums,visited);


    }

    private boolean canJumpHelper(int sourceIndex, int targetIndex, int[] nums , Set<Integer> visited) {
        // path.add(nums[sourceIndex]);
        visited.add(sourceIndex);
        if(sourceIndex == targetIndex){
            //   allPath.add(new ArrayList<>(path));
            return true;
        }

        int maxReach=nums[sourceIndex];
        if(maxReach>0) {
            for (int i = maxReach; i > 0; i--) {
                int nextTargetIndex = sourceIndex + i;
                if (nextTargetIndex >= 0 && nextTargetIndex < nums.length && !visited.contains(nextTargetIndex)) {
                    boolean var = canJumpHelper(nextTargetIndex, targetIndex, nums, visited);
                    if (var) {
                        return true;
                    }
                }
            }
        }
        // path.remove(path.size()-1);
        return false;
    }

}
