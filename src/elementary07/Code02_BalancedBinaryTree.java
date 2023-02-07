package elementary07;

/**
 * @author ：Juli
 * @date ： 2023/2/7 12:43 PM
 * @description：110 判断是否为平衡搜索二叉树
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code02_BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Info{
        public boolean isBalance;
        public int height;
        public Info(boolean b, int h){
            isBalance = b;
            height = h;
        }
    }

    public static boolean isBalance(TreeNode root){
        return process(root).isBalance;
    }

    public static Info process(TreeNode root){
        if (root == null){
            return new Info(true, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        boolean isBalance = Math.abs(leftInfo.height-rightInfo.height)<2 && leftInfo.isBalance &&rightInfo.isBalance;
        return new Info(isBalance, height);
    }
}
