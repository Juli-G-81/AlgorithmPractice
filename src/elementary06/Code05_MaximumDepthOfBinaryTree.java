package elementary06;

/**
 * @author ：Juli
 * @date ： 2023/2/7 11:14 AM
 * @description：二叉树最大深度
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code05_MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getMaxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
