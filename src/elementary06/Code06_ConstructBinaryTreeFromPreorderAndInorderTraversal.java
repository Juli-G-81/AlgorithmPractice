package elementary06;

import class06.Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;

/**
 * @author ：Juli
 * @date ： 2023/2/7 10:38 AM
 * @description：105 用先序数组和中序数组重建一棵树
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code06_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || (pre.length != in.length)) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {

        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;

        for (; in[find] != pre[L1]; find++) ;
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;

    }


    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || (pre.length != in.length)) {
            return null;
        }
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++){
            inMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, inMap);
    }

    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> inMap) {

        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = inMap.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, inMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, inMap);
        return head;

    }

}
