package elementary07;

/**
 * @author ：Juli
 * @date ： 2023/2/7 1:12 PM
 * @description：98.判断是否为搜索二叉树
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code03_BinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int max, int min) {
            this.isBST = is;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);


        int max = root.val;
        int min = root.val;

        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }

        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }

        boolean leftMaxLessThanRoot = leftInfo == null ? true : (leftInfo.max < root.val);
        boolean rightMinMoreThanRoot = rightInfo == null ? true : (rightInfo.min > root.val);
        if (!leftMaxLessThanRoot || !rightMinMoreThanRoot){
            isBST = false;
        }
        return new Info(isBST, max, min);
    }
}
