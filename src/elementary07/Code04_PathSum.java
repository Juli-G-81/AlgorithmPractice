package elementary07;

/**
 * @author ：Juli
 * @date ： 2023/2/13 3:44 PM
 * @description：判断是否存在路径和为n的路径
 * @modifiedBy ：
 * @version:
 */
public class Code04_PathSum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPath(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, targetSum);
        return isSum;
    }

    public static void process(TreeNode x, int preSum, int sum) {
        // x是叶子节点的时候
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }
        // X是非叶子节点的时候
        preSum += x.val;
        if (x.left!= null){
            process(x.left, preSum, sum);
        }
        if (x.right!= null){
            process(x.right, preSum, sum);
        }

    }

}
