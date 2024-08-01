public class Sumroottoleafnumbers129    {


    public int sumNumbers(TreeNode root) {
         int[] result = new int[1];
         StringBuilder sbPath =  new StringBuilder();
        sumNumbersHelper(root,sbPath,result);
        if (root==null) return 0;
        return result[0];
    }

    private void sumNumbersHelper(TreeNode root, StringBuilder sbPath, int[] result) {
        sbPath.append(root.val);
     if(root.left==null && root.right==null) {
    result[0]+=Integer.parseInt(sbPath.toString());
}
     if(root.left!=null) {

         sumNumbersHelper(root.left,sbPath,result);
     }
     if(root.right!=null) {
         sumNumbersHelper(root.right,sbPath,result);
     }
     sbPath.deleteCharAt(sbPath.length()-1);
    }
}
