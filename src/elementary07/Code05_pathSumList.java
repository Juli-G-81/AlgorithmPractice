package elementary07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Juli
 * @date ： 2023/2/13 4:45 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Code05_pathSumList {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void process(TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        // 叶子节点
        if (x.left == null && x.right == null) {
            if (preSum + x.val == sum) {
                path.add(x.val);
                ans.add(copyPath(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        // 非叶子节点
        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);

    }

    public static List<Integer> copyPath(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }

}
