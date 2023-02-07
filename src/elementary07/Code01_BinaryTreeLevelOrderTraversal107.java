package elementary07;

import elementary06.Code06_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Juli
 * @date ： 2023/2/7 12:01 PM
 * @description： 二叉树的层序遍历
 * 107 从下往上 levelOrderBottom
 * 102 从上往下 levelOrder
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code01_BinaryTreeLevelOrderTraversal107 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curLevel);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curLevel);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curLevel);
        }
        return ans;
    }


}
