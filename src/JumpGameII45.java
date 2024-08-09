import java.util.*;

public class JumpGameII45 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 2,3,1,1,4};
       // int[] intArray2 = new int[]{ 0,2};
      //  int[] intArray3 = new int[]{ 1,3};
      //  int[] intArray4 = new int[]{ 0,2};

       // int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };

      /*  int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };
*/



        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ jump(intArray1) );

    }

    public static int jump(int[] nums) {

        int result =jumpHelperBfs(0,nums.length-1,nums);
        return result;
    }

    private static int jumpHelperBfs(int sourceIndex, int targetIndex, int[] nums) {
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(sourceIndex);
        Map<Integer,Integer> levelMap = new HashMap<>();
        levelMap.put(sourceIndex,0);
        Set<Integer> visitedIndices = new HashSet<>();

        while (!queue.isEmpty()) {
           System.out.println("queue :"+queue);
            int currentIndex = queue.poll();
            visitedIndices.add(currentIndex);
            if (currentIndex == targetIndex) {
                return levelMap.get(currentIndex);
            }
            int maxPossibleJump =nums[currentIndex];
            System.out.println("maxPossibleJump:"+maxPossibleJump);
            List<Integer> neighBourIndices = new ArrayList<>();
            if(maxPossibleJump>0) {
                for (int i = maxPossibleJump; i >= 1; i--) {
                    int potentialJumpIndex = i+currentIndex;
                    System.out.println("potentialJumpIndex:"+potentialJumpIndex);
                    if(potentialJumpIndex>=0 && potentialJumpIndex<nums.length && !visitedIndices.contains(potentialJumpIndex) ){
                        neighBourIndices.add(potentialJumpIndex);
                    }

                }
            }
            System.out.println(neighBourIndices);
            for (Integer neighbourIndex : neighBourIndices) {

                    if (!levelMap.containsKey(neighbourIndex)) {
                        int levelOfNeighbour = levelMap.get(currentIndex)+1;
                        levelMap.put(neighbourIndex,levelOfNeighbour);
                    }
                    queue.add(neighbourIndex);


            }
        }

return -1;
    }


}
